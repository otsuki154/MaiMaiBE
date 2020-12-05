import Vue from 'vue'
import App from './App.vue'
import { BootstrapVue, IconsPlugin } from "bootstrap-vue";
import "bootstrap/dist/css/bootstrap.css";
import "bootstrap-vue/dist/bootstrap-vue.css";
import router from './router.js';
import axios from 'axios';
import UrlConstants from './assets/const/UrlConstants';


Vue.use(BootstrapVue);
Vue.use(IconsPlugin);
Vue.use(axios);
Vue.prototype.$UrlConstants = UrlConstants;
Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
