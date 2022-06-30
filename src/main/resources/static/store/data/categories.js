const app = Vue.createApp({
    data() {
        return {
            message: 'Hello Vue!',
            dataPro:[],
            filter:"Default",
            minPrice:"",
            maxPrice:"",
            productosFiltro1:[],
            productosFiltro2:[],
            productosShop:[],
            searchWord: "",
            productsFilteredBySearch: []

        }
    },
    created() {
        const urlParams = new URLSearchParams(window.location.search);
        const category = urlParams.get('category')
        const subcategory = urlParams.get('subcategory')
        const busqueda = urlParams.get('busqueda')

        if (category != null) {
            axios.get(`/api/products/category?category=` + category)
                .then(dataAcc => {
                    this.dataPro = dataAcc.data
                    this.productosFiltro1 = this.dataPro
                    console.log(this.productosFiltro1);
                })
        }

        if (subcategory != null) {
            axios.get(`/api/products/subcategory?subcategory=` + subcategory)
                .then(dataAcc => {
                    this.dataPro = dataAcc.data
                    this.productosFiltro1 = this.dataPro
                    console.log(this.productosFiltro1);
                })
        }
        




    },
    methods: {
        

        //filtro por palabra
        async findMatch(){
            if(this.searchWord != ""){
                await this.getFilteredProducts()
                console.log(this.productsFilteredBySearch)
            }
        },
        filterByWordSearch(products){
            return products.filter(product => product.name.toLowerCase().includes((this.searchWord).toLowerCase()) || product.description.toLowerCase().includes((this.searchWord).toLowerCase()))
        },
        async getFilteredProducts(){
            try {
              const {data} = await axios.get("/api/products")
              this.productsFilteredBySearch = this.filterByWordSearch(data)

            } catch (error) {
              console.log(error.response.data)
            } 
        },
        //
    },
    
    computed: {
        filtroProductos(){
            if(this.filter == "Default"){
                this.productosFiltro1 = this.dataPro
                console.log(this.productosFiltro1);
            }else if(this.filter == "ZA"){
                this.productosFiltro1 = this.dataPro.sort((a,b) => { if (a.name < b.name) { return 1 } else if (a.name > b.name) { return -1 } })
                console.log(this.productosFiltro1);
            }else if(this.filter == "AZ"){
                this.productosFiltro1 = this.dataPro.sort((a,b) => { if (a.name > b.name) { return 1 } else if (a.name < b.name) { return -1 } })
                console.log(this.productosFiltro1);
            }else if(this.filter == "SMa"){
                this.productosFiltro1 = this.dataPro.sort((a,b) => b.stock - a.stock)
                console.log(this.productosFiltro1);
            }else if(this.filter == "SMe"){
                this.productosFiltro1 = this.dataPro.sort((a,b) => a.stock - b.stock)
                console.log(this.productosFiltro1);
            }
            
        },
        filtroPrecio(array){
            if(this.minPrice != "")
            {
            this.productosFiltro2 = array.filter(product => product.price >= this.minPrice)
            }
            if(this.maxPrice != "")
            {
            this.productosFiltro2 = array.filter(product => product.price <= this.maxPrice)
            }
        }
    },
}).mount('#app')

