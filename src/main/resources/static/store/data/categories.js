const app = Vue.createApp({
    data() {
        return {
            message: 'Hello Vue!',
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
                    console.log(this.dataPro);
                })
        }

        if (subcategory != null) {
            axios.get(`/api/products/subcategory?subcategory=` + subcategory)
                .then(dataAcc => {
                    this.dataPro = dataAcc.data
                    console.log(this.dataPro);
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

    },
}).mount('#app')

