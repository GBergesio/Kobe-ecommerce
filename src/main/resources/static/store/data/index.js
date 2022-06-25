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
        }
    },
    created() {

        this.productsCartStorage = JSON.parse(localStorage.getItem("cart"))
        if (this.productsCartStorage) {
            this.cartStorage = this.productsCartStorage
        }


    },
    methods: {
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





    },
    computed: {
        sumPrice() {
            let priceProducts = 0
            this.cartStorage.forEach(product => {
                priceProducts += product.price
            })
            return priceProducts
        },

    },
}).mount('#app')


// no funca
// addProd(product){
//     let newProduct = product

//     this.productsCartId = this.cartStorage.map(prod => prod.id)
//     const addProductToCart = (array) =>{
//         if (!this.productsCartId.includes(newProduct.id)){
//             newProduct.quantity = 1;
//             let productIndex = this.arrayProducts(product.id, array);
//             newProduct.stock -=1;
//             newProduct.subtotal = newProduct.quantity * newProduct.price

//             this.cartStorage.push(newProduct);

//             array[productIndex].stock = newProduct.stock;
//             localStorage.setItem("cart", JSON.stringify(this.cartStorage));
//             this.subtotalAct();
//         }
//         else{
//             let productEx = this.cartStorage[this.searchProduct(newProduct.id)]

//             let stockIndex = this.arrayProducts(product.id, array);
//             console.log("Posicion en stock: " + stockIndex);

//             if(productEx.stock != 0){
//                 productEx.quantity +=1;
//                 productEx.stock -=1;
//                 productEx.subtotal = productEx.quantity * productEx.price;
//                 array[stockIndex].stock = productEx.stock;
//                 localStorage.setItem("cart", JSON.stringify(this.cartStorage));
//             }
//             else{
//                 console.log("no hay stock, poner Swal");
//             }
//         }
        
//     }
//     this.subtotalAct();
// },
// subtotalAct(){
//     let total = 0;
//     this.cartStorage.forEach(prod => {
//         total += prod.subtotal
//     })
//     this.subtotalCart = total;
// }

