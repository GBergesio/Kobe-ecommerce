const app = Vue.createApp({
    data() {
        return {
            message: 'Hello Vue!',
            searchWord: "",
            searchMessage: "",

            products: [],
            filteredProducts: [],
            sortType: "",
            minPrice: "",
            maxPrice: "",

            productSelect: {},
            // LocalStorage Products
            cartStorage: [],

            productsCartStorage: [],
            productsCartId: [],
            subtotalCart: 0,
            totalPurchase: 0,

            // LocalStorage Favs
            favStorage: [],

            productsFavStorage: [],
            productsFavId: [],


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
        const serie = urlParams.get('serie')
        const busqueda = urlParams.get('busqueda')
        this.dynamicLoadData(category, subcategory,serie)

        this.productsCartStorage = JSON.parse(localStorage.getItem("cart"))
        if (this.productsCartStorage) {
            this.cartStorage = this.productsCartStorage
        }
    },
    methods: {
        dynamicLoadData(category, subcategory,serie) {
            if (category == null && subcategory == null && serie == null) {
                this.loadProducts(null, null)
            }
            else if (category != null) {
                this.loadProducts("category", category)
            }
            else if (serie != null) {
                this.loadProducts("serie", serie)
            }
            else {
                this.loadProducts("subcategory", subcategory)
            }
        },
        async loadProducts(apiFilterName, apiFilterValue) {
            try {
                let url = `/api/products`
                if (apiFilterValue != null) {
                    url = `/api/products/${apiFilterName}?${apiFilterName}=${apiFilterValue}`
                }
                const { data } = await axios.get(url)
                this.products = data
                this.filteredProducts = data

            } catch (error) {
                console.log(error.response.data)
            }
        },

        //filtro por palabra
        async findMatch() {
            if (this.searchWord != "" && this.searchWord.length > 3) {
                await this.getFilteredProducts()
            }
            else {
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
        filterByWordSearch(products) {
            return products.filter(product => product.name.toLowerCase().includes((this.searchWord).toLowerCase()) || product.description.toLowerCase().includes((this.searchWord).toLowerCase()))
        },
        async getFilteredProducts() {
            try {
                const { data } = await axios.get("/api/products")
                this.filteredProducts = this.filterByWordSearch(data)

            } catch (error) {
                console.log(error.response.data)
            }
        },
        //
        filterProducts() {
            if (this.filteredProducts.length == 0 || this.filteredProducts.length != this.products.length) {
                this.filteredProducts = Array.from(this.products)
            }
            this.filterByPrice()
            this.sortBy(this.sortType)
        },

        sortBy() {
            switch (this.sortType) {
                case "AZ":
                    this.filteredProducts = this.filteredProducts.sort((a, b) => { if (a.name > b.name) { return 1 } else if (a.name < b.name) { return -1 } })
                    console.log(this.filteredProducts)
                    break;

                case "ZA":
                    this.filteredProducts = this.filteredProducts.sort((a, b) => { if (a.name < b.name) { return 1 } else if (a.name > b.name) { return -1 } })
                    console.log(this.filteredProducts)
                    break;

                case "SMa":
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
        productForModal(product) {
            this.productSelect = product
            return this.productSelect.name
        },
        addProductFav(product) {
            this.productsFavId = this.favStorage.map(product => product.id)
            if (!this.productsFavId.includes(product.id)) {
                product.quantity = 1
                this.favStorage.push(product)
                localStorage.setItem("fav", JSON.stringify(this.favStorage))
            }
            Swal.fire({
                position: 'top-end',
                icon: 'success',
                width: '30%',
                padding: '1rem',
                background: '#ECC038',
                backdrop: false,
                title: 'Agregado',
                showConfirmButton: false,
                toast: true,
                timer: 1500,
                timerProgressBar: true,
            })
        },
        deleteProductFav(product) {
            this.productsFavId = this.productsFavStorage
            if (!this.productsFavId.includes(product.id)) {
                this.favStorage.pop(product)
                localStorage.setItem("fav", JSON.stringify(this.favStorage))
            }
        },
        addProductCart(product) {
            this.productsCartId = this.cartStorage.map(product => product.id)
            if (!this.productsCartId.includes(product.id)) {
                product.quantity = 1
                this.cartStorage.push(product)
                localStorage.setItem("cart", JSON.stringify(this.cartStorage))
            }
            Swal.fire({
                position: 'top-end',
                icon: 'success',
                width: '30%',
                padding: '1rem',
                background: '#ECC038',
                backdrop: false,
                title: 'Guardado',
                showConfirmButton: false,
                toast: true,
                timer: 1500,
                timerProgressBar: true,
            })
                .catch(function (error) {
                    Swal.fire({
                        position: 'top-end',
                        icon: 'error',
                        title: 'Stock no disponible',
                        showConfirmButton: false,
                        timer: 1500
                    })
                })

            Swal.fire({
                position: 'top-end',
                icon: 'success',
                width: '30%',
                padding: '1rem',
                background: '#ECC038',
                backdrop: false,
                title: 'Guardado',
                showConfirmButton: false,
                toast: true,
                timer: 1500,
                timerProgressBar: true,
            })
                .catch(function (error) {
                    Swal.fire({
                        position: 'top-end',
                        icon: 'error',
                        title: 'Stock no disponible',
                        showConfirmButton: false,
                        timer: 1500
                    })
                })

        },
        addProductCartModal(product) {
            let input = document.getElementById(`${product.id}`)
            this.productsCartId = this.cartStorage.map(product => product.id)
            if (!this.productsCartId.includes(product.id)) {
                product.quantity = input.value
                this.cartStorage.push(product)
                localStorage.setItem("cart", JSON.stringify(this.cartStorage))
            }
            input.value = 1
        },
        deleteProductCart(product) {
            this.productsCartStorage = this.productsCartStorage.filter(prod => prod.id !== product.id)
            this.cartStorage = this.productsCartStorage
            localStorage.setItem("cart", JSON.stringify(this.productsCartStorage))
        },
        emptyCart() {
            this.cartStorage = [];
            localStorage.removeItem("cart");
        },
        sumCart(productCart) {
            let localS = JSON.parse(localStorage.getItem("cart"))
            let localSCopy = [...localS]
            let localSFilterToModify = localS.filter(product => product.id == productCart.id)

            if (productCart.stock > productCart.quantity) {
                localSFilterToModify[0].quantity = ++productCart.quantity
            }
            else {
                Swal.fire({
                    position: 'top-end',
                    icon: 'error',
                    title: 'Stock no disponible',
                    showConfirmButton: false,
                    timer: 1500
                })
            }
            let localScopyFiltered = localSCopy.filter(prod => prod.id != productCart.id)
            localScopyFiltered.push(localSFilterToModify[0])
            localStorage.clear()
            localStorage.setItem("cart", JSON.stringify(localScopyFiltered))
        },
        minusCart(productCart) {
            let localS = JSON.parse(localStorage.getItem("cart"))
            let localSCopy = [...localS]
            let localSFilterToModify = localS.filter(product => product.id == productCart.id)

            if (productCart.quantity > 1) {
                localSFilterToModify[0].quantity = --productCart.quantity
            }
            else {
                console.log("no se puede restar mas");
            }
            let localScopyFiltered = localSCopy.filter(prod => prod.id != productCart.id)
            localScopyFiltered.push(localSFilterToModify[0])
            localStorage.clear()
            localStorage.setItem("cart", JSON.stringify(localScopyFiltered))
            // console.log(localSFilterToModify);
        },
        editQuantity(productCart) {
            let input = document.getElementById(`${productCart.id}`);

            let localS = JSON.parse(localStorage.getItem("cart"))
            let localSCopy = [...localS]
            let localSFilterToModify = localS.filter(product => product.id == productCart.id)

            if (productCart.quantity != input.value && input.value <= productCart.stock) {
                localSFilterToModify[0].quantity = input.value
            }

            console.log(productCart)

            let localScopyFiltered = localSCopy.filter(prod => prod.id != productCart.id)
            localScopyFiltered.push(localSFilterToModify[0])
            localStorage.clear()
            localStorage.setItem("cart", JSON.stringify(localScopyFiltered))
        },
    },


    computed: {

    }
}).mount('#app')

