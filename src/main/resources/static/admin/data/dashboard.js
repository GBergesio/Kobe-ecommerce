const app = Vue.createApp({

    data() {
        return {
            message: 'Hello Vue!',
            name: "",
            description: "",
            img: "",
            imgSec: "",
            stock: 0,
            price: 0,
            serie: "",
            category: "",
            subcategory: "",
            // Modificar productos
            productsBack: [],
            idProducto: "",
            priceActualizacion: "",
            stockActualizacion: "",
            priceModifierType: "",
            percentage: "",
            // Dashboard
            clients: [],
            purchases: [],
            totalVentas: [],
            sumaVentas: 0,
            sumaVentasCliente: 0,
            totalVentasCliente: []

        }
    },
    created() {
        axios.get(`/api/products`)
            .then(data => {
                this.productsBack = data.data
            })
        axios.get(`/api/clients`)
            .then(data => {
                this.clients = data.data
                // console.log(this.clients);
            })
        axios.get(`/api/purchases`)
            .then(data => {
                this.purchases = data.data
                let ventas = this.purchases
                this.totalVentas = []
                ventas.forEach(compra => {
                    this.totalVentas.push(compra.totalAmount)
                })
                let sum = 0;
                for (let i = 0; i < this.totalVentas.length; i++) {
                    sum += this.totalVentas[i];
                }
                this.sumaVentas = sum
            })

    },
    methods: {
        createNewProduct() {
            let newProduct = {
                name: this.name,
                description: this.description,
                img: this.img,
                imgSec: this.imgSec,
                stock: this.stock,
                price: this.price,
                serie: this.serie,
                category: this.category,
                subcategory: this.subcategory,
            }
            Swal.fire({
                title: 'Confirmación de creacion de producto',
                text: "Deseas crear un producto nuevo?",
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Si, crear producto'
            }).then((result) => {
                if (result.isConfirmed) {
                    axios.post('/api/products', newProduct)
                        .catch(function (error) {
                            this.error = error.response.data
                        })
                        .then(
                            setTimeout(function () {
                                if (this.error == "Missing data" || this.error == "the price cannot be negative") {
                                    Swal.fire({
                                        title: "Error",
                                        text: `${this.error}`,
                                        icon: "error"
                                    })
                                    this.error = ""
                                } else {
                                    Swal.fire({
                                        title: "Nuevo producto",
                                        text: "Nuevo producto creado",
                                        icon: "success"
                                    })
                                    setTimeout(function () {
                                        location.reload()
                                    }, 1000)
                                }
                            }, 1000))
                }
            })
        },
        modifyProduct() {
            Swal.fire({
                title: 'Actualizacion de producto',
                text: "Deseas actualizar este producto?",
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Si, actualizar producto'
            }).then((result) => {
                if (result.isConfirmed) {
                    axios.patch('/api/products/modify', `productId=${this.idProducto}&price=${this.priceActualizacion}&img=${this.img}&imgSec=${this.imgSec}&description=${this.description}&stock=${this.stockActualizacion}`)
                        .catch(function (error) {
                            this.error = error.response.data
                            Swal.fire({
                                title: "Error",
                                text: `${this.error}`,
                                icon: "error"
                            })
                            this.error = ""
                        })
                        .then(
                            setTimeout(function () {
                                Swal.fire({
                                    title: "Actualización de producto",
                                    text: "Producto actualizado",
                                    icon: "success"
                                })
                                setTimeout(function () {
                                    location.reload()
                                }, 1000)
                            }, 1000))
                }
            })
        },
        deleteProduct() {
            Swal.fire({
                title: 'Eliminación de producto',
                text: "Deseas eliminar este producto?",
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Si, eliminar producto'
            }).then((result) => {
                if (result.isConfirmed) {
                    axios.patch('/api/products/delete', `id=${this.idProducto}`)
                        .catch(function (error) {
                            this.error = error.response.data
                            Swal.fire({
                                title: "Error",
                                text: `${this.error}`,
                                icon: "error"
                            })
                            this.error = ""
                        })
                        .then(
                            setTimeout(function () {
                                Swal.fire({
                                    title: "Eliminación de producto",
                                    text: "Producto eliminado",
                                    icon: "success"
                                })
                                setTimeout(function () {
                                    location.reload()
                                }, 1000)
                            }, 1000))
                }
            })
        },
        actPrices() {
            Swal.fire({
                title: 'Actualizacion masiva de precios',
                text: "Deseas actualizar todos los precios con este nuevo porcentage?",
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Si, actualizar'
            }).then((result) => {
                if (result.isConfirmed) {
                    axios.patch('/api/products/updatePrices', `percentage=${this.percentage}&priceModifier=${this.priceModifierType}`)
                        .catch(function (error) {
                            this.error = error.response.data
                            Swal.fire({
                                title: "Error",
                                text: `${this.error}`,
                                icon: "error"
                            })
                            this.error = ""
                        })
                        .then(
                            setTimeout(function () {
                                Swal.fire({
                                    title: "Actualizacion de precios",
                                    text: "Precios actualizados",
                                    icon: "success"
                                })
                                setTimeout(function () {
                                    location.reload()
                                }, 1000)
                            }, 1000))
                }
            })
        },
        totalComprado(cliente) {
            let compras = cliente.purchases
            this.totalVentasCliente = []
            compras.forEach(compra => {
                this.totalVentasCliente.push(compra.totalAmount)
            })
            let sum = 0;
            for (let i = 0; i < this.totalVentasCliente.length; i++) {
                sum += this.totalVentasCliente[i];
            }
            this.sumaVentasCliente = sum
            return this.sumaVentasCliente
        },

        // deleteClient(client) {
        //     Swal.fire({
        //         title: 'Eliminar cliente',
        //         text: "Deseas eliminar este cliente?",
        //         icon: 'warning',
        //         showCancelButton: true,
        //         confirmButtonColor: '#3085d6',
        //         cancelButtonColor: '#d33',
        //         confirmButtonText: 'Si, eliminar'
        //     }).then((result) => {
        //         if (result.isConfirmed) {
        //             axios.patch('/api/clients/xxx', `client=${this.clientxdxddx}`)
        //                 .catch(function (error) {
        //                     this.error = error.response.data
        //                     Swal.fire({
        //                         title: "Error",
        //                         text: `${this.error}`,
        //                         icon: "error"
        //                     })
        //                     this.error = ""
        //                 })
        //                 .then(
        //                     setTimeout(function () {
        //                         Swal.fire({
        //                             title: "Eliminar cliente",
        //                             text: "Cliente eliminado",
        //                             icon: "success"
        //                         })
        //                         setTimeout(function () {
        //                             location.reload()
        //                         }, 1000)
        //                     }, 1000))
        //         }
        //     })
        // },

    },
    computed: {

    },
}).mount('#app')


document.addEventListener("DOMContentLoaded", function (event) {

    const showNavbar = (toggleId, navId, bodyId, headerId) => {
        const toggle = document.getElementById(toggleId),
            nav = document.getElementById(navId),
            bodypd = document.getElementById(bodyId),
            headerpd = document.getElementById(headerId)

        // Validate that all variables exist
        if (toggle && nav && bodypd && headerpd) {
            toggle.addEventListener('click', () => {
                // show navbar
                nav.classList.toggle('show')
                // change icon
                toggle.classList.toggle('bx-x')
                // add padding to body
                bodypd.classList.toggle('body-pd')
                // add padding to header
                headerpd.classList.toggle('body-pd')
            })
        }
    }

    showNavbar('header-toggle', 'nav-bar', 'body-pd', 'header')

    /*===== LINK ACTIVE =====*/
    const linkColor = document.querySelectorAll('.nav_link')

    function colorLink() {
        if (linkColor) {
            linkColor.forEach(l => l.classList.remove('active'))
            this.classList.add('active')
        }
    }
    linkColor.forEach(l => l.addEventListener('click', colorLink))
});

