import { createRouter, createWebHashHistory } from 'vue-router'
import Login from '../components/Login.vue'
import Index from '../components/Index.vue'
import Vip from '../components/sub_component/Vip.vue'
import SaleRecords from '../components/sub_component/SaleRecords.vue'
import BuyGoods from '../components/sub_component/BuyGoods.vue'
import GoodsManage from '../components/sub_component/GoodsManage.vue'
const router = createRouter({
  history: createWebHashHistory(), // hash 模式
  routes: [
    {
      path: '/',
      name: 'index',
      component: Index,
      children: [
        { path: '/', redirect: 'vip' },
        {
          path: '/vip',
          name: 'vip',
          component: Vip
        },
        {
          path: '/bug_goods',
          name: 'bug_goods',
          component: BuyGoods
        },
        {
          path: '/sale_records',
          name: 'sale_records',
          component: SaleRecords
        },
        {
          path: '/goods_manage',
          name: 'goods_manage',
          component: GoodsManage
        },
      ]
    },
    {
      path: '/login',
      name: 'login',
      component: Login
    },



  ]
})

export default router