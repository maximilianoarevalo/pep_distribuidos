<template>
<div>
  <b-card title="Permiso generado exitosamente">
    <b-card-text>
      <!-- Consumo el JSON -->
      Identificador: {{info.data.bpi.USD.code}}
    </b-card-text>
    <b-card-text>
      Nombre:
    </b-card-text>
    <b-card-text>
      Desde:
    </b-card-text>
    <b-card-text>
      Hasta:
    </b-card-text>
    <b-button class="mt-3" variant="success" href="/">Solicitar nuevo permiso</b-button>
  </b-card>
</div>
</template>


<script>
import axios from 'axios'
  export default {
    data() {
      return {
        info: null
      }
    },
    mounted(){
      axios.get('https://api.coindesk.com/v1/bpi/currentprice.json')
      .then(response => (this.info = response))
    }
  }
</script>

<style>

</style>