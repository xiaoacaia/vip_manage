import axios from "axios";

export const pathMap = {
    undefined: "首页",
    login: "登录",
    index: "index",
    vip: '会员管理',
    vip_points: '积分管理',
    card_manage: '会员卡管理',
    goods_manage: '商品列表',
    employee: '员工管理',
    sale_records: '销售记录',
    bug_goods: '商品购买'
};

export function getAllVip(state) {
    axios.get("/supermark_manage/getAllVip").then((res) => {
        // 统计所有数据
        state.total = res.data.length;
        // 从那个索引开始请求数据
        let start = (state.currentPage - 1) * state.pageSize
        // 需要请求数据的数量（一开始 total 可能比 pageSize 还小）
        let requestSize = Math.min(state.pageSize, state.total)
        // 请求到最后时，需要清除数组
        state.tableData.length = 0
        for (let i = start; i < start + requestSize && i < state.total; i++) {
            state.tableData[i - start] = res.data[i];
        }
    });
}

export function recordGetAllVipName(state) {
    axios.get("/supermark_manage/getAllVip").then((res) => {
        for (let i = 0; i < res.data.length; i++) {
            state.vipInformation[i] = {
                id: res.data[i].id,
                vip_name: res.data[i].vipName,
                card_money: res.data[i].cardMoney
            }
        }
    });
}

export function recordGetAllGoods(state) {
    axios.get("/supermark_manage/getAllGoods").then((res) => {
        for (let i = 0; i < res.data.length; i++) {
            state.goodsTableData[i] = {
                goods_price: res.data[i].goodsPrice,
                goods_name: res.data[i].goodsName,
                goods_id: res.data[i].id,
                counts: 0,
            }
        }
    });
}

export function getAllGoods(state) {
    axios.get("/supermark_manage/getAllGoods").then((res) => {
        // 统计所有数据
        state.total = res.data.length;
        // 从那个索引开始请求数据
        let start = (state.currentPage - 1) * state.pageSize
        // 需要请求数据的数量（一开始 total 可能比 pageSize 还小）
        let requestSize = Math.min(state.pageSize, state.total)
        // 请求到最后时，需要清除数组
        state.tableData.length = 0
        for (let i = start; i < start + requestSize && i < state.total; i++) {
            state.tableData[i - start] = res.data[i];
        }
    });
}

// export function getAllGoodsRecords(state) {
//     axios.get("/supermark_manage/getDisplayGoodsRecords").then((res) => {
//         // 统计所有数据
//         state.total = res.data.length;
//         // 从那个索引开始请求数据
//         let start = (state.currentPage - 1) * state.pageSize
//         // 需要请求数据的数量（一开始 total 可能比 pageSize 还小）
//         let requestSize = Math.min(state.pageSize, state.total)
//         // 请求到最后时，需要清除数组

//         state.tableData.length = 0
//         for (let i = start; i < start + requestSize && i < state.total; i++) {
//             state.tableData[i - start] = res.data[i];
//         }
        
//     });
// }
export function getAllDisplayGoodsRecords(state) {
    axios.get("/supermark_manage/getDisplayGoodsRecords").then((res) => {
        console.log(res.data);
        // 统计所有数据
        state.total = res.data.length;
        // 从那个索引开始请求数据
        let start = (state.currentPage - 1) * state.pageSize
        // 需要请求数据的数量（一开始 total 可能比 pageSize 还小）
        let requestSize = Math.min(state.pageSize, state.total)
        // 请求到最后时，需要清除数组
        state.tableData.length = 0
        for (let i = start; i < start + requestSize && i < state.total; i++) {
            state.tableData[i - start] = res.data[i];
        }
        
    });
}