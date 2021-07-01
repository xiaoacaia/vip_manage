<template>
  <!-- 与君共勉：最实用的自律是攒钱，最养眼的自律是健身，最健康的自律是早睡，最改变气质的自律是看书，最好的自律是经济独立 。 -->
  <div class="layout">
    <el-container class="container">
      <router-view />
    </el-container>
  </div>
</template>

<script>
import { reactive, toRefs } from "vue";
import { useRouter } from "vue-router";
import { pathMap } from "./utils";

function localGet(key) {
  const value = window.localStorage.getItem(key);
  try {
    return JSON.parse(window.localStorage.getItem(key));
  } catch (error) {
    return value;
  }
}

export default {
  name: "App",
  setup() {
    // 不需要菜单的路径数组
    const noMenu = ["/login"];
    const router = useRouter();
    const state = reactive({
      currentPath: "/",
    });
    // 监听路由的变化
    router.beforeEach((to, from, next) => {
      if (to.path == "/login") {
        // 路径是 /login 正常执行
        next();
      } else {
        // 不是 /login
        // 判断是否有 token
        if (!localGet("have_login")) {
          // 跳至登录页面
          next({ path: "/login" });
        } else {
          // 继续执行
          next();
        }
      }
      state.currentPath = to.path;
      document.title = pathMap[to.name];
    });

    return {
      ...toRefs(state),
    };
  },
};
</script>


<style scoped>
.container {
  height: 100vh;
}
</style>


<style>
body {
  padding: 0;
  margin: 0;
  box-sizing: border-box;
}

.el-menu {
  border-right: none !important;
}
.el-submenu {
  border-top: 1px solid hsla(0, 0%, 100%, 0.05);
  border-bottom: 1px solid rgba(0, 0, 0, 0.2);
}
.el-submenu:first-child {
  border-top: none;
}
/* [attr^=value]
表示带有以 attr 命名的属性，且属性值是以 value 开头的元素 */
.el-submenu [class^="el-icon-"] {
  vertical-align: -1px !important;
}
a {
  color: #409eff;
  text-decoration: none;
}
.el-pagination {
  text-align: center;
  margin-top: 20px;
}
.el-popper__arrow {
  display: none;
}
</style>