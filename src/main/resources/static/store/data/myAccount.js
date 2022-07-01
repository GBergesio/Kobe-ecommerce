const app = Vue.createApp({

    data() {
        return {
            message: 'Hello Vue!',
            client: {},
            addresses: {},
            purchases: {},

            codigoPostal: "",
            provincia: "",
            localidad: "",
            calle: "",
            numero: "",
            apartamento: "",

            provincias: ["Buenos Aires", "Jujuy", "Salta", "Chaco", "Formosa", "San Luis", "San Juan", "Mendoza", "Catamarca", "Sant. del Estero", "Tucuman", "Santa Fe", "Misiones", "Corrientes", "Cordoba", "Neuquen", "Rio Negro", "Tierra del Fuego", "Santa Cruz", "La Rioja", "Entre Rios", "La Pampa", "Chubut"],
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
        logOut() {
            axios.post('/api/logout')
                .then(response => setTimeout(() => {
                    window.location.href = './index.html'
                }, 1000))
        },
        addAddress() {
            const newAddress = {
                zipCode: this.codigoPostal,
                streetNumber: this.numero,
                floorApartment: this.apartamento,
                streetName: this.calle,
                province: this.provincia,
                locality: this.localidad
            }
            console.log(newAddress);
            axios.post('/api/newAddress', newAddress)
                .then(
                    Swal.fire({
                        position: 'center',
                        icon: 'success',
                        title: 'Tu nueva dirección se a añadido!',
                        showConfirmButton: false,
                        timer: 2000
                    })
                )
                .catch(error => {
                    Swal.fire({
                        position: 'center',
                        icon: 'error',
                        title: error.response.data,
                        showConfirmButton: false,
                        timer: 2000
                    })
                })
        },
        },
        computed: {

        },
    }).mount('#app')