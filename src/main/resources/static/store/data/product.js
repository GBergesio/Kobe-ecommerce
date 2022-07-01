const app = Vue.createApp({

    data() {
        return {
            message: 'Hello Vue!',
            product: {},
            offMessage: ' 15% OFF',
            // LocalStorage Products
            cartStorage: [],

            productsCartStorage: [],
            productsCartId: [],
            subtotalCart: 0,
            totalPurchase: 0,

            // LocalStorage Favs
            favStorage: [],

            productsFavStorage: [],
            productsFavId: [],

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
        addProductFav(product) {
            this.productsFavId = this.favStorage.map((product) => product.id);
            if (!this.productsFavId.includes(product.id)) {
                product.quantity = 1;
                this.favStorage.push(product);
                localStorage.setItem("fav", JSON.stringify(this.favStorage));
            }
            Swal.fire({
                position: "top-end",
                icon: "success",
                width: "30%",
                padding: "1rem",
                background: "#ECC038",
                backdrop: false,
                title: "Producto agregado a favoritos",
                showConfirmButton: false,
                toast: true,
                timer: 1500,
                timerProgressBar: true,
            });
        },
        deleteProductFav(product) {
            this.productsFavId = this.productsFavStorage;
            if (!this.productsFavId.includes(product.id)) {
                this.favStorage.pop(product);
                localStorage.setItem("fav", JSON.stringify(this.favStorage));
            }
        },
        addProductCart(product) {
            this.productsCartId = this.cartStorage.map((product) => product.id);
            if (!this.productsCartId.includes(product.id)) {
                product.quantity = 1;
                this.cartStorage.push(product);
                localStorage.setItem("cart", JSON.stringify(this.cartStorage));
            }
            Swal.fire({
                position: "top-end",
                icon: "success",
                width: "20%",
                padding: "1rem",
                background: "#ECC038",
                backdrop: false,
                title: "Producto agregado al carrito",
                showConfirmButton: false,
                toast: true,
                timer: 1500,
                timerProgressBar: true,
            }).catch(function (error) {
                Swal.fire({
                    position: "top-end",
                    icon: "error",
                    title: "Stock no disponible",
                    showConfirmButton: false,
                    timer: 1500,
                });
            });

            Swal.fire({
                position: "top-end",
                icon: "success",
                width: "30%",
                padding: "1rem",
                background: "#ECC038",
                backdrop: false,
                title: "Guardado",
                showConfirmButton: false,
                toast: true,
                timer: 1500,
                timerProgressBar: true,
            }).catch(function (error) {
                Swal.fire({
                    position: "top-end",
                    icon: "error",
                    title: "Stock no disponible",
                    showConfirmButton: false,
                    timer: 1500,
                });
            });
        },
        addProductCartModal(product) {
            let input = document.getElementById(`${product.id}`);
            this.productsCartId = this.cartStorage.map((product) => product.id);
            if (!this.productsCartId.includes(product.id)) {
                product.quantity = input.value;
                this.cartStorage.push(product);
                localStorage.setItem("cart", JSON.stringify(this.cartStorage));
            }
            input.value = 1;
        },
        deleteProductCart(product) {
            this.productsCartStorage = this.productsCartStorage.filter(
                (prod) => prod.id !== product.id
            );
            this.cartStorage = this.productsCartStorage;
            localStorage.setItem("cart", JSON.stringify(this.productsCartStorage));
        },
        emptyCart() {
            this.cartStorage = [];
            localStorage.removeItem("cart");
        },
        sumCart(productCart) {
            let localS = JSON.parse(localStorage.getItem("cart"));
            let localSCopy = [...localS];
            let localSFilterToModify = localS.filter(
                (product) => product.id == productCart.id
            );

            if (productCart.stock > productCart.quantity) {
                localSFilterToModify[0].quantity = ++productCart.quantity;
            } else {
                Swal.fire({
                    position: "top-end",
                    icon: "error",
                    title: "Stock no disponible",
                    showConfirmButton: false,
                    timer: 1500,
                });
            }
            let localScopyFiltered = localSCopy.filter(
                (prod) => prod.id != productCart.id
            );
            localScopyFiltered.push(localSFilterToModify[0]);
            localStorage.clear();
            localStorage.setItem("cart", JSON.stringify(localScopyFiltered));
        },
        minusCart(productCart) {
            let localS = JSON.parse(localStorage.getItem("cart"));
            let localSCopy = [...localS];
            let localSFilterToModify = localS.filter(
                (product) => product.id == productCart.id
            );

            if (productCart.quantity > 1) {
                localSFilterToModify[0].quantity = --productCart.quantity;
            }

            let localScopyFiltered = localSCopy.filter(
                (prod) => prod.id != productCart.id
            );
            localScopyFiltered.push(localSFilterToModify[0]);
            localStorage.clear();
            localStorage.setItem("cart", JSON.stringify(localScopyFiltered));
        },
        editQuantity(productCart) {
            let input = document.getElementById(`${productCart.id}`);

            let localS = JSON.parse(localStorage.getItem("cart"));
            let localSCopy = [...localS];
            let localSFilterToModify = localS.filter(
                (product) => product.id == productCart.id
            );

            if (
                productCart.quantity != input.value &&
                input.value <= productCart.stock
            ) {
                localSFilterToModify[0].quantity = input.value;
            }

            let localScopyFiltered = localSCopy.filter(
                (prod) => prod.id != productCart.id
            );
            localScopyFiltered.push(localSFilterToModify[0]);
            localStorage.clear();
            localStorage.setItem("cart", JSON.stringify(localScopyFiltered));
        },
    },
    computed: {
        sumPrice() {
            this.subtotalCart = 0;
            this.cartStorage.forEach((product) => {
                this.subtotalCart += product.price * product.quantity;
            });
            return this.subtotalCart;
        },
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