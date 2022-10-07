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
            @click="goToCompanyForm"
          />
        </template>
        <template v-slot:body="props">
          <q-tr :props="props">
            <q-td key="name" :props="props">
              {{ props.row.name }}
            </q-td>
            <q-td key="id" :props="props">
              <q-btn @click="goToCompanyForm(props.row.id)" round size="sm" color="primary" icon="mode_edit" />
              <q-btn @click="removeCompany(props.row.id)" round size="sm" color="negative" icon="close" />
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
    label: "Nome da Clínica",
    field: "name",
    sortable: true,
  },
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
    goToCompanyForm(userId) {
      this.$router.push({ name: "companyForm", params: {"id":userId} });
    },
    removeCompany(id) {
      this.$axios.delete("/company/" + id).then((response) => {
        this.rows = response.data.map((x) => {
          const company = {
            id: x.id,
            name: x.name,
          };
          return company;
        });
      });
    },    
    goBack() {
      this.$router.back();
    },
  },
  mounted() {
    this.$axios.get("/company/").then((response) => {
      this.rows = response.data.map((x) => {
        const company = {
          id: x.id,
          name: x.name,          
        };
        return company;
      });
    });
  },
};
</script>
