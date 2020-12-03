// element.js 全文内容如下，按自己需要引入就好了
import Vue from 'vue';
import {
  Input,
  InputNumber,
  Select,
  Table,
  TableColumn,
  DatePicker,
  Loading,
  MessageBox,
  Notification,
  Message,
  Button
} from 'element-ui';
Vue.use(Input);
Vue.use(InputNumber);
Vue.use(Select);
Vue.use(Table);
Vue.use(TableColumn);
Vue.use(DatePicker);
Vue.use(Button);


Vue.use(Loading.directive);

Vue.prototype.$loading = Loading.service;
Vue.prototype.$msgbox = MessageBox;
Vue.prototype.$alert = MessageBox.alert;
Vue.prototype.$confirm = MessageBox.confirm;
Vue.prototype.$prompt = MessageBox.prompt;
Vue.prototype.$notify = Notification;
Vue.prototype.$message = Message;