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
                },
                
            ],

            // Products
            products: [],
            // Select para filtrar
            shopSelect: "",
            // Subcategories para tomar falopa
            dataPro: []
        }
    },
    created() {
        const urlParams = new URLSearchParams(window.location.search);
        const category = urlParams.get('category')

        axios.get(`/api/products/category?category=` + category)
        .then(dataAcc => {
            this.dataPro = dataAcc.data
            console.log(this.dataPro);
        })
        .catch(err => console.log(err))

        axios.get(`/api/products`)
        .then(data => this.products = data.data)
        .catch(err => console.log(err))
    
    },
    methods: {           
        sort() {
            if(this.shopSelect  == "AZ") {
                this.products.sort((a,b) => a.name < b.name ? -1 : null)
            }
            else if(this.shopSelect == "ZA") {
                this.products.sort((a,b) => a.name > b.name ? -1 : null)
            }
            else if(this.shopSelect == "STOCK") {
                this.products.sort((a,b) => a.stock > b.stock ? -1 : null)
            }
            else {
                this.products.sort( () => Math.random() - 0.5)
            }
        },
    },
    computed: {
        
    },
}).mount('#shop')