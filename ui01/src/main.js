import Vue from 'vue'
import axios from 'axios';
// import ElementUI from 'element-ui'; // ElementUI组件库
// import 'element-ui/packages/theme-chalk/lib/index.css'; // ElementUI组件库样式
import App from './App.vue'
import router from './router'
import store from './store'

Vue.config.productionTip = false
const request = axios.create({
  baseURL: 'http://localhost:8189',
  timeout: 1000 * 60,
  withCredentials: true,
});
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
import './util/element.js'

Vue.prototype.$request = request;


new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
