<template>
  <q-page class="row justify-center content-start" style="padding: 16px">
    <q-list
      class="col-12"
      bordered
      v-if="$store.state.user.user.role != 'ADMIN'"
    >
      <q-expansion-item group="somegroup">
        <template v-slot:header>
          <q-item-section class="text-primary text-weight-bold text-h6">
            Consultas Ativas
          </q-item-section>

          <q-item-section side>
            <q-btn
              outline
              rounded
              color="primary"
              label="Marcar Consulta"
              icon="today"
              @click="goToAppointmentForm()"
            />
          </q-item-section>
        </template>
        <div class="row" style="margin: 8px">
          <Appointment
            :appointment="appointment"
            :hasAction="true"
            v-for="appointment in openAppointments"
          />
        </div>
      </q-expansion-item>

      <q-separator></q-separator>

      <q-expansion-item
        group="somegroup"
        :label="'Consultas Finalizadas'"
        header-class="text-primary text-weight-bold text-h6"
        ><div class="row" style="margin: 8px">
          <Appointment
            :appointment="appointment"
            :hasAction="false"
            v-for="appointment in closedAppointments"
          />
        </div>
      </q-expansion-item>
      <q-separator></q-separator>
    </q-list>
    <div class="row" v-if="$store.state.user.user.role == 'ADMIN'">
      <q-card class="col-12">
        <q-card-section class="row">
          <q-btn
            color="primary"
            label="Usuários"
            class="col-12"
            style="margin-top: 8px"
          />
          <q-btn
            color="primary"
            label="Clínicas"
            class="col-12"
            style="margin-top: 8px"
          />
          <q-btn
            color="primary"
            label="Procedimentos"
            class="col-12"
            style="margin-top: 8px"
          />
        </q-card-section>
      </q-card>
    </div>
  </q-page>
</template>

<script>
import Appointment from "../components/Appointment.vue";

export default {
  name: "Home",
  data() {
    return {
      expanded: false,
      openAppointments: [

      ],
      closedAppointments: [
      ],
    };
  },
  components: {
    Appointment: Appointment,
  },
  methods: {
    goToAppointmentForm() {
      this.$router.push({ path: "/appointment" });
    },
  },
  mounted() {
    this.$axios
      .get(
        "/appointment/" +
          this.$store.state.user.user.role +
          "/" +
          this.$store.state.user.user.id
      )
      .then((response) => {
        var appointments = response.data.map((x) => {
          const appointment = {};
          appointment["id"] = x.id;
          appointment["date"] = x.date;
          appointment["status"] = x.status;
          appointment["employee"] = x.employee.fullName;
          appointment["client"] = x.customer.fullName;

          return appointment;
        });
        this.closedAppointments = appointments.filter(
          (x) => x.status == "CLOSED"
        ).sort(function(a, b) {
          return a >b;
        });
      
                this.openAppointments = appointments.filter(
          (x) => x.status != "CLOSED"
        ).sort(function(a, b) {
          return a >b;
        });;
      });
  },
};
</script>

<style>
.q-card {
  width: 360px;
}
</style>
