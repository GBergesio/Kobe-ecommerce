const app = Vue.createApp({
    data() {
        return {
            message: 'Hello Vue!',
            searchWord: "",

            products:[],
            filteredProducts: [],
            sortType:"",
            minPrice:"",
            maxPrice:"",
            
            // productosFiltro1:[],
            // productosFiltro2:[],
            // productosShop:[],

            // filteredProducts: [],

        }
    },
    created() {
        // const urlParams = new URLSearchParams(window.location.search);
        // const category = urlParams.get('category')
        // const subcategory = urlParams.get('subcategory')
        // const busqueda = urlParams.get('busqueda')

        // if (category != null) {
        //     axios.get(`/api/products/category?category=` + category)
        //         .then(dataAcc => {
        //             this.products = dataAcc.data
        //             this.filteredProducts = dataAcc.data
        //             console.log(this.products)
        //         })
        // }

        // if (subcategory != null) {
        //     axios.get(`/api/products/subcategory?subcategory=` + subcategory)
        //         .then(dataAcc => {
        //             this.products = dataAcc.data
        //             this.filteredProducts = dataAcc.data
        //             console.log(this.products)
        //         })
        // }

        let dataMap = new Map();
        dataMap.set(1, 3)
    
        const article = { 
            orders: dataMap.fromEntries,
            address: "av siempre viva 123 5 A",
            zipCode: "1010",
            totalAmount: 5000,
            typePayment: "DEBIT"
        }
        console.log(article)

        axios.post('/api/purchases', article,{headers:{'content-type':'application/json'}}).then(data => {
            console.log(data['data']);
})
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
              this.filteredProducts = this.filterByWordSearch(data)

            } catch (error) {
              console.log(error.response.data)
            } 
        },
        //
        filterProducts(){
            if(this.filteredProducts.length == 0 || this.filteredProducts.length != this.products.length){
                this.filteredProducts = Array.from(this.products)
            }
            this.filterByPrice()
            this.sortBy(this.sortType)
        },
        sortBy(){
            switch (this.sortType) {
                case "AZ":
                    this.filteredProducts = this.filteredProducts.sort((a,b) => { if (a.name > b.name) { return 1 } else if (a.name < b.name) { return -1 } })
                    console.log(this.filteredProducts)
                    break;

                case "ZA":
                    this.filteredProducts = this.filteredProducts.sort((a,b) => { if (a.name < b.name) { return 1 } else if (a.name > b.name) { return -1 } })
                    console.log(this.filteredProducts)
                    break;

                case "SMa": 
                    this.filteredProducts = this.filteredProducts.sort((a,b) => b.stock - a.stock)
                    console.log(this.filteredProducts)
                    break;

                case "SMe":
                    this.filteredProducts = this.filteredProducts.sort((a,b) => a.stock - b.stock)
                    console.log(this.filteredProducts)
                    break;

                default:
                    break;
              }
        },
        filterByPrice(){
            if(this.minPrice != ""){
                if(this.maxPrice != "" && this.maxPrice > this.minPrice){
                    this.filteredProducts = this.filteredProducts.filter(product => product.price >= this.minPrice && product.price <= this.maxPrice)
                    console.log(this.filteredProducts)
                }
                else{
                    this.filteredProducts = this.filteredProducts.filter(product => product.price >= this.minPrice)
                    console.log(this.filteredProducts)
                }
            }
            console.log(this.products)
            
        },

//pago prueba
        // async purchase(){
        //     try {
                
        //       await axios.post("/api/purchases"),
        //       {
        //         orders: {
        //             1: 15,
        //             2: 7,
        //             3: 2
        //         },
        //         address: "av siempre viva 123 5 A",
        //         zipCode: "1010",
        //         totalAmount: 5000,
        //         typePayment: "DEBIT"
        //     },{headers:{'content-type':'application/json'}}

        //     console.log("compra hecha")
            
        //     } catch (error) {
        //       console.log(error.response.data)
        //     } 
        // },
    },

    
    computed: {
        // filtroProductos(){
        //     if(this.filter == "Default"){
        //         this.productosFiltro1 = this.products
        //         console.log(this.productosFiltro1);
        //     }else if(this.filter == "ZA"){
        //         this.productosFiltro1 = this.products.sort((a,b) => { if (a.name < b.name) { return 1 } else if (a.name > b.name) { return -1 } })
        //         console.log(this.productosFiltro1);
        //     }else if(this.filter == "AZ"){
        //         this.productosFiltro1 = this.dataPro.sort((a,b) => { if (a.name > b.name) { return 1 } else if (a.name < b.name) { return -1 } })
        //         console.log(this.productosFiltro1);
        //     }else if(this.filter == "SMa"){
        //         this.productosFiltro1 = this.dataPro.sort((a,b) => b.stock - a.stock)
        //         console.log(this.productosFiltro1);
        //     }else if(this.filter == "SMe"){
        //         this.productosFiltro1 = this.dataPro.sort((a,b) => a.stock - b.stock)
        //         console.log(this.productosFiltro1);
        //     }
        //     this.filtroPrecio(this.)
            
        // },
    
    }
}).mount('#app')

