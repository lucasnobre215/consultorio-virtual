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

        <q-toolbar-title> Consultório Virual </q-toolbar-title>
      </q-toolbar>
    </q-header>

    <q-drawer v-model="leftDrawerOpen" bordered>
      <q-list>
        <q-item-label header class="row">
          <div class="col-12 text-weight-bold text-h6">Consultorio Virtual</div>
          <div class="col-12" style="font-weight: bold; font-size: 18px">
            {{ $store.state.user.user.fullName }}
          </div>
          <div class="col-12" style="font-size: 15px">{{ parseRole }}</div>
        </q-item-label>
        <q-item clickable tag="a" target="_blank">
          <q-item-section>
            <q-btn @click="home()" color="primary">home</q-btn>
          </q-item-section>
        </q-item>

        <q-item
          clickable
          tag="a"
          target="_blank"
          v-if="$store.state.user.user.role == 'ADMIN'"
        >
          <q-item-section>
            <q-btn @click="createUser()" color="primary">Usuários</q-btn>
          </q-item-section>
        </q-item>

        <q-item
          clickable
          tag="a"
          target="_blank"
          v-if="$store.state.user.user.role == 'ADMIN'"
        >
          <q-item-section>
            <q-btn @click="companyList()" color="primary">Clinicas</q-btn>
          </q-item-section>
        </q-item>

        <q-item
          clickable
          tag="a"
          target="_blank"
          v-if="$store.state.user.user.role != 'CUSTOMER'"
        >
          <q-item-section>
            <q-btn @click="createProcedure()" color="primary"
              >Procedimentos</q-btn
            >
          </q-item-section>
        </q-item>

        <q-item clickable tag="a" target="_blank">
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
  name: "Home",
  data() {
    return {
      email: "",
      password: "",
      leftDrawerOpen: true,
    };
  },
  computed: {
    parseRole() {
      var role = this.$store.state.user.user.role;
      if (role == "ADMIN") {
        return "Administrador";
      } else if (role == "EMPLOYEE") {
        return "Dentista";
      } else if (role == "CUSTOMER") {
        return "Cliente";
      }
    },
  },
  methods: {
    toggleLeftDrawer() {
      this.leftDrawerOpen = !this.leftDrawerOpen;
    },
    logout() {
      this.$store.dispatch("user/logout").then(() => {
        this.$router.push({ path: "/" });
      });
    },
    createUser() {
      this.$router.push({ path: "/user" });
    },
    home() {
      this.$router.push({ path: "/home" });
    },
    createProcedure() {
      this.$router.push({ path: "/proccedure" });
    },
    companyList() {
      this.$router.push({ path: "/company" });
    },
  },
  mounted() {
    if (this.$store.state.user.user.username == "") {
      this.$router.push({ path: "/" });
    }
  },
};
</script>
