import Vue from 'vue'
// import ElementUI from 'element-ui'; // ElementUI组件库
// import 'element-ui/packages/theme-chalk/lib/index.css'; // ElementUI组件库样式
import App from './App.vue'
import router from './router'
import store from './store'

Vue.config.productionTip = false

// respone 拦截器
// request.interceptors.response.use(
//   response => {
//     const { data = {} } = response;
//     const { success } = data;
//     if (success) {
//       return data;
//     } else {
//       return { success };
//     }
//   },
//   error => {
//     return { success: false };
//   });
import './utils/element.js'

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
