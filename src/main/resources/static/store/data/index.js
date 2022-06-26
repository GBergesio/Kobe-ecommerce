const app = Vue.createApp({
    data() {
        return {
            message: 'Hello Vue!',
            funkos: [
                {
                    id: 1,
                    name: "Funko Pop Harry Potter",
                    tag: "funkos",
                    description: "Funko edicion limitada de Harry Potter",
                    img: "https://http2.mlstatic.com/D_NQ_NP_887637-MLA48532306800_122021-O.webp",
                    price: 15500,
                    discount: 12500,
                    stock: 4,
                    category: "Personajes"
                },
                {
                    id: 2,
                    name: "Funko Pop Dragon Ball",
                    tag: "funkos",
                    description: "Funko edicion limitada de Dragon Ball",
                    img: "https://m.media-amazon.com/images/I/41zhiVnTEVS._SL500_.jpg",
                    price: 12500,
                    discount: 9500,
                    stock: 2,
                    category: "Personajes"
                },
                {
                    id: 3,
                    name: "Funko Pop YuGiOh - Yugi Moto",
                    tag: "funkos",
                    description: "Funko edicion limitada de YuGiOh",
                    img: "https://http2.mlstatic.com/D_NQ_NP_770341-MLA43442443560_092020-O.jpg",
                    price: 7200,
                    discount: 5500,
                    stock: 5,
                    category: "Personajes"
                },
                {
                    id: 4,
                    name: "Funko Pop SpiderMan",
                    tag: "funkos",
                    description: "Funko edicion limitada de SpiderMan",
                    img: "http://d3ugyf2ht6aenh.cloudfront.net/stores/910/199/products/funko-spiderman-220-spiderman1-e153bf88028a48526a16459148872529-640-0.jpg",
                    price: 12800,
                    discount: 10500,
                    stock: 14,
                    category: "Personajes"
                },
                {
                    id: 5,
                    name: "Funko Pop Batman Justice League",
                    tag: "funkos",
                    description: "Funko edicion limitada de Batman ",
                    img: "https://juguetestoday.com/32953-large_default/funko-batman-jumbo.jpg",
                    price: 14800,
                    discount: 12500,
                    stock: 3,
                    category: "Personajes"
                }
            ],

            // LocalStorage Products
            cartStorage: [],

            productsCartStorage: [],
            productsCartId: [],
            subtotalCart: 0,


            // LocalStorage Favs
            favStorage: [],

            productsFavStorage: [],
            productsFavId: [],
            product: []
        }
    },
    created() {
        this.allProd()

        this.productsCartStorage = JSON.parse(localStorage.getItem("cart"))
        if (this.productsCartStorage) {
            this.cartStorage = this.productsCartStorage
        }


    },
    methods: {
        allProd(){
            axios.get(`/api/products`)
            .then(data =>{
                this.products = data
            })
        },


        addProductFav(product) {
            this.productsFavId = this.favStorage.map(product => product.id)
            if (!this.productsFavId.includes(product.id)) {
                product.quantity = 1
                this.favStorage.push(product)
                localStorage.setItem("fav", JSON.stringify(this.favStorage))
            }
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
        sumCart(productCart){
            let localS = JSON.parse(localStorage.getItem("cart"))
            let localSCopy = [...localS]
            let localSFilterToModify = localS.filter(product => product.id == productCart.id)

            if(productCart.quantity < productCart.stock){
                localSFilterToModify[0].quantity = ++productCart.quantity
            }
            else{
                console.log("no se puede agregar mas");
            }  
            let localScopyFiltered = localSCopy.filter(prod => prod.id != productCart.id)
            localScopyFiltered.push(localSFilterToModify[0])
            localStorage.clear()
            localStorage.setItem("cart", JSON.stringify(localScopyFiltered))
        },
        minusCart(productCart){
            let localS = JSON.parse(localStorage.getItem("cart"))
            let localSCopy = [...localS]
            let localSFilterToModify = localS.filter(product => product.id == productCart.id)

            if(productCart.quantity > 1){
                localSFilterToModify[0].quantity = --productCart.quantity
            }
            else{
                console.log("no se puede restar mas");
            }  
            let localScopyFiltered = localSCopy.filter(prod => prod.id != productCart.id)
            localScopyFiltered.push(localSFilterToModify[0])
            localStorage.clear()
            localStorage.setItem("cart", JSON.stringify(localScopyFiltered))
            console.log(localSFilterToModify);
        }




    },
    computed: {
        sumPrice() {
            let priceProducts = 0
            this.cartStorage.forEach(product => {
                priceProducts += (product.price) * (product.quantity)
            })
            return priceProducts
        },

    },
}).mount('#app')