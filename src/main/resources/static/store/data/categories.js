const app = Vue.createApp({
    data() {
        return {
            message: 'Hello Vue!',

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
    },
    methods: {

    },
    computed: {

    },
}).mount('#app')

