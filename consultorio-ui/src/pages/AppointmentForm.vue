<template>
  <div class="q-pa-md" style="max-width: 400px">
    <q-form @submit="onSubmit" @reset="goBack" class="q-gutter-md">
      <q-input filled v-model="date">
        <template v-slot:prepend>
          <q-icon name="event" class="cursor-pointer">
            <q-popup-proxy
              cover
              transition-show="scale"
              transition-hide="scale"
            >
              <q-date v-model="date" mask="YYYY-MM-DD HH:mm">
                <div class="row items-center justify-end">
                  <q-btn v-close-popup label="Close" color="primary" flat />
                </div>
              </q-date>
            </q-popup-proxy>
          </q-icon>
        </template>

        <template v-slot:append>
          <q-icon name="access_time" class="cursor-pointer">
            <q-popup-proxy
              cover
              transition-show="scale"
              transition-hide="scale"
            >
              <q-time v-model="date" mask="YYYY-MM-DD HH:mm" format24h>
                <div class="row items-center justify-end">
                  <q-btn v-close-popup label="Close" color="primary" flat />
                </div>
              </q-time>
            </q-popup-proxy>
          </q-icon>
        </template>
      </q-input>

      <q-select
        filled
        v-model="userFormId"
        :options="userOptions"
        :label="parseRole"
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
      id: 0,
      date: "2019-02-01 12:44",
      userFormId: null,
      userOptions: [],
    };
  },
  computed: {
    isCustomer() {
      return this.$store.state.user.user.role == "CUSTOMER";
    },
    user() {
      return this.$store.state.user.user;
    },
    parseRole() {
      var role = this.$store.state.user.user.role;

      if (role == "CUSTOMER") {
        return "Dentista";
      } else if (role == "EMPLOYEE") {
        return "Cliente";
      }
    },
  },
  methods: {
    onSubmit() {
      var _this = this;
      var appointmentValue = this.extractAppointment();
      this.$axios.post("/appointment/", appointmentValue).then((response) => {
        this.$router.push({ path: "/home" });
      });
    },
    extractAppointment() {
      return {
        id: 0,
        date: this.date,
        customer: {
          id: this.isCustomer
            ? this.$store.state.user.user.id
            : this.userFormId.value,
        },
        employee: {
          id: this.isCustomer
            ? this.userFormId.value
            : this.$store.state.user.user.id,
        },
        company: { id: this.$store.state.user.user.company.id },
      };
    },
    goBack() {
      this.$router.back();
    },
  },

  mounted() {
    debugger
    var userListToFetch = "CUSTOMER";
    if (this.$store.state.user.user.role == "CUSTOMER") {
      userListToFetch = "EMPLOYEE";
    } 
    var companyId = this.$store.state.user.user.company.id;
    this.$axios
      .get("/user/" + companyId + "/" + userListToFetch)
      .then((response) => {
        this.userOptions = response.data.map((x) => {
          const user = {};
          user["label"] = x.fullName;
          user["value"] = x.id;

          return user;
        });
      });
  },
};
</script>
