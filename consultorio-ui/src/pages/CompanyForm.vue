<template>
  <div class="q-pa-md" style="max-width: 400px">
  
    <q-form @submit="onSubmit" @reset="goBack" class="q-gutter-md">
      <q-input filled v-model="name" label="Nome da Clinica*" />

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
    };
  },
  methods: {
    onSubmit() {
      var _this = this;
      this.$axios
        .post("/company/", {
          id:this.id,
          name: this.name,
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
    if (this.$route.params.id != null) {
      this.$axios.get("/company/" + this.$route.params.id).then((response) => {
        this.id=response.data.id
        this.name = response.data.name;
      });
    }
  },
};
</script>
