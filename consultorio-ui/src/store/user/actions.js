
export function login (context, payload) {
    context.commit("setUser", payload);
}

export function logout (context) {
    context.commit("setUser", {
        username:'',
        password:'',
        company:{id:0,name:''},
        role:0
      });
}

