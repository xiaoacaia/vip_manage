          
<template>
  <div class="login-body">
    <!--登录框div-->
    <div class="login-container">
      <!--登录框头部logo部分-->
      <div class="head">
        <img class="logo" src="../assets/supermark_manage_icon.png" />
        <div class="name">
          <div class="title">登陆界面</div>
          <div class="tips">超市会员管理系统登陆界面</div>
        </div>
      </div>

      <!--loginForm是从setup内返回得到的-->
      <el-form
        label-position="top"
        :rules="rules"
        :model="ruleForm"
        ref="loginForm"
        class="login-form"
      >
        <!-- v-model.trim   自动过滤输入内容最开始和最后的空格 -->
        <el-form-item label="账号" prop="username">
          <el-input
            type="text"
            v-model.trim="ruleForm.username"
            autocomplete="off"
          ></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input
            type="password"
            v-model.trim="ruleForm.password"
            autocomplete="off"
          ></el-input>
        </el-form-item>
        <el-form-item>
          <el-button
            style="width: 100%; margin-top: 30px"
            type="primary"
            @click="submitForm"
            >立即登录</el-button
          >
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>


<script>
import axios from "../utils/axios";
import { reactive, ref, toRefs } from "vue";
import { ElMessage } from "element-plus";
export default {
  name: "Login",
  setup() {
    // el-form 组件接收一个 ref 属性，Vue 3.0 需要这样声明
    const loginForm = ref(null);
    const state = reactive({
      ruleForm: {
        username: "", // 账号
        password: "", // 密码
      },
      checked: true,
      // 表单验证判断。
      rules: {
        username: [
          { required: "true", message: "账户不能为空", trigger: "blur" },
        ],
        password: [
          { required: "true", message: "密码不能为空", trigger: "blur" },
        ],
      },
    });
    // 表单提交方法
    const submitForm = async () => {
      loginForm.value.validate((valid) => {
        // valid 是一个布尔值，表示表单是否通过了上面 rules 的规则。
        if (valid) {
          axios
            .post("supermark_manage/login", {
              userName: state.ruleForm.username || "",
              password: state.ruleForm.password,
            })
            .then((res) => {
              if (res.data !== false) {
                // 此处登录完成之后，需要刷新页面
                window.localStorage.setItem("have_login", JSON.stringify(res));
                window.location.href = "/";
              } else {
                state.ruleForm.username = "";
                state.ruleForm.password = "";
                ElMessage.error("账号或密码输入错误,请重新输入");
              }
            });
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    };

    return {
      ...toRefs(state),
      loginForm, // 注意，一定要返回 loginForm
      submitForm,
    };
  },
};
</script>

<style scoped>
.login-body {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  background-color: #fff;
}

.login-container {
  border-radius: 4px;
  width: 420px;
  height: 500px;
  background-color: #fff;
  box-shadow: 0 21px 41px 0 rgba(194, 198, 228, 0.2);
}
.head {
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 40px 0 20px 0;
}
.head img {
  margin-right: 20px;
  width: 100px;
  height: 100px;
}
.head .title {
  font-size: 28px;
  color: rgba(2, 2, 19, 0.603);
  /* font-weight: bold; */
}
.head .tips {
  margin-top: 10px;
  font-size: 12px;
  color: #999;
}

.login-form {
  margin: 0 auto;
  width: 70%;
}
.login-form .el-form-item {
  margin-bottom: 10px;
}
/* .login-form >>> .el-form-item__label {
  padding: 0;
} */
.login-form.el-form--label-top :v-deep(.el-form-item__label) {
  padding: 0;
}
</style>