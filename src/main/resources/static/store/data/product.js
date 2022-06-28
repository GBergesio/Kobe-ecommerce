const app = Vue.createApp({

    data() {
        return {
            message: 'Hello Vue!',
            product: {}
        }
    },
    created() {
        const urlParams = new URLSearchParams(window.location.search);
        const product = urlParams.get('product')

        axios.get(`/api/products/category?category=` + product)
            .then(productP => {
                this.product = productP.data
                console.log(this.product);
            })
    },
    methods: {

    },
    computed: {

    },
}).mount('#app')

