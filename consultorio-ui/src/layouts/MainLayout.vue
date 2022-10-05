<template>
  <q-layout view="lHh Lpr lFf">
    <q-header elevated>
      <q-toolbar>
        <q-btn
          flat
          dense
          round
          icon="menu"
          aria-label="Menu"
          @click="toggleLeftDrawer"
        />

        <q-toolbar-title>
          Consultório Virual

        </q-toolbar-title>

        
      </q-toolbar>
    </q-header>

    <q-drawer
      v-model="leftDrawerOpen"
      show-if-above
      bordered
    >
      <q-list>
        <q-item-label
          header
          class="row">
        >
          <h6 class="col-12">Consultorio Virtual</h6>
          <div class="col-12" style="font-weight: bold; font-size: 18px;">{{$store.state.user.user.username}}</div>
          <div class="col-12"  style="font-size: 15px;">{{$store.state.user.user.role}}</div>
        </q-item-label>
          <q-item
          clickable
          tag="a"
          target="_blank"
        >
          <q-item-section>
            <q-btn @click="home()" color="primary">home</q-btn>
          </q-item-section>
        </q-item>
        
        <q-item
          clickable
          tag="a"
          target="_blank"
          v-if="$store.state.user.user.role=='ADMIN'"
        >
          <q-item-section>
            <q-btn @click="createUser()" color="primary">Create user</q-btn>
          </q-item-section>
        </q-item>

        <q-item
          clickable
          tag="a"
          target="_blank"
          
        >
          <q-item-section>
            <q-btn @click="logout" color="primary">Logout</q-btn>
          </q-item-section>
        </q-item>
      </q-list>
    </q-drawer>

    <q-page-container>
      <router-view />
    </q-page-container>
  </q-layout>
</template>

<script>
export default {
  name: 'Home',
  data () {
    return {
      email: '',
      password: '',
      leftDrawerOpen:false
    }
  },
  methods:{
    toggleLeftDrawer(){
      this.leftDrawerOpen=!this.leftDrawerOpen
    },
    logout(){
        this.$store.dispatch("user/logout").then(()=>{
              this.$router.push({path: '/'});
            });
      },
      createUser(){
        this.$router.push({path: '/userCrud'});
      },
      home(){
        this.$router.push({path: '/home'});
      }
  },
  mounted(){
    if(this.$store.state.user.user.username==''){
      this.$router.push({path: '/'});
    }
  }
}
</script>
