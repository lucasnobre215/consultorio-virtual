<template>
  <div class="q-pa-md" style="max-width: 400px">
  
    <q-form @submit="onSubmit" @reset="goBack" class="q-gutter-md">
      <q-input filled v-model="name" label="Nome do Procedimento *" />
      <q-input filled v-model="price" label="Preço *" type="number"/>
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
      name: "",
      price: 0,
      company: "",
      companyOptions: [],
    };
  },
  methods: {
    onSubmit() {
      var _this = this;
      this.$axios
        .post("/procedure/", {
          id:this.id,
          name: this.name,
          price: this.price,
          company: { id: this.company.value, name: this.company.label },
        })
        .then((response) => {
          _this.$router.back();
        });
    },
    goBack() {
      this.$router.back();
    }
    
  },
 
  mounted() {
     debugger
    if (this.$route.params.id != null) {
      debugger
      this.$axios.get("/procedure/" + this.$route.params.id).then((response) => {
        debugger
        this.id=response.data.id
        this.name = response.data.name;
        this.price = response.data.price;
        this.company = response.data.company!=null ? {label:response.data.company.name,value:response.data.company.id}:null;
      });
    }
    if (this.$store.state.user.user.role == "ADMIN") {
      this.$axios.get("/company/").then((response) => {
        this.companyOptions = response.data.map((x) => {
          const company = {};
          company["label"] = x.name;
          company["value"] = x.id;

          return company;
        });
      });
    }else{
      this.companyOptions = [{label: this.$store.state.user.user.company.name, value:this.$store.state.user.user.company.id}]
    }
  },
};
</script>
