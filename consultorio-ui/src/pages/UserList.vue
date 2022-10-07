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
            @click="goToUserForm"
          />
        </template>
        <template v-slot:body="props">
          <q-tr :props="props">
            <q-td key="username" :props="props">
              {{ props.row.username }}
            </q-td>
            <q-td key="email" :props="props">
              {{ props.row.email }}
            </q-td>
            <q-td key="role" :props="props">
              {{ props.row.role }}
            </q-td>
            <q-td key="company" :props="props">
              {{ props.row.company }}
            </q-td>
            <q-td key="id" :props="props">
              <q-btn @click="goToUserForm(props.row.id)" round size="sm" color="primary" icon="mode_edit" />
              <q-btn @click="removeUser(props.row.id)" round size="sm" color="negative" icon="person_remove" />
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
    name: "username",
    align: "center",
    label: "Nome de Usuário",
    field: "username",
    sortable: true,
  },
  {
    name: "email",
    align: "center",
    label: "E-mail",
    field: "email",
    sortable: true,
  },
  { name: "role", align: "center", label: "Papel", field: "role" },
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
    goToUserForm(userId) {
      this.$router.push({ name: "userCrud", params: {"id":userId} });
    },
    removeUser(id) {
      this.$axios.delete("/user/" + id).then((response) => {
        this.rows = response.data.map((x) => {
          const user = {
            id: x.id,
            username: x.username,
            email: x.email,
            company: x.company != null ? x.company.name : "",
            role: x.role,
          };
          return user;
        });
      });
    },    
    goBack() {
      this.$router.back();
    },
  },
  mounted() {
    this.$axios.get("/user/").then((response) => {
      this.rows = response.data.map((x) => {
        const user = {
          id: x.id,
          username: x.username,
          email: x.email,
          company: x.company != null ? x.company.name : "",
          role: x.role,
        };
        return user;
      });
    });
  },
};
</script>
