const app = Vue.createApp({

    data() {
        return {
            message: 'Hello Vue!',
            funkos: [
                {                   
                    name: "Funko Pop Harry Potter",
                    tag: "funkos",
                    description: "Funko edicion limitada de Harry Potter",
                    img: "https://http2.mlstatic.com/D_NQ_NP_887637-MLA48532306800_122021-O.webp",
                    price: "15500",
                    discount: "12500",
                    stock: 4,
                    category: "Personajes"
                },
                {
                    name: "Funko Pop Dragon Ball",
                    tag: "funkos",
                    description: "Funko edicion limitada de Dragon Ball",
                    img: "https://m.media-amazon.com/images/I/41zhiVnTEVS._SL500_.jpg",
                    price: "12500",
                    discount: "9500",
                    stock: 2,
                    category: "Personajes"
                },
                {
                    name: "Funko Pop YuGiOh - Yugi Moto",
                    tag: "funkos",
                    description: "Funko edicion limitada de YuGiOh",
                    img: "https://http2.mlstatic.com/D_NQ_NP_770341-MLA43442443560_092020-O.jpg",
                    price: "7200",
                    discount: "5500",
                    stock: 5,
                    category: "Personajes"
                },
                {
                    name: "Funko Pop SpiderMan",
                    tag: "funkos",
                    description: "Funko edicion limitada de SpiderMan",
                    img: "http://d3ugyf2ht6aenh.cloudfront.net/stores/910/199/products/funko-spiderman-220-spiderman1-e153bf88028a48526a16459148872529-640-0.jpg",
                    price: "12800",
                    discount: "10500",
                    stock: 14,
                    category: "Personajes"
                },
                {
                    name: "Funko Pop Batman Justice League",
                    tag: "funkos",
                    description: "Funko edicion limitada de Batman ",
                    img: "https://juguetestoday.com/32953-large_default/funko-batman-jumbo.jpg",
                    price: "14800",
                    discount: "12500",
                    stock: 3,
                    category: "Personajes"
                }
            ]
        }
    },
    created() {

    },
    methods: {

    },
    computed: {

    },
}).mount('#app')



