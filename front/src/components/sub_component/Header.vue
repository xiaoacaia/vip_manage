<template>
  <div class="header">
    <div class="left">
      <span style="font-size: 20px">{{ name }}</span>
    </div>

  </div>
</template>

<script>
import { onMounted, reactive, toRefs } from "vue";
import { useRouter } from "vue-router";
import axios from "../../utils/axios";
import { pathMap } from "../../utils";
export default {
  name: "Header",
  setup() {
    // 获取路由实例
    const router = useRouter();
    const state = reactive({
      name: "会员管理",
    });

    // 监听路由变化方法 afterEach
    router.afterEach((to) => {
      state.name = pathMap[to.name];
    });

    return {
      ...toRefs(state),
    };
  },
};
</script>

<style scoped>
.header {
  height: 50px;
  border-bottom: 1px solid #e9e9e9;
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0 20px;
}
.right > div > .icon {
  font-size: 18px;
  margin-right: 6px;
}
.author {
  margin-left: 10px;
  cursor: pointer;
}
</style>
<style>
.popper-user-box {
  background: url("https://s.yezgea02.com/lingling-h5/static/account-banner-bg.png")
    50% 50% no-repeat !important;
  background-size: cover !important;
  border-radius: 0 !important;
}
.popper-user-box .nickname {
  position: relative;
  color: #ffffff;
}
.popper-user-box .nickname .logout {
  position: absolute;
  right: 0;
  top: 0;
  cursor: pointer;
}
</style>