const app = Vue.createApp({

    data() {
        return {
            message: 'Hello Vue!',
            client:{},
            addresses:{},
            purchases:{},
        }
    },
    created() {
        axios.get(`/api/clients/current`)
        .then(data => {
            this.client = data.data
            this.addresses = data.data.addresses
            this.purchases = data.data.purchases
        })
        console.log(this.client);
    },
    methods: {

    },
    computed: {

    },
}).mount('#app')