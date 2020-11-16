<template>
<div>
  <b-card title="Permiso generado exitosamente">
    <b-card-text>
      <!-- Consumo el JSON -->
      Identificador: {{id}}
    </b-card-text>
    <b-card-text>
      Nombre: {{names}} {{lastName}}
    </b-card-text>
    <b-card-text>
      Desde: {{initialDate}}
    </b-card-text>
    <b-card-text>
      Hasta: {{finalDate}}
    </b-card-text>
        <b-card-text>
      Motivo: {{ type}}
    </b-card-text>
    <b-button class="mt-3" variant="success" href="/">Solicitar nuevo permiso</b-button>
  </b-card>
</div>
</template>


<script>
import moment from 'moment'
import axios from 'axios'
  export default {
    data() {
      return {
        dialog: false,
        id: '',
        names: '',
        lastName: '',
        initialDate: '',
        finalDate: '',
        type: ''
      }
    },
    methods:{
      setInfo: function(Result){
        this.dialog = false;
        console.log(Result)
        this.id = Result.id
        this.name = Result.name
        this.lastName = Result.lastName
        this.initialDate = moment(String(Result.initialDate)).format('HH-mm-ss  DD-MM-YYYY')
        this.finalDate = moment(String(Result.finalDate)).format('HH-mm-ss  DD-MM-YYYY')
        this.type = Result.type
      }
    },
    mounted(){
      axios.get('http://localhost:8080/app/pass')
      .then(response => (this.info = response))
    }
  }
</script>

<style>

</style>