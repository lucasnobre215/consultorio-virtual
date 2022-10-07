
const routes = [
  {
    path: '/',
    component: () => import('layouts/LoginLayout.vue'),
    children: [
      { path: '', component: () => import('pages/IndexPage.vue') },
      { path: 'userCrudCreate/', name: 'userCrudCreate', component: () => import('pages/CreateUserForm.vue') },
    ]
  },
  {
    path: '/',
    component: () => import('layouts/MainLayout.vue'),
    children: [
      { path: 'user/' ,name: 'user', component: () => import('pages/UserList.vue') },
      { path: 'userCrud/:id', name: 'userCrud', component: () => import('pages/CreateUserForm.vue') },
      { path: 'home/', name: 'home', component: () => import('pages/Home.vue') },
      { path: 'proccedure/', name: 'proccedure', component: () => import('pages/ProcedureList.vue') },
      { path: 'proccedureForm/:id', name: 'proccedureForm', component: () => import('pages/ProccedureForm.vue') },
      
      { path: 'company/', name: 'company', component: () => import('pages/CompanyList.vue') },
      { path: 'companyForm/:id', name: 'companyForm', component: () => import('pages/CompanyForm.vue') }
    ]
  },


  // Always leave this as last one,
  // but you can also remove it
  {
    path: '/:catchAll(.*)*',
    component: () => import('pages/ErrorNotFound.vue')
  }
]

export default routes
