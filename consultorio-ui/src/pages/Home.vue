<template>
  <q-page class="row justify-center content-start" style="padding: 16px">
    <q-list
      class="col-12"
      bordered
      v-if="$store.state.user.user.role != 'ADMIN'"
    >
      <q-expansion-item
        group="somegroup"
        icon=""
        :label="'Consultas Ativas'"
        header-class="text-primary text-weight-bold text-h6"
      >
        <div class="row" style="margin: 8px">
          <q-card class="col-12">
            <q-card-section>
              <div class="row justify-between">
                <div class="col-1">
                  <q-btn round color="secondary" icon="event" />
                </div>
                <div class="col-8" style="font-size: 24px; font-weight: bold">
                  Dra. Beatryz Franco - 12/10/2022
                </div>
                <div class="col-2 row justify-end" style="max-height: 32px">
                  <q-btn round size="sm" color="negative" icon="close" />
                </div>
              </div>
            </q-card-section>
          </q-card>
          <q-card class="col-12" style="margin-top: 8px">
            <q-card-section>
              <div class="row justify-between">
                <div class="col-1">
                  <q-btn round color="amber" icon="event" />
                </div>
                <div class="col-8" style="font-size: 24px; font-weight: bold">
                  Dra. Beatryz Franco - 14/10/2022
                </div>
                <div class="col-2 row justify-end" style="max-height: 32px">
                  <q-btn
                    round
                    size="sm"
                    color="secondary"
                    icon="done"
                    style="margin-right: 8px"
                  />
                  <q-btn round size="sm" color="negative" icon="close" />
                </div>
              </div>
            </q-card-section>
          </q-card>
        </div>
      </q-expansion-item>

      <q-separator></q-separator>

      <q-expansion-item
        group="somegroup"
        :label="'Consultas Finalizadas'"
        header-class="text-primary text-weight-bold text-h6"
      >
        <div class="row" style="margin: 8px">
          <q-card class="col-12">
            <q-card-section>
              <div class="row justify-between">
                <div class="col-1">
                  <q-btn round color="primary" icon="event" />
                </div>
                <div class="col-8" style="font-size: 24px; font-weight: bold">
                  Dra. Beatryz Franco - 12/10/2022
                </div>
              </div>
            </q-card-section>
          </q-card>
          <q-card class="col-12" style="margin-top: 8px">
            <q-card-section>
              <div class="row justify-between">
                <div class="col-1">
                  <q-btn round color="primary" icon="event" />
                </div>
                <div class="col-8" style="font-size: 24px; font-weight: bold">
                  Dra. Beatryz Franco - 14/10/2022
                </div>
              </div>
            </q-card-section>
          </q-card>
        </div>
      </q-expansion-item>

      <q-separator></q-separator>
    </q-list>
    <div class="row" v-if="$store.state.user.user.role == 'ADMIN'">
      <q-card class="col-12">
        <q-card-section class="row">
          <q-btn color="primary" label="Usuários"  class="col-12" style="margin-top:8px;"/>
          <q-btn color="primary" label="Clínicas"  class="col-12" style="margin-top:8px;"/>
          <q-btn color="primary" label="Procedimentos"  class="col-12" style="margin-top:8px;"/>
        </q-card-section>
      </q-card>
    </div>
  </q-page>
</template>

<script>
export default {
  name: "Home",
  data() {
    return { expanded: false };
  },
  methods: {},
};
</script>

<style>
.q-card {
  width: 360px;
}
</style>
