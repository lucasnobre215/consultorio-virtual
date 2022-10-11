<template>
  <q-page class="row justify-center content-start" style="padding: 16px">
    <div class="col-12">
      <q-table title="Usuários" :rows="rows" :columns="columns" row-key="name">
        <template v-slot:top-right>
          <q-btn
            round
            size="sm"
            color="primary"
            icon="person_add"
            @click="goToProcedureForm"
          />
        </template>
        <template v-slot:body="props">
          <q-tr :props="props">
            <q-td key="name" :props="props">
              {{ props.row.name }}
            </q-td>
            <q-td key="price" :props="props">
              {{ props.row.price }}
            </q-td>
            <q-td key="company" :props="props">
              {{ props.row.company }}
            </q-td>
            <q-td key="id" :props="props">
              <q-btn
                @click="goToProcedureForm(props.row.id)"
                round
                size="sm"
                color="primary"
                icon="mode_edit"
              />
              <q-btn
                @click="removeProcedure(props.row.id)"
                round
                size="sm"
                color="negative"
                icon="close"
              />
            </q-td>
          </q-tr>
        </template>
      </q-table>
    </div>
  </q-page>
</template>

<script>
const columns = [
  {
    name: "name",
    align: "center",
    label: "Nome do procedimento",
    field: "name",
    sortable: true,
  },
  {
    name: "price",
    align: "center",
    label: "Preço",
    field: "price",
    sortable: true,
  },
  { name: "company", align: "center", label: "Clínica", field: "company" },
  { name: "id", align: "center", label: "Ações", field: "id" },
];

const rows = [];

export default {
  data() {
    return {
      columns: columns,
      rows: rows,
    };
  },
  methods: {
    goToProcedureForm(userId) {
      this.$router.push({ name: "proccedureForm", params: { id: userId } });
    },
    removeProcedure(id) {
      this.$axios.delete("/procedure/" + id).then((response) => {
        this.rows = response.data.map((x) => {
          const procedure = {
            id: x.id,
            name: x.name,
            price: x.price,
            company: x.company != null ? x.company.name : "",
          };
          return procedure;
        });
      });
    },
    goBack() {
      this.$router.back();
    },
  },
  mounted() {
    if (this.$store.state.user.user.role == "ADMIN") {
      this.$axios.get("/procedure/").then((response) => {
        this.rows = response.data.map((x) => {
          const procedure = {
            id: x.id,
            name: x.name,
            price: x.price,
            company: x.company != null ? x.company.name : "",
          };
          return procedure;
        });
      });
    }else{
       this.$axios.get("/procedure/company/"+this.$store.state.user.user.company.id).then((response) => {
        this.rows = response.data.map((x) => {
          const procedure = {
            id: x.id,
            name: x.name,
            price: x.price,
            company: x.company != null ? x.company.name : "",
          };
          return procedure;
        });
      });
    }
  },
};
</script>
