package com.zhang.supermarket_manage.pojo;

public class DisplayRecords {
    private int id;
    private String vipName;
    private String goodsName;
    private int shoppingCounts;
    private int allMoney;
    private String shoppingTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVipName() {
        return vipName;
    }

    public void setVipName(String vipName) {
        this.vipName = vipName;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getShoppingCounts() {
        return shoppingCounts;
    }

    public void setShoppingCounts(int shoppingCounts) {
        this.shoppingCounts = shoppingCounts;
    }

    public int getAllMoney() {
        return allMoney;
    }

    public void setAllMoney(int allMoney) {
        this.allMoney = allMoney;
    }

    public String getShoppingTime() {
        return shoppingTime;
    }

    public void setShoppingTime(String shoppingTime) {
        this.shoppingTime = shoppingTime;
    }
}
