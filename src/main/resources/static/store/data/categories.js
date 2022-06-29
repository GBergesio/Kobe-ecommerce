const app = Vue.createApp({
    data() {
        return {
            message: 'Hello Vue!',

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

    },
    computed: {

    },
}).mount('#app')

