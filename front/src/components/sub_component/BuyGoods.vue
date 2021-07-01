<template>
  <el-card>
    <div id="buy_goods_header">
      <el-select v-model="vipValue" placeholder="选择会员名称">
        <el-option
          v-for="item in vipInformation"
          :key="item.id"
          :label="item.vip_name"
          :value="item.vip_name"
          @click="showVipInformation(item.id, item.card_money)"
        >
        </el-option>
      </el-select>

      <span style="margin-left: 20px">卡内余额：{{ card_money }} 元</span>

      <el-button plain id="cost_money">
        总计花费：{{ totalMoney }} 元</el-button
      >
    </div>

    <el-row v-for="item in goodsTableData" :key="item.value">
      <el-col :span="24" class="goods_list">
        <el-card>
          <div class="goods_card">
            <span>{{ item.goods_name }}</span>
            <span>{{ item.goods_price }}元</span>
          </div>
          <el-input-number
            v-model="item.counts"
            class="add_button"
            size="medium"
            :min="0"
            @change="handleTotalMoney(item)"
          ></el-input-number>
        </el-card>
      </el-col>
    </el-row>

    <el-button type="primary" round @click="submit_records" id="submit_buttom"
      >点击提交购买记录</el-button
    >
  </el-card>
</template>

<script>
import { reactive, toRefs, onMounted } from "vue";
import { recordGetAllVipName, recordGetAllGoods } from "../../utils/index";
import { ElMessageBox } from "element-plus";
import { ElMessage } from "element-plus";
import axios from "axios";

export default {
  name: "BuyGoods",
  setup() {
    const state = reactive({
      loading: false,
      vipValue: "",
      num: 1,
      goodsTableData: [],
      vipInformation: [],
      totalMoney: 0, // 总共花费
      card_money: "", // 用户卡内余额
      buy_record: {
        vip_id: "",
        goods_id_and_counts: {}, // { goods_id: goods_counts }
      },
      allMoney: "",
    });

    onMounted(() => {
      recordGetAllVipName(state);
      recordGetAllGoods(state);
    });

    function showVipInformation(id, money) {
      state.card_money = money;
      state.buy_record.vip_id = id;
    }

    function handleTotalMoney(item) {
      let total = 0;
      state.buy_record.goods_id_and_counts[item.goods_id] = item.counts;
      for (let i = 0; i < state.goodsTableData.length; i++) {
        total =
          total +
          state.goodsTableData[i].goods_price * state.goodsTableData[i].counts;
      }
      state.totalMoney = total;
    }

    function submit_records() {
      if (state.buy_record.vip_id) {
        if (state.totalMoney) {
          if (state.card_money >= state.totalMoney) {
            ElMessageBox.confirm("是否提交本次购买记录?", "提示", {
              confirmButtonText: "确定",
              cancelButtonText: "取消",
            })
              .then(() => {
                for (let i in state.buy_record.goods_id_and_counts) {
                  
                  axios.post("/supermark_manage/insertGoodsRecords", {
                    vipID: state.buy_record.vip_id,
                    goodsID: i,
                    shoppingCounts: state.buy_record.goods_id_and_counts[i],
                  });

                  axios.post("/supermark_manage/updateVipInformation", {
                    vipID: state.buy_record.vip_id,
                    goodsID: i,
                    shoppingCounts: state.buy_record.goods_id_and_counts[i],
                  });



                }
                ElMessage.success({
                  message: "提交成功!",
                });
              })
              .catch(() => {
                ElMessage.info({
                  message: "已取消提交",
                });
              });
          } else {
            ElMessage.error({
              message: "余额不足，请充值",
            });
          }
        } else {
          ElMessage.error({
            message: "请选择商品",
          });
        }
      } else {
        ElMessage.error({
          message: "请选择会员名称",
        });
      }
    }

    return {
      ...toRefs(state),
      handleTotalMoney,
      showVipInformation,
      submit_records,
    };
  },
};
</script>

<style scoped>
#cost_money {
  float: right;
  margin-right: 50px;
}

#buy_goods_header {
  margin-bottom: 10px;
}

.goods_list {
  margin-top: 20px;
}

.goods_card {
  width: 890px;
  float: left;
  overflow: hidden;
}
.goods_card span:first-child {
  height: 21px;
  width: 800px;
  float: left;
}
.goods_card span:nth-child(2) {
  float: right;
}

.add_button {
  float: right;
  margin-right: 30px;
  margin-bottom: 20px;
}

#submit_buttom {
  float: right;
  margin: 20px;
}
</style>