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

            let headers = {headers:
                            {
                                'content-type':'application/x-www-form-urlencoded'
                            }
                          };
            let url = `email=${this.email}&password=${this.password}`;
            axios.post('/api/login', url, headers)
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
            axios.post('/api/clients',registerObject)
            .then(response => 
                axios.post('/api/login',`email=${this.emailRegister}&password=${this.passwordRegister}`,{headers:{'content-type':'application/x-www-form-urlencoded'}})
            )
            .then(response =>
                setTimeout(() => {
                window.location.href='https://mail.google.com/'
            },2000))
            .catch(error=> console.log(error))
        }
       
    },
    computed: {

    },
}).mount('#app')

