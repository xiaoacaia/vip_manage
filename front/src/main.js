import { createApp } from 'vue'
import App from './App.vue'
import ElementPlus from 'element-plus'
import router from './router/index.js'

import 'element-plus/lib/theme-chalk/index.css';

const app = createApp(App)

app.use(router)

app.use(ElementPlus)

app.mount('#app')