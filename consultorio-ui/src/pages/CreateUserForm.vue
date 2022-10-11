<template>
  <div class="q-pa-md" style="max-width: 400px">
    <q-form @submit="onSubmit" @reset="goBack" class="q-gutter-md">
      <q-input filled v-model="username" label="Usuário *" />
      <q-input filled v-model="fullname" label="Nome Completo *" />
      <q-input filled v-model="email" label="Email *" />

      <q-input filled type="password" v-model="password" label="Senha *" />
      <q-select
        filled
        v-model="role"
        :options="roleOptions"
        label="Tipo de Usuário"
      />
      <q-select
        filled
        v-model="company"
        :options="companyOptions"
        label="Empresa"
      />

      <div>
        <q-btn label="Go back" type="reset" />
        <q-btn label="Submit" type="submit" color="primary" />
      </div>
    </q-form>
  </div>
</template>

<script>
export default {
  name: "Login",
  data() {
    return {
      id:0,
      username: "",
      fullname:"",
      password: "",
      email: "",
      role: "",
      company: "",
      roleOptions: [
        {
          label: "Cliente",
          value: 0,
        },
        {
          label: "Dentista",
          value: 1,
        },
        {
          label: "Administrador",
          value: 2,
        },
      ],
      companyOptions: [],
    };
  },
  methods: {
    onSubmit() {
      var _this = this;
      this.$axios
        .post("/user/", {
          id:this.id,
          username: this.username,
          fullname: this.fullname,
          email: this.email,
          password: this.password,
          role: this.role.value,
          company: { id: this.company.value, name: this.company.label },
        })
        .then((response) => {
          _this.$router.back();
        });
    },
    goBack() {
      this.$router.back();
    }, 
    parseRole(role){
    if(role=="ADMIN"){
      return {
          label: "Administrador",
          value: 2,
        };
    }else 
      if(role=="EMPLOYEE"){
      return {
          label: "Dentista",
          value: 1,
        };
    }else 
      if(role=="CUSTOMER"){
      return {
          label: "Cliente",
          value: 0,
        };
    }
    
  },
  },
 
  mounted() {
    if (this.$route.params.id != null) {
      this.$axios.get("/user/" + this.$route.params.id).then((response) => {
        this.id=response.data.id
        this.username = response.data.username;
        this.email = response.data.email;
        this.fullname = response.data.fullName;
        this.password = response.data.password;
        this.role = this.parseRole(response.data.role);
        this.company = response.data.company!=null ? {label:response.data.company.name,value:response.data.company.id}:null;
      });
    }
    this.$axios.get("/company/").then((response) => {
      this.companyOptions = response.data.map((x) => {
        const company = {};
        company["label"] = x.name;
        company["value"] = x.id;

        return company;
      });
    });
  },
};
</script>
