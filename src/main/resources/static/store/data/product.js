const app = Vue.createApp({

    data() {
        return {
            message: 'Hello Vue!',
            product: {},
            offMessage: ' 15% OFF'
        }
    },
    created() {
        const urlParams = new URLSearchParams(window.location.search);
        const id = urlParams.get('id')

        axios.get(`/api/products/` + id)
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

// axios.get(`http://localhost:8080/api/clients/current/accounts/`+ id)
// .then(dataAcc => {
//     this.dataAccount = dataAcc.data
//     this.accNumber = this.dataAccount.number
//     this.dataBalance = this.dataAccount.balance
//     this.transactions = this.dataAccount.transactionDTO
//     this.sortTransactions()
// })