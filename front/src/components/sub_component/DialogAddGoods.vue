<template>
  <el-dialog
    :title="type == 'add' ? '添加商品' : '修改商品'"
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
      <el-form-item label="商品编号" prop="goodsID">
        <el-input type="text" v-model="ruleForm.goodsID"></el-input>
      </el-form-item>
      <el-form-item label="商品名称" prop="goodsName">
        <el-input type="text" v-model="ruleForm.goodsName"></el-input>
      </el-form-item>
      <el-form-item label="单价" prop="goodsPrice">
        <el-input type="text" v-model="ruleForm.goodsPrice"></el-input>
      </el-form-item>
      <el-form-item label="剩余数量" prop="goodsCount">
        <el-input type="text" v-model="ruleForm.goodsCount"></el-input>
      </el-form-item>
      <el-form-item label="积分规则" prop="gradeRule">
        <el-input type="text" v-model="ruleForm.gradeRule"></el-input>
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
import { getAllGoods } from "../../utils/index";
import { ElMessage } from "element-plus";

export default {
  name: "DialogAddGoods",
  props: {
    type: String,
    GoodsState: Object,
  },
  setup(props) {
    const formRef = ref();
    const state = reactive({
      visible: false,
      ruleForm: {
        goodsID: "",
        goodsName: "",
        goodsPrice: "",
        goodsCount: "",
        gradeRule: "",
      },
      updateId: "",
      rules: {
        goodsID: [
          { required: "true", message: "输入不能为空", trigger: ["change"] },
        ],
        goodsName: [
          { required: "true", message: "输入不能为空", trigger: ["change"] },
        ],
        goodsPrice: [
          { required: "true", message: "输入不能为空", trigger: ["change"] },
        ],
        goodsCount: [
          { required: "true", message: "输入不能为空", trigger: ["change"] },
        ],
        gradeRule: [
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
            axios
              .post("supermark_manage/updateGoods", needUpdateVip)
              .then(() => {
                getAllGoods(props.GoodsState);
                state.visible = false;
                ElMessage.success("修改商品成功");
              });
          } else if (props.type === "add") {
            axios
              .post("supermark_manage/insertGoods", needUpdateVip)
              .then(() => {
                getAllGoods(props.GoodsState);
                state.visible = false;
                ElMessage.success("添加商品成功");
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
        for (let i in state.ruleForm) {
          state.ruleForm[i] = rowData[i];
        }
      } else {
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