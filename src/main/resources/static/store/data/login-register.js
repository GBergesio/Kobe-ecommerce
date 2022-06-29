const app = Vue.createApp({

    data() {
        return {
            message:"hello vue!",
            //Register
            firstName:"",
            lastName:"",
            emailRegister:"",
            passwordRegister:"",

            // Login
            email:"",
            password:"",

        }
    },
    created() {

    },
    methods: {
        login(){
            axios.post('/api/login',`email=${this.email}&password=${this.password}`,{headers:{'content-type':'application/x-www-form-urlencoded'}})
            .then(response =>
                setTimeout(function(){
                window.location.href='./index.html'
            },1000))
            .catch(error=> console.log(error))
        },
        register(){
            let registerObject = {
                firstName: this.firstName,
                lastName: this.lastName,
                email: this.emailRegister,
                password:this.passwordRegister
            }
            axios.post('/api/clientRegister',registerObject)
            .then(response => 
                axios.post('/api/login',`email=${this.emailRegister}&password=${this.passwordRegister}`,{headers:{'content-type':'application/x-www-form-urlencoded'}})
            )
            .then(response =>
                setTimeout(function(){
                window.location.href='./index.html'
            },1000))
            .catch(error=> console.log(error))
        },
        logOut(){
            axios.post('/api/logout')
            .then(response => setTimeout(function(){
                window.location.href='./index.html'
            },1000))
        },
    },
    computed: {

    },
}).mount('#app')

