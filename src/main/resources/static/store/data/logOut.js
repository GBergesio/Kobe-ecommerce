const app = Vue.createApp({

  data() {
      return {

      }
  },
  created() {

  },
  methods: {
    logOut(){
      axios.post('/api/logout')
      .then(response => setTimeout(() => {
          window.location.href='./index.html'
      },1000))
  }
  },
  computed: {

  },
}).mount('#app')

