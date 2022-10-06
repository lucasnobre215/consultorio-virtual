
const routes = [
  {
    path: '/',
    component: () => import('layouts/LoginLayout.vue'),
    children: [
      { path: '', component: () => import('pages/IndexPage.vue') }
    ]
  },
  {
    path: '/',
    component: () => import('layouts/MainLayout.vue'),
    children: [
      { path: 'user/', component: () => import('pages/UserList.vue') },
      { path: 'userCrud/', component: () => import('pages/CreateUserForm.vue') },
      { path: 'home/', component: () => import('pages/Home.vue') },
      { path: 'proccedure/', component: () => import('pages/ProcedureList.vue') }
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
