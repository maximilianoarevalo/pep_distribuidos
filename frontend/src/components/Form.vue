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
     
    <b-container class="bv-example-row">
      <b-row>
        <b-col>
        <b-button class="a" type="submit" variant="success" @click="showDismissibleAlert=true" >Generar Permiso</b-button>
        </b-col>
        <b-col>
        <b-button class="b" type="reset" variant="primary" @click="showDismissibleAlert=false">Solicitar nuevo permiso</b-button>
        </b-col>
      </b-row>
    </b-container>    
    </b-form>
    <div class="alert">
    <b-alert v-model="showDismissibleAlert" variant="success" dismissible>
      <h1>
        Permiso generado exitosamente
      </h1>
      Identificador del permiso: {{this.id}} <br/> 
      Nombre solicitante: {{this.fullName}} <br/>
      RUT: {{this.rut}} <br/> 
      Razón: {{this.reasson}} <br/>
      Inicio: {{this.iDate}} <br/>
      Termino: {{this.fDate}}
    </b-alert>
  </div>
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
          checked: [],
        },
        genders: [{ text: 'Seleccione su sexo', value: null }, 'Masculino', 'Femenino'],
        permissions: [{ text: 'Seleccione su permiso', value: null }, '1 - Asistencia a establecimientos de salud', '2 - Compras insumos básicos',
        '3 - Salida de personas con espectro autista u otra discapacidad mental','4 - Paseo de mascotas','5 - Pago de servicios básicos y gestiones',
        '6 - Asistencia a funeral familiar directo','7 - Proceso de postulación al Sistema de Admisión Escolar, retiro de alimentos, textos escolares y/o artículos tecnológicos',
        '8 - Comparecencia a una citación en virtud de la Ley','9 - Entregar alimentos u otros insumos de primera necesidad a adultos mayores','10 - Proporcionar alimentos o insumos de primera necesidad en Recinto Penitenciario',
        '11 - Traslado del menor o adolescente al hogar del tutelar','12 - Traslado de padres o tutores a establecimientos de Salud o Centros de SENAME','13 - Permiso para donantes de sangre.',
        '14 - Matrimonio y Unión Civil.','15 - Salida de Niños, Niñas y Adolescentes'],
        show: true,
        showDismissibleAlert: false,
        id: 0,
        fullName: "",
        reasson: "",
        iDate: "",
        fDate: "",
        rut: ""
      }
    },
    methods: {
      onSubmit(evt) {
        evt.preventDefault()
        console.log(this.form)
        let parameters = {
          names: this.form.name,
          lastName: this.form.lnP+' '+this.form.lnM,
          email: this.form.email,
          gender: this.form.gender,
          type: this.form.permission,
          rut: this.form.rut,
        };
        axios.post('http://localhost:8080/app/newPass',parameters)
        .then((response) => {
          this.id = response.data.id
          this.fullName = response.data.names +' '+response.data.lastName
          this.reasson = response.data.type
          this.iDate = response.data.initialDate
          this.fDate = response.data.finalDate
          this.rut = response.data.rut
        })
        .catch((error)=> console.log(error))
        //alert(JSON.stringify(this.form))
      },
      onReset(evt) {
        evt.preventDefault()
        // Reset our form values
        this.form.name = ''
        this.form.lnP = ''
        this.form.lnM = ''
        this.form.email = ''
        this.form.rut = ''
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
.alert{
  margin-top: 5px;
  margin-left:  50px;
  margin-right: 50px;
}
.a{
  margin-left:  200px;
  width: 200px;

}
.b{
  margin-right: 200px;
  width: 200px;
}

</style>