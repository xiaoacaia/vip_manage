<template>
  <div>
    <el-card>
      <template #header>
        <div class="header" style="overflow: hidden">
          <el-button
            type="primary"
            style="float: right"
            size="small"
            icon="el-icon-plus"
            id="add"
            @click="handleAdd"
            >增加</el-button
          >
        </div>

        <!-- 通过 addSwiper 拿到 DialogAddSwiper 组件内部的方法
      比如 addSwiper.value.open()，通过获取弹窗组件内的 open 方法拿到内部的各个属性。 -->
        <DialogAddVip ref="addVip" :type="type" :VipState="state" />
      </template>

      <el-table :loading="loading" :data="tableData" style="width: 100%">
        <el-table-column prop="vipName" label="会员名称"> </el-table-column>
        <el-table-column prop="vipLevel" label="会员等级"> </el-table-column>
        <el-table-column prop="cardMoney" label="卡内余额"> </el-table-column>
        <el-table-column prop="cardGrade" label="剩余积分"> </el-table-column>
        <el-table-column prop="createTime" label="注册时间"> </el-table-column>
        <el-table-column label="操作" width="100">
          <template #default="scope">
            <el-button @click="handleEdit(scope.row)" type="text" size="small"
              >编辑</el-button
            >
            <el-button
              @click="handleDelect(scope.row.id)"
              type="text"
              size="small"
            >
              删除
            </el-button>
          </template>
        </el-table-column>
      </el-table>

      <el-pagination
        background
        layout="prev, pager, next"
        :total="total"
        :page-size="pageSize"
        :current-page="currentPage"
        @current-change="changePage"
      />
    </el-card>
  </div>
</template>

<script>
import { onMounted, reactive, toRefs, ref } from "vue";
import DialogAddVip from "./DialogAddVip.vue";
import axios from "axios";
import { getAllVip } from "../../utils/index";
import { ElMessage } from "element-plus";

export default {
  name: "Vip",
  components: {
    DialogAddVip,
  },
  setup() {
    const addVip = ref(null);
    const state = reactive({
      loading: false,
      tableData: [], // 1  0~9   (2-1) * 10  start = 1
      currentPage: 1, // 当前页数
      pageSize: 7, // 每页请求数
      total: 100, // 总条数
      type: "add", // 操作类型
    });

    function handleAdd() {
      state.type = "add";
      addVip.value.open();
    }

    function handleEdit(editRow) {
      state.type = "update";
      addVip.value.open(editRow);
    }

    function handleDelect(deleteId) {
      axios.post("/supermark_manage/deleteVip", deleteId).then(() => {
        getAllVip(state);
        ElMessage.success("删除会员成功");
      });
    }

    onMounted(() => {
      getAllVip(state);
    });

    const changePage = (val) => {
      state.currentPage = val;
      getAllVip(state);
    };

    return {
      ...toRefs(state),
      state,
      addVip,
      handleEdit,
      handleAdd,
      handleDelect,
      changePage,
    };
  },
};
</script>

<style>
</style>