<template>
  <q-card class="col-12" style="margin-bottom:8px;">
    <q-card-section>
      <div class="row justify-between">
        <div class="col-1">
          <q-btn round :color="statusColor" icon="event" />
        </div>
        <div class="col-8" style="font-size: 24px; font-weight: bold">
          {{ isCustomer? appointment.employee : appointment.client }} - {{ appointment.date }}
        </div>
        <div class="col-2 row justify-end" style="max-height: 32px" v-if="hasAction">
          <q-btn
            round
            size="sm"
            color="secondary"
            icon="done"
            style="margin-right: 8px"
            v-if="!isConfirmed"
          />{{status}}
          <q-btn round size="sm" color="negative" icon="close" />
        </div>
      </div>
    </q-card-section>
  </q-card>
</template>

<script>

const statusColor = {
    "CONFIRMED":"secondary",
    "SCHEDULED":"amber",
    "CLOSED":"grey",
}

export default {
  name: "Home",
props: ['appointment',"hasAction"],
  data() {
  },
  computed: {
    // a computed getter
    isConfirmed(){
        return this.appointment.status == "CONFIRMED"
    },
    isClosed(){
      return this.appointment.status == "CLOSED"
    },
    statusColor() {
      return statusColor[this.appointment.status];
    },
    isCustomer(){
      return this.$store.state.user.user.role == "CUSTOMER"
    },
    
  },
  methods: {
    toggleLeftDrawer() {
      this.leftDrawerOpen = !this.leftDrawerOpen;
    },
  },
  
};
</script>
