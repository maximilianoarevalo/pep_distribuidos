<template>
<div class="content">
  <div class="head">
    <h1>Solicitud de permiso temporal</h1>
    <hr>
  </div>
    <b-form @submit="onSubmit" @reset="onReset" v-if="show">
      <b-form-group id="input-group" label="Nombres:" label-for="input-2">
        <b-form-input
          id="input-2"
          v-model="form.name"
          required
          placeholder="Ingrese sus nombres"
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group" label="Apellido Paterno:" label-for="input-2">
        <b-form-input
          id="input-2"
          v-model="form.lnP"
          required
          placeholder="Ingrese su apellido paterno"
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group" label="Apellido Materno:" label-for="input-2">
        <b-form-input
          id="input-2"
          v-model="form.lnM"
          required
          placeholder="Ingrese su apellido materno"          
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group" label="Rut:" label-for="input-2" description="Ingrese su rut sin puntos y con guión">
        <b-form-input
          id="input-2"
          v-model="form.rut"
          required
          placeholder="Ingrese su Rut"          
        ></b-form-input>
      </b-form-group>

      <b-form-group
        id="input-group"
        label="Correo electrónico:"
        label-for="input-1"
        description="Esto le permitirá recibir un correo de confirmación."
      >
        <b-form-input
          id="input-1"
          v-model="form.email"
          type="email"
          required
          placeholder="Ingrese su correo electrónico"
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group" label="Sexo:" label-for="input-3">
        <b-form-select
          id="input-3"
          v-model="form.gender"
          :options="genders"
          required
        ></b-form-select>
      </b-form-group>

      <b-form-group id="input-group" label="Seleccione su permiso:" label-for="input-3">
        <b-form-select
          id="input-3"
          v-model="form.permission"
          :options="permissions"
          required
        ></b-form-select>
      </b-form-group>

      <b-form-group id="input-group">
        <b-form-checkbox-group v-model="form.checked" id="checkboxes-4">
          <b-form-checkbox value="me">* Declaro que la información otorgada es real</b-form-checkbox>
        </b-form-checkbox-group>
      </b-form-group>

      <b-button type="submit" variant="success" href="/permissionGenerated" v-on:click="creacion">Generar Permiso</b-button>
      <!--<b-button type="reset" variant="danger">Reset</b-button>-->
    </b-form>
    <!-- Show form : TESTING, REMOVE LATER! -->   
    <b-card class="mt-3" header="Form Data Result">
      <pre class="m-0">{{ form }}</pre>
    </b-card>
  </div>
</template>

<script>
import axios from 'axios'
  export default {
    data() {
      return {
        form: {
          name: '',
          lnP: '',
          lnM: '',
          email: '',
          rut: '',
          gender: null,
          permission: null,
          checked: []
        },
        genders: [{ text: 'Seleccione su sexo', value: null }, 'Masculino', 'Femenino'],
        permissions: [{ text: 'Seleccione su permiso', value: null }, '1 - Asistencia a establecimientos de salud', '2 - Compras insumos básicos',
        '3 - Salida de personas con espectro autista u otra discapacidad mental','4 - Paseo de mascotas','5 - Pago de servicios básicos y gestiones',
        '6 - Asistencia a funeral familiar directo','7 - Proceso de postulación al Sistema de Admisión Escolar, retiro de alimentos, textos escolares y/o artículos tecnológicos',
        '8 - Comparecencia a una citación en virtud de la Ley','9 - Entregar alimentos u otros insumos de primera necesidad a adultos mayores','10 - Proporcionar alimentos o insumos de primera necesidad en Recinto Penitenciario',
        '11 - Traslado del menor o adolescente al hogar del tutelar','12 - Traslado de padres o tutores a establecimientos de Salud o Centros de SENAME','13 - Permiso para donantes de sangre.',
        '14 - Matrimonio y Unión Civil.','15 - Salida de Niños, Niñas y Adolescentes'],
        show: true
      }
    },
    methods: {
      onSubmit(evt) {
        evt.preventDefault()
        let parameters = {
          name: this.form.name+' '+this.form.lnP+' '+this.form.lnM,
          //lastNames: this.form.lnP+' '+this.form.lnM,
          email: this.form.email,
          rut: this.form.rut,
          gender: this.form.gender,
          permission: this.form.permission
        };
        axios.post('http://localhost:8081/backend',parameters)
        .then((response) => {
          console.log("Probando el post: "+response)
          //this.$refs
        })
        //alert(JSON.stringify(this.form))
        
      },
      onReset(evt) {
        evt.preventDefault()
        // Reset our form values
        this.form.name = ''
        this.form.lnP = ''
        this.form.lnM = ''
        this.form.email = ''
        this.form.permission = null
        this.form.gender = null
        this.form.checked = []
        // Trick to reset/clear native browser form validation state
        this.show = false
        this.$nextTick(() => {
          this.show = true
        })
      },
      /*Creo que esto deberia recibirse del back y mostrarlo en otra vista o algo asi
      creacion: function(){
        alert("Permiso generado exitosamente \n"+
        "ID: \n"
        +"Nombre: "+this.form.name+" "+this.form.lnP+" "+this.form.lnM+"\n"
        )
      }*/
    }
  }
</script>

<style>
#input-group{
  margin-left:  25%;
  margin-right: 25%;
}
.head{
  padding: 10px; 
}

.content{
  margin-bottom: 15px;
}

</style>