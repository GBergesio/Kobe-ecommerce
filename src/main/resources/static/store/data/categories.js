const app = Vue.createApp({
    data() {
        return {
            message: 'Hello Vue!',
            searchWord: "",
            searchMessage: "",

            products:[],
            filteredProducts: [],
            sortType:"",
            minPrice:"",
            maxPrice:"",

        }
    },
    created() {
        const urlParams = new URLSearchParams(window.location.search);
        const category = urlParams.get('category')
        const subcategory = urlParams.get('subcategory')
        const busqueda = urlParams.get('busqueda')

        this.dynamicLoadData(category, subcategory)
    },
    methods: {
        dynamicLoadData(category, subcategory){
            if(category == null && subcategory == null){
                this.loadProducts(null, null)
            }
            else if(category != null){
                this.loadProducts("category", category)
            }
            else{
                this.loadProducts("subcategory", subcategory)
            }
        },
        async loadProducts(apiFilterName, apiFilterValue){
            try {
                let url = `/api/products`
                if(apiFilterValue != null){
                    url = `/api/products/${apiFilterName}?${apiFilterName}=${apiFilterValue}`
                }
                const {data} = await axios.get(url)
                this.products = data
                this.filteredProducts = data

            } catch (error) {
              console.log(error.response.data)
            } 
        },

        //filtro por palabra
        async findMatch(){
            if(this.searchWord != "" && this.searchWord.length > 3){
                await this.getFilteredProducts()
            }
            else{
                Swal.fire({
                    position: 'top-start',
                    icon: 'success',
                    width: '30%',
                    padding: '1rem',
                    background: '#ECC038',
                    backdrop: false,
                    title: 'Debes ingresar mas de 4 letras',
                    showConfirmButton: false,
                    toast: true,
                    timer: 2500,
                    timerProgressBar: true,
                  })
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
    },

    
    computed: {
    
    }
}).mount('#app')

