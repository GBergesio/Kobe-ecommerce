const app = Vue.createApp({

    data() {
        return {
            message: "hello vue!",
            //Register
            firstName: "",
            lastName: "",
            emailRegister: "",
            passwordRegister: "",

            // Login
            email: "",
            password: "",

            //
            provincias: ["Buenos Aires", "Jujuy", "Salta", "Chaco", "Formosa", "San Luis", "San Juan", "Mendoza", "Catamarca", "Sant. del Estero", "Tucuman", "Santa Fe", "Misiones", "Corrientes", "Cordoba", "Neuquen", "Rio Negro", "Tierra del Fuego", "Santa Cruz", "La Rioja", "Entre Rios", "La Pampa", "Chubut"],
        }
    },
    created() {

    },
    methods: {
        login() {
            let headers = {
                headers:
                {
                    'content-type': 'application/x-www-form-urlencoded'
                }
            };
            let url = `email=${this.email}&password=${this.password}`;
            axios.post('/api/login', url, headers)
                .then(response =>
                    setTimeout(function () {
                        window.location.href = './index.html'
                    }, 1000))
                .catch(error => 
                    Swal.fire({
                        icon: "error",
                        title: "Email o contraseña inválidos",
                        timer: 2000,
                    })
                    )
        },
        register() {
            let registerObject = {
                firstName: this.firstName,
                lastName: this.lastName,
                email: this.emailRegister,
                password: this.passwordRegister
            }
            axios.post('/api/clients', registerObject)
                .then(response =>
                    axios.post('/api/login', `email=${this.emailRegister}&password=${this.passwordRegister}`, { headers: { 'content-type': 'application/x-www-form-urlencoded' } })
                )
                .then(() =>
                    Swal.fire("Cuenta creada! Verifica tu email", "", "success")
                        .then(this.createPurchase())
                        .then(this.downloadFile())
                        .then(this.emptyCart())
                        // .then(() => window.location.href = './index.html')
                        .then(response =>
                            setTimeout(() => {
                                window.location.href = 'https://mail.google.com/'
                            }, 2000))
                )
                .catch((error) => {
                    Swal.fire({
                        icon: "error",
                        title: error.response.data,
                        timer: 2000,
                    });
                })
        }

    },
    computed: {

    },
}).mount('#app')

