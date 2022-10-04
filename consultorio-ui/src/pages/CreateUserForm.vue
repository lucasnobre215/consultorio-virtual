<template>
  <div class="q-pa-md" style="max-width: 400px">

    <q-form
      @submit="onSubmit"
      class="q-gutter-md"
    >
      <q-input
        filled
        v-model="username"
        label="Usuário *"
      />

      <q-input
        filled
        type="password"
        v-model="password"
        label="Senha *"
      />
       <q-select filled v-model="role" :options="roleOptions" label="Tipo de Usuário" />
       <q-select filled v-model="company" :options="companyOptions" label="Empresa" />

      <div>
        <q-btn label="Submit" type="submit" color="primary"/>
      </div>
    </q-form>

  </div>
</template>

<script>
export default {
  name: 'Login',
  data () {
    return {
      username: '',
      password: '',
      role:'',
      company:'',
      roleOptions: [
        {
          label: 'Cliente',
          value: 0,
        },
        {
          label: 'Dentista',
          value: 1,
        },
        {
          label: 'Administrador',
          value: 2,
        },
      ],
      companyOptions: [
      ]

    }
  },
  methods:{
    onSubmit(){
        debugger
        this.$axios
        .post('/user/', {username:this.username, password:this.password, role:this.role.value, company:{id:this.company.value,name:this.company.label}}).then(()=>{
            this.$router.push({path: '/'})
        })
    }
  },
  mounted() {
    this.$axios
      .get('/company/')
      .then(response => {
        this.companyOptions =response.data.map(x=> {
            const company = {};
            company['label'] = x.name;
            company['value'] = x.id;

            return company;
        })
    });
  }
  
}
</script>