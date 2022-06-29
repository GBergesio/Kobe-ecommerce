// const urlParams = new URLSearchParams(window.location.search);
// const category = urlParams.get('category')

const app = Vue.createApp({
  data() {
    return {
      message: 'Hello Vue!',
      provincias: ["Buenos Aires", "Jujuy", "Salta", "Chaco", "Formosa", "San Luis", "San Juan", "Mendoza", "Catamarca", "Sant. del Estero", "Tucuman", "Santa Fe", "Misiones", "Corrientes", "Cordoba", "Neuquen", "Rio Negro", "Tierra del Fuego", "Santa Cruz", "La Rioja", "Entre Rios", "La Pampa", "Chubut"],

      // LocalStorage Products
      cartStorage: [],

      productsCartStorage: [],
      productsCartId: [],
      subtotalCart: 0,

      // LocalStorage Favs
      favStorage: [],

      productsFavStorage: [],
      productsFavId: [],

      /////

      productsBack: [],
      dataPro: [],
      lowStock: [],
      funkos: [],
      mangas: [],
      covers: [],
      productSelect: {},
      offMessage: ' 15% OFF'

    }
  },
  created() {
    axios.get(`/api/products`)
      .then(data => {
        this.productsBack = data.data

        this.productsLowStock()
        this.funkoFilter()
        this.coversFilter()
        this.mangasFilter()
        
      })

    this.productsCartStorage = JSON.parse(localStorage.getItem("cart"))
    if (this.productsCartStorage) {
      this.cartStorage = this.productsCartStorage
    }
  },
  mounted() {
  },
  methods: {
    productForModal(product) {
      this.productSelect = product
      return this.productSelect.name
    },
    productsLowStock() {
      let prodLowStockVar = this.productsBack
      this.lowStock = []
      prodLowStockVar.forEach(product => {
        if (product.stock <= 5) {
          this.lowStock.push(product)
        }
      })
    },
    funkoFilter() {
      let products = this.productsBack
      this.funkos = []
      products.forEach(product => {
        if (product.subcategory === "Funko POP!") {
          this.funkos.push(product)
        }
      })
    },
    coversFilter() {
      let products = this.productsBack
      this.covers = []
      products.forEach(product => {
        if (product.subcategory === "Iphone Cases") {
          this.covers.push(product)
        }
      })
    },
    mangasFilter() {
      let products = this.productsBack
      this.mangas = []
      products.forEach(product => {
        if (product.subcategory === "Static Figures") {
          this.mangas.push(product)
        }
      })
    },
    addProductFav(product) {
      this.productsFavId = this.favStorage.map(product => product.id)
      if (!this.productsFavId.includes(product.id)) {
        product.quantity = 1
        this.favStorage.push(product)
        localStorage.setItem("fav", JSON.stringify(this.favStorage))
      }
      Swal.fire({
        position: 'top-end',
          icon: 'success',
          width:'30%',
         padding:'1rem',
         background:'#ECC038',
         backdrop:false,
          title: 'Agregado',
          showConfirmButton: false,
          toast:true,
          timer: 1500,
          timerProgressBar:true,
    })
    },
    deleteProductFav(product) {
      this.productsFavId = this.productsFavStorage
      if (!this.productsFavId.includes(product.id)) {
        this.favStorage.pop(product)
        localStorage.setItem("fav", JSON.stringify(this.favStorage))
      } 
    },
    addProductCart(product) {
      this.productsCartId = this.cartStorage.map(product => product.id)
      if (!this.productsCartId.includes(product.id)) {
        product.quantity = 1
        this.cartStorage.push(product)
        localStorage.setItem("cart", JSON.stringify(this.cartStorage))
      }

        Swal.fire({
          position: 'top-end',
          icon: 'success',
          width:'30%',
         padding:'1rem',
         background:'#ECC038',
         backdrop:false,
          title: 'Guardado',
          showConfirmButton: false,
          toast:true,
          timer: 1500,
          timerProgressBar:true,
      })
      .catch(function (error) {
        Swal.fire({
          position: 'top-end',
          icon: 'error',
          title: 'Stock no disponible',
          showConfirmButton: false,
          timer: 1500
      })
      })

    },
    addProductCartModal(product) {
      let input = document.getElementById(`${product.id}`)
      this.productsCartId = this.cartStorage.map(product => product.id)
      if (!this.productsCartId.includes(product.id)) {
        product.quantity = input.value
        this.cartStorage.push(product)
        localStorage.setItem("cart", JSON.stringify(this.cartStorage))
      }
      input.value = 1
    },
    deleteProductCart(product) {
      this.productsCartStorage = this.productsCartStorage.filter(prod => prod.id !== product.id)
      this.cartStorage = this.productsCartStorage
      localStorage.setItem("cart", JSON.stringify(this.productsCartStorage))
    },
    emptyCart() {
      this.cartStorage = [];
      localStorage.removeItem("cart");
    },
    sumCart(productCart) {
      let localS = JSON.parse(localStorage.getItem("cart"))
      let localSCopy = [...localS]
      let localSFilterToModify = localS.filter(product => product.id == productCart.id)

      if (productCart.stock > productCart.quantity) {
        localSFilterToModify[0].quantity = ++productCart.quantity
      }
      else {   
        Swal.fire({
          position: 'top-end',
          icon: 'error',
          title: 'Stock no disponible',
          showConfirmButton: false,
          timer: 1500
      })
      }
      let localScopyFiltered = localSCopy.filter(prod => prod.id != productCart.id)
      localScopyFiltered.push(localSFilterToModify[0])
      localStorage.clear()
      localStorage.setItem("cart", JSON.stringify(localScopyFiltered))
    },
    minusCart(productCart) {
      let localS = JSON.parse(localStorage.getItem("cart"))
      let localSCopy = [...localS]
      let localSFilterToModify = localS.filter(product => product.id == productCart.id)

      if (productCart.quantity > 1) {
        localSFilterToModify[0].quantity = --productCart.quantity
      }
      else {
        console.log("no se puede restar mas");
      }
      let localScopyFiltered = localSCopy.filter(prod => prod.id != productCart.id)
      localScopyFiltered.push(localSFilterToModify[0])
      localStorage.clear()
      localStorage.setItem("cart", JSON.stringify(localScopyFiltered))
  },
  computed: {
    sumPrice() {
      let priceProducts = 0
      this.cartStorage.forEach(product => {
        priceProducts += (product.price) * (product.quantity)
      })
      return priceProducts
    },
  },
}}).mount('#app')


