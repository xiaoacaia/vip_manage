<template>
  <el-dialog
    :title="type == 'add' ? '添加会员' : '修改会员'"
    v-model="visible"
    width="400px"
  >
    <el-form
      :model="ruleForm"
      :rules="rules"
      ref="formRef"
      label-width="100px"
      class="good-form"
    >
      <el-form-item label="会员名称" prop="vipName">
        <el-input type="text" v-model="ruleForm.vipName"></el-input>
      </el-form-item>
      <el-form-item label="会员等级" prop="vipLevel">
        <el-input type="text" v-model="ruleForm.vipLevel"></el-input>
      </el-form-item>
      <el-form-item label="卡内余额" prop="cardMoney">
        <el-input type="text" v-model="ruleForm.cardMoney"></el-input>
      </el-form-item>
      <el-form-item label="剩余积分" prop="cardGrade">
        <el-input type="text" v-model="ruleForm.cardGrade"></el-input>
      </el-form-item>
      <el-form-item label="注册时间" prop="createTime" v-if="show">
        <el-input type="text" v-model="ruleForm.createTime"></el-input>
      </el-form-item>
    </el-form>

    <template #footer>
      <span class="dialog-footer">
        <el-button @click="visible = false">取 消</el-button>
        <el-button type="primary" @click="submitForm">确 定</el-button>
      </span>
    </template>
  </el-dialog>
</template>


<script>
import { reactive, ref, toRefs } from "vue";
import axios from "../../utils/axios";
import { getAllVip } from "../../utils/index";
import { ElMessage } from "element-plus";

export default {
  name: "DialogAddVip",
  props: {
    type: String,
    VipState: Object,
  },
  setup(props) {
    const formRef = ref();
    const state = reactive({
      visible: false,
      ruleForm: {
        vipName: "",
        vipLevel: "",
        cardMoney: "",
        cardGrade: "",
        createTime: "",
      },
      updateId: "",
      show: "",
      rules: {
        vipName: [
          { required: "true", message: "输入不能为空", trigger: ["change"] },
        ],
        vipLevel: [
          { required: "true", message: "输入不能为空", trigger: ["change"] },
        ],
        cardMoney: [
          { required: "true", message: "输入不能为空", trigger: ["change"] },
        ],
        cardGrade: [
          { required: "true", message: "输入不能为空", trigger: ["change"] },
        ],
        createTime: [
          { required: "true", message: "输入不能为空", trigger: ["change"] },
        ],
      },
      id: "",
    });

    const submitForm = () => {
      formRef.value.validate((valid) => {
        // valid 为是否通过表单验证的变量
        if (valid) {
          let needUpdateVip = {};
          for (let i in state.ruleForm) {
            needUpdateVip[i] = state.ruleForm[i];
          }
          if (props.type === "update") {
            needUpdateVip.id = state.updateId;
            axios.post("supermark_manage/updateVip", needUpdateVip).then(() => {
              // 利用父组件的 state 再次修改 tableData
              getAllVip(props.VipState);
              state.visible = false;
              ElMessage.success("修改会员成功");
            });
          } else if (props.type === "add") {
            axios.post("supermark_manage/insertVip", needUpdateVip).then(() => {
              getAllVip(props.VipState);
              state.visible = false;
              ElMessage.success("添加会员成功");
            });
          }
        } else {
          console.log("请按要求输入信息");
        }
      });
    };

    // 开启弹窗
    const open = (rowData) => {
      if (rowData) {
        state.updateId = rowData.id;
        state.show = true;
        for (let i in state.ruleForm) {
          state.ruleForm[i] = rowData[i];
        }
      } else {
        state.show = false;
        for (let i in state.ruleForm) {
          state.ruleForm[i] = "";
        }
      }
      state.visible = true;
    };

    // 关闭弹窗
    const close = () => {
      state.visible = false;
    };

    return {
      ...toRefs(state),
      open,
      close,
      formRef,
      submitForm,
    };
  },
};
</script>