<template>

<v-data-table
    :headers="headers"
    :items="servingScreen"
    :items-per-page="5"
    class="elevation-1"
  ></v-data-table>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'ServingScreen',
    props: {
      value: Object,
      editMode: Boolean,
      isNew: Boolean
    },
    data: () => ({
        headers: [
            { text: "id", value: "id" },
            { text: "orderId", value: "orderId" },
            { text: "coffeeName", value: "coffeeName" },
            { text: "status", value: "status" },
        ],
        servingScreen : [],
    }),
    async created() {
      var temp = await axios.get(axios.backend + '/servingscreens')

      this.servingScreen = temp.data._embedded.servingscreens;

    },
    methods: {
    }
  }
</script>

