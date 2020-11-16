<template>
  <div id="app">
    <b-navbar id="navbar" toggleable="md" type="dark" variant="success">
      <b-navbar-brand class="md-mx-auto">
        <img class="navbar-logo" src = "./assets/logo1.png" alt="Tryvium Logo">
        <b>Simulador Comisaría Virtual</b>
      </b-navbar-brand>
      <b-navbar-toggle target="left-collapse"></b-navbar-toggle>
      <b-collapse id="left-collapse" is-nav>
        <!--<b-navbar-nav class="float-md-left">
          <b-nav-item href="/">Inicio</b-nav-item>
        </b-navbar-nav>
        <b-navbar-nav class="float-md-right">
          <b-nav-item href="/about">Solicitud de permiso</b-nav-item>
        </b-navbar-nav>-->
      </b-collapse>
    </b-navbar>
    <router-view/>
  </div>
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}

.navbar-logo{
  width:65px;
  height: 65px;
}


</style>
