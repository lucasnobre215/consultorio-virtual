<template>
  <q-page class="row justify-center content-start" style="padding: 16px">
    <div class="col-12">
      <q-table title="Treats" :rows="rows" :columns="columns" row-key="name">
        <template v-slot:top-right>
            <q-btn icon=""></q-btn>
        </template>
      </q-table>>
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
  { name: "email",align: "center", label: "E-mail", field: "email", sortable: true },
  { name: "role",  align: "center",label: "Papel", field: "role" },
  { name: "company", align: "center", label: "Clínica", field: "company" },
];

const rows = [
  {
    username: "Lucas Nobre",
    email: "lucasnobre@gmail.com",
    company: "Espaço Odontológico",
    role: "ADMIN",
  },
  {
    username: "Lucas Nobre",
    email: "lucasnobre@gmail.com",
    company: "Espaço Odontológico",
    role: "ADMIN",
  },
  {
    username: "Lucas Nobre",
    email: "lucasnobre@gmail.com",
    company: "Espaço Odontológico",
    role: "ADMIN",
  },
  {
    username: "Lucas Nobre",
    email: "lucasnobre@gmail.com",
    company: "Espaço Odontológico",
    role: "ADMIN",
  },
  {
    username: "Lucas Nobre",
    email: "lucasnobre@gmail.com",
    company: "Espaço Odontológico",
    role: "ADMIN",
  },
];

export default {
  setup() {
    return {
      columns,
      rows,
    };
  },
};
</script>
