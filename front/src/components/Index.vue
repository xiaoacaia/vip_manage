<template>
  <el-aside class="aside">
    <!--系统名称+logo-->
    <div class="head">
      <div>
        <img src="../assets/super_icon_white.png" alt="logo" />
        <span>超市会员管理系统</span>
      </div>
    </div>
    <!--一条为了美观的线条-->
    <div class="line" />
    <!-- 是否使用 vue-router 的模式，启用该模式会在激活导航时
        以 index 作为 path 进行路由跳转 -->
    <!-- default-openeds：默认打开的 el-submenu 索引（代码中默认赋值为全部打开），
        default-active：当前选中菜单项的高亮 -->
    <el-menu
      background-color="#222832"
      text-color="#fff"
      :router="true"
      :default-openeds="defaultOpen"
      :default-active="currentPath"
    >
      <!--一级栏目-->
      <el-submenu index="1">
        <template #title>
          <span>会员管理</span>
        </template>

        <!--二级栏目-->
        <el-menu-item-group>
          <el-menu-item index="/vip"
            ><i class="el-icon-s-custom" />会员名单</el-menu-item
          >
        </el-menu-item-group>
      </el-submenu>

      <el-submenu index="2">
        <template #title>
          <span>商品管理</span>
        </template>

        <el-menu-item-group>
          <el-menu-item index="/goods_manage"
            ><i class="el-icon-shopping-cart-2" />商品列表</el-menu-item
          >
          <el-menu-item index="/bug_goods"
            ><i class="el-icon-s-goods" />商品购买</el-menu-item
          >
          <el-menu-item index="/sale_records"
            ><i class="el-icon-s-data" />销售记录</el-menu-item
          >
        </el-menu-item-group>
      </el-submenu>

      <el-submenu index="3">
        <template #title>
          <span>系统管理</span>
        </template>
        <el-menu-item-group>
          <!-- <el-menu-item index="/employee"
            ><i class="el-icon-user-solid" />员工管理</el-menu-item
          > -->
          <el-menu-item @click="leave_system"
            ><i class="el-icon-circle-close" />退出系统</el-menu-item
          >
        </el-menu-item-group>
      </el-submenu>
    </el-menu>
  </el-aside>

  <el-container class="content">
    <Header />
    <div class="main">
      <router-view />
    </div>
    <Footer />
  </el-container>
</template>

<script>
import { reactive, toRefs } from "vue";
import { useRouter } from "vue-router";
import Header from "./sub_component/Header.vue";
import Footer from "./sub_component/Footer.vue";
export default {
  name: "Index",
  components: {
    Header,
    Footer,
  },
  setup() {
    function leave_system() {
      window.localStorage.removeItem("have_login");
      window.location.href = "/";
    }
    const router = useRouter();
    const state = reactive({
      defaultOpen: ["1", "2", "3", "4"],
      currentPath: "/vip",
    });

    // router.beforeEach((to, from, next) => {
    //   console.log(to.fullPath);
    //   state.currentPath = to.fullPath
    //   next()
    // })

    return {
      ...toRefs(state),
      leave_system,
    };
  },
};
</script>





<style scoped>
.container {
  height: 100vh;
}

.content {
  display: flex;
  flex-direction: column;
  max-height: 100vh;
  overflow: hidden;
}
.main {
  /* + 和 - 运算符的两边必须要有空白字符 */
  height: calc(100vh - 100px);
  overflow: auto;
  padding: 10px;
}

/* 侧边栏整体 */
.aside {
  width: 200px !important;
  /* overflow: hidden; */
  overflow-y: auto;
  background-color: #222832;
  -ms-overflow-style: none;
  overflow: -moz-scrollbars-none;
}
.aside::-webkit-scrollbar {
  display: none;
}
.head {
  margin-top: 15px;
  display: flex;
  align-items: center;
  justify-content: center;
  height: 50px;
}
.head > div {
  display: flex;
  align-items: center;
}

.head img {
  width: 30px;
  height: 30px;
  margin-right: 10px;
}
.head span {
  font-size: 16px;
  color: #ffffff;
}
.line {
  border-top: 1px solid hsla(0, 0%, 100%, 0.05);
  border-bottom: 1px solid rgba(0, 0, 0, 0.2);
}
</style>