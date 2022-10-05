<template>
  <q-page class="bg-light-blue window-height window-width row justify-center items-center">
    <div class="column">
      <div class="row">
        <q-card square bordered class="q-pa-lg shadow-1">
          <q-card-section>
            <q-form class="q-gutter-md">
              <q-input square filled clearable v-model="username" type="username" label="email" />
              <q-input square filled clearable v-model="password" type="password" label="password" />
            </q-form>
          </q-card-section>
          <q-card-actions class="q-px-md">
            <q-btn unelevated color="light-blue-7" size="lg" class="full-width" label="Login" @click="login"/>
          </q-card-actions>
          <q-card-section class="text-center q-pa-none">
          
            <q-btn @click="redirectToCreateUser()" class="text-grey-6">Crie uma conta</q-btn>
          </q-card-section>
        </q-card>
      </div>
    </div>
  </q-page>
</template>

<script>
export default {
  name: 'Login',
  data () {
    return {
      username: '',
      password: ''
    }
  },
  methods:{
    redirectToCreateUser(){
      this.$router.push({path: '/crud'})
    },
    login(){
      if(this.username !=null && this.password!=null){
        this.$axios
        .post('/user/login', {username:this.username, password:this.password}).then((response)=>{
            this.$store.dispatch("user/login",response.data).then(()=>{
              this.$router.push({path: '/home'});
            })
        })
      }
      
    }
  }
}
</script>

<style>
.q-card {
  width: 360px;
}
</style>