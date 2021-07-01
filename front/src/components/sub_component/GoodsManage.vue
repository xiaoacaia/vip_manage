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
        <DialogAddGoods ref="addGoods" :type="type" :GoodsState="state" />
      </template>

      <el-table :loading="loading" :data="tableData" style="width: 100%">
        <el-table-column prop="goodsID" label="商品编号"> </el-table-column>
        <el-table-column prop="goodsName" label="商品名称"> </el-table-column>
        <el-table-column prop="goodsPrice" label="单价"> </el-table-column>
        <el-table-column prop="goodsCount" label="剩余数量"> </el-table-column>
        <el-table-column prop="gradeRule" label="积分规则"> </el-table-column>
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
import { reactive, toRefs, onMounted, ref } from "vue";
import { getAllGoods } from "../../utils/index";
import axios from "axios";
import DialogAddGoods from "./DialogAddGoods.vue";
import { ElMessage } from "element-plus";

export default {
  name: "GoodsManage",
  components: {
    DialogAddGoods,
  },
  setup() {
    const addGoods = ref();
    const state = reactive({
      loading: false,
      tableData: [],
      currentPage: 1, // 当前页数
      pageSize: 10, // 每页请求数
      total: 100, // 总条数
      type: "add", // 操作类型
    });

    onMounted(() => {
      getAllGoods(state);
    });

    const changePage = (val) => {
      state.currentPage = val;
      getAllGoods(state);
    };

    function handleAdd() {
      state.type = "add";
      addGoods.value.open();
    }

    function handleEdit(editRow) {
      state.type = "update";
      addGoods.value.open(editRow);
    }

    function handleDelect(deleteId) {
      axios.post("/supermark_manage/deleteGoods", deleteId).then(() => {
        getAllGoods(state);
        ElMessage.success("删除商品成功");
      });
    }

    return {
      ...toRefs(state),
      state,
      addGoods,
      handleEdit,
      handleDelect,
      handleAdd,
      changePage,
    };
  },
};
</script>

<style>
</style>