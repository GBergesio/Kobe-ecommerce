// const urlParams = new URLSearchParams(window.location.search);
// const category = urlParams.get('category')

const app = Vue.createApp({
  data() {
    return {
      message: 'Hello Vue!',
      // funkos: [
      //   {
      //     id: 1,
      //     name: "Funko Pop Harry Potter",
      //     tag: "funkos",
      //     description: "Funko edicion limitada de Harry Potter",
      //     img: "https://http2.mlstatic.com/D_NQ_NP_887637-MLA48532306800_122021-O.webp",
      //     price: 15500,
      //     discount: 12500,
      //     stock: 4,
      //     category: "Personajes",
      //     tag: "pepe"
      //   },
      //   {
      //     id: 2,
      //     name: "Funko Pop Dragon Ball",
      //     tag: "funkos",
      //     description: "Funko edicion limitada de Dragon Ball",
      //     img: "https://m.media-amazon.com/images/I/41zhiVnTEVS._SL500_.jpg",
      //     price: 12500,
      //     discount: 9500,
      //     stock: 2,
      //     category: "Personajes",
      //     tag: "pepe"
      //   },
      //   {
      //     id: 3,
      //     name: "Funko Pop YuGiOh - Yugi Moto",
      //     tag: "funkos",
      //     description: "Funko edicion limitada de YuGiOh",
      //     img: "https://http2.mlstatic.com/D_NQ_NP_770341-MLA43442443560_092020-O.jpg",
      //     price: 7200,
      //     discount: 5500,
      //     stock: 5,
      //     category: "Personajes",
      //     tag: "pepe"
      //   },
      //   {
      //     id: 4,
      //     name: "Funko Pop SpiderMan",
      //     tag: "funkos",
      //     description: "Funko edicion limitada de SpiderMan",
      //     img: "http://d3ugyf2ht6aenh.cloudfront.net/stores/910/199/products/funko-spiderman-220-spiderman1-e153bf88028a48526a16459148872529-640-0.jpg",
      //     price: 12800,
      //     discount: 10500,
      //     stock: 14,
      //     category: "Personajes",
      //     tag: "pepe"
      //   },
      //   {
      //     id: 5,
      //     name: "Funko Pop Batman Justice League",
      //     tag: "funkos",
      //     description: "Funko edicion limitada de Batman ",
      //     img: "https://juguetestoday.com/32953-large_default/funko-batman-jumbo.jpg",
      //     price: 14800,
      //     discount: 12500,
      //     stock: 3,
      //     category: "Personajes",
      //     tag: "pepe"
      //   },

      // ],
      // products: [{
      //   "id": 1,
      //   "name": "Funko POP! Goku Casual",
      //   "description": "Figura de Goku ssj en vinilo de 9 cm",
      //   "img": "https://i.ibb.co/1mKLVDX/funko-pop-goku-casual-dragon-ball-z.jpg",
      //   "stock": 15,
      //   "price": 2499.0,
      //   "discount": 15,
      //   "serie": "Dragon Ball Z",
      //   "category": "ACTIONFIGURES",
      //   "subcategory": "Funko POP!"
      // }, {
      //   "id": 2,
      //   "name": "Funko POP! Gotenks Casual",
      //   "description": "Figura de Gotenks en vinilo de 9 cm",
      //   "img": "https://i.ibb.co/3htX09L/funko-pop-gotenks-dragon-ball.jpg",
      //   "stock": 31,
      //   "price": 2699.0,
      //   "discount": 15,
      //   "serie": "Dragon Ball Z",
      //   "category": "ACTIONFIGURES",
      //   "subcategory": "Funko POP!"
      // }, {
      //   "id": 3,
      //   "name": "Funko POP! Future Trunks",
      //   "description": "Figura de Future Trunks en vinilo de 9 cm",
      //   "img": "https://i.ibb.co/TbZdL17/funko-pop-trunks-del-futuro-dragon-ball.jpg",
      //   "stock": 9,
      //   "price": 4499.0,
      //   "discount": 15,
      //   "serie": "Dragon Ball Z",
      //   "category": "ACTIONFIGURES",
      //   "subcategory": "Funko POP!"
      // }, {
      //   "id": 4,
      //   "name": "Funko POP! Android 18",
      //   "description": "Figura de Android 18 en vinilo de 9 cm",
      //   "img": "https://i.ibb.co/2scTHyV/212286-800-auto.webp",
      //   "stock": 5,
      //   "price": 4999.0,
      //   "discount": 15,
      //   "serie": "Dragon Ball Z",
      //   "category": "ACTIONFIGURES",
      //   "subcategory": "Funko POP!"
      // }, {
      //   "id": 5,
      //   "name": "Funko POP! Thanos Gold",
      //   "description": "Figura de Thanos Gold en vinilo de 9 cm",
      //   "img": "https://i.ibb.co/DWXjyNs/204545-800-auto.webp",
      //   "stock": 10,
      //   "price": 6999.0,
      //   "discount": 15,
      //   "serie": "Marvel",
      //   "category": "ACTIONFIGURES",
      //   "subcategory": "Funko POP!"
      // }, {
      //   "id": 6,
      //   "name": "Funko POP! Thor",
      //   "description": "Figura de Thor en vinilo de 9 cm",
      //   "img": "https://i.ibb.co/ZX4Pppx/204651-800-auto.webp",
      //   "stock": 14,
      //   "price": 4999.0,
      //   "discount": 15,
      //   "serie": "Marvel",
      //   "category": "ACTIONFIGURES",
      //   "subcategory": "Funko POP!"
      // }, {
      //   "id": 7,
      //   "name": "Funko POP! Cyclops",
      //   "description": "Figura de Cyclops en vinilo de 9 cm",
      //   "img": "https://i.ibb.co/6v7v9XX/205860-800-auto.webp",
      //   "stock": 13,
      //   "price": 3499.0,
      //   "discount": 15,
      //   "serie": "Marvel",
      //   "category": "ACTIONFIGURES",
      //   "subcategory": "Funko POP!"
      // }, {
      //   "id": 8,
      //   "name": "Funko POP! Storm",
      //   "description": "Figura de Storm en vinilo de 8 cm",
      //   "img": "https://i.ibb.co/wS2SWtF/212264-800-auto.webp",
      //   "stock": 7,
      //   "price": 4999.0,
      //   "discount": 15,
      //   "serie": "Marvel",
      //   "category": "ACTIONFIGURES",
      //   "subcategory": "Funko POP!"
      // }, {
      //   "id": 9,
      //   "name": "Funko POP! Kefla Ssj",
      //   "description": "Figura de Kefla Ssj en vinilo de 8 cm",
      //   "img": "https://i.ibb.co/xHb1zdx/205868-800-auto.webp",
      //   "stock": 14,
      //   "price": 4999.0,
      //   "discount": 15,
      //   "serie": "Dragon Ball Z",
      //   "category": "ACTIONFIGURES",
      //   "subcategory": "Funko POP!"
      // }, {
      //   "id": 10,
      //   "name": "Funko POP! Thor Gold",
      //   "description": "Figura de Thor Gold en vinilo de 10 cm",
      //   "img": "https://i.ibb.co/2ZNLfWd/212275-800-auto.webp",
      //   "stock": 12,
      //   "price": 5999.0,
      //   "discount": 15,
      //   "serie": "Marvel",
      //   "category": "ACTIONFIGURES",
      //   "subcategory": "Funko POP!"
      // }, {
      //   "id": 11,
      //   "name": "Marvel Series - Winter Soldier",
      //   "description": "Figura estatica de Winter Soldier de 20 cm de altura",
      //   "img": "https://i.ibb.co/hdx9bNN/entrega-011-P24032-9a-marvel-figurines-1647803149626.webp",
      //   "stock": 7,
      //   "price": 6999.0,
      //   "discount": 15,
      //   "serie": "Marvel",
      //   "category": "ACTIONFIGURES",
      //   "subcategory": "Static Figures"
      // }, {
      //   "id": 12,
      //   "name": "Marvel Series - War Machine",
      //   "description": "Figura estatica de War Machine de 20 cm de altura",
      //   "img": "https://i.ibb.co/7nJjFk3/entrega-011-P24031-marvel-figurines-entrega31a-maquina-guerra-1647287255924.webp",
      //   "stock": 11,
      //   "price": 6999.0,
      //   "discount": 15,
      //   "serie": "Marvel",
      //   "category": "ACTIONFIGURES",
      //   "subcategory": "Static Figures"
      // }, {
      //   "id": 13,
      //   "name": "Marvel Series - Iron Man",
      //   "description": "Figura estatica de Iron Man de 20 cm de altura",
      //   "img": "https://i.ibb.co/v4y4GyC/entrega-011-N19055-Marvel-Movie-Collection-entrega55-iron-man-a-1601847012273-cloned-at1635108877273.webp",
      //   "stock": 4,
      //   "price": 7999.0,
      //   "discount": 15,
      //   "serie": "Marvel",
      //   "category": "ACTIONFIGURES",
      //   "subcategory": "Static Figures"
      // }, {
      //   "id": 14,
      //   "name": "Marvel Series - Ultron",
      //   "description": "Figura estatica de Ultron de 20 cm de altura",
      //   "img": "https://i.ibb.co/LzkQHF9/entrega-011-N19024-24a-marvel-figurines-1560511549346-cloned-at1636317846851.webp",
      //   "stock": 7,
      //   "price": 6999.0,
      //   "discount": 15,
      //   "serie": "Marvel",
      //   "category": "ACTIONFIGURES",
      //   "subcategory": "Static Figures"
      // }, {
      //   "id": 15,
      //   "name": "Marvel Series - Captain America",
      //   "description": "Figura estatica de Captain America de 20 cm de altura",
      //   "img": "https://i.ibb.co/gd2X0bH/entrega-011-N19028-28a-marvel-figurines-1564738782765-cloned-at1637490474173.webp",
      //   "stock": 9,
      //   "price": 7999.0,
      //   "discount": 15,
      //   "serie": "Marvel",
      //   "category": "ACTIONFIGURES",
      //   "subcategory": "Static Figures"
      // }, {
      //   "id": 16,
      //   "name": "Marvel Series - Thor",
      //   "description": "Figura estatica de Thor de 20 cm de altura",
      //   "img": "https://i.ibb.co/ZSg6BKp/entrega-011-P24022-Marvel-Movie-Collection-entrega56-thor-a-1638988647449.webp",
      //   "stock": 12,
      //   "price": 7999.0,
      //   "discount": 15,
      //   "serie": "Marvel",
      //   "category": "ACTIONFIGURES",
      //   "subcategory": "Static Figures"
      // }, {
      //   "id": 17,
      //   "name": "Marvel Series - Hela",
      //   "description": "Figura estatica de Hela de 20 cm de altura",
      //   "img": "https://i.ibb.co/rHPMBNK/entrega-011-P24023-Marvel-Movie-Collection-entrega44-hela-a-1639982180388.webp",
      //   "stock": 17,
      //   "price": 5999.0,
      //   "discount": 15,
      //   "serie": "Marvel",
      //   "category": "ACTIONFIGURES",
      //   "subcategory": "Static Figures"
      // }, {
      //   "id": 18,
      //   "name": "Marvel Series - Black Widow",
      //   "description": "Figura estatica de Black Widow de 20 cm de altura",
      //   "img": "https://i.ibb.co/rmVKbY7/entrega-011-P24024-viuda-negra-2-1642009101980.webp",
      //   "stock": 3,
      //   "price": 7999.0,
      //   "discount": 15,
      //   "serie": "Marvel",
      //   "category": "ACTIONFIGURES",
      //   "subcategory": "Static Figures"
      // }, {
      //   "id": 19,
      //   "name": "Marvel Series - Black Panther",
      //   "description": "Figura estatica de Black Panther de 20 cm de altura",
      //   "img": "https://i.ibb.co/S076Dbp/entrega-011-P24028-Marvel-Movie-Collection-entrega51-erik-killmonger-a-1654370239943.webp",
      //   "stock": 8,
      //   "price": 6999.0,
      //   "discount": 15,
      //   "serie": "Marvel",
      //   "category": "ACTIONFIGURES",
      //   "subcategory": "Static Figures"
      // }, {
      //   "id": 20,
      //   "name": "Marvel Series - Vison",
      //   "description": "Figura estatica de Vision de 20 cm de altura",
      //   "img": "https://i.ibb.co/yQ6f1Cj/entrega-011-P24027-19a-marvel-figurines-1652632580845.webp",
      //   "stock": 13,
      //   "price": 6999.0,
      //   "discount": 15,
      //   "serie": "Marvel",
      //   "category": "ACTIONFIGURES",
      //   "subcategory": "Static Figures"
      // }],
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
      // console.log(localSFilterToModify);
    },
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
}).mount('#app')


