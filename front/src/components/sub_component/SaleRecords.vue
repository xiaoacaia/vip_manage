<template>
  <el-card>
    <el-table :loading="loading" :data="tableData" style="width: 100%">
      <el-table-column prop="vipName" label="会员名称"> </el-table-column>
      <el-table-column prop="goodsName" label="商品名称"> </el-table-column>
      <el-table-column prop="shoppingCounts" label="购买数量">
      </el-table-column>
      <el-table-column prop="allMoney" label="总计花费"> </el-table-column>
      <el-table-column prop="shoppingTime" label="购买时间"> </el-table-column>

      <el-table-column label="操作" width="100">
        <template #default="scope">
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
</template>

<script>
import { reactive, toRefs, onMounted } from "vue";
import { getAllDisplayGoodsRecords } from "../../utils/index";
import { ElMessage } from "element-plus";
import axios from "axios";

export default {
  name: "SaleRecords",
  setup() {
    const state = reactive({
      loading: false,
      currentPage: 1, // 当前页数
      pageSize: 10, // 每页请求数
      total: 100, // 总条数
      tableData: [],
    });

    onMounted(() => {
      getAllDisplayGoodsRecords(state);
    });

    const changePage = (val) => {
      state.currentPage = val;
      getAllDisplayGoodsRecords(state);
    };

    function handleDelect(deleteId) {
      axios.post("/supermark_manage/deleteGoodsRecords", deleteId).then(() => {
        getAllDisplayGoodsRecords(state);
        ElMessage.success("删除记录成功");
      });
    }

    return {
      ...toRefs(state),
      changePage,
      handleDelect,
    };
  },
};
</script>

<style scoped>
</style>