package com.zhang.supermarket_manage.pojo;

public class GoodsRecords {
    private int id;
    private int vipID;
    private int goodsID;
    private int shoppingCounts;
    private String shoppingTime;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVipID() {
        return vipID;
    }

    public void setVipID(int vipID) {
        this.vipID = vipID;
    }

    public int getGoodsID() {
        return goodsID;
    }

    public void setGoodsID(int goodsID) {
        this.goodsID = goodsID;
    }

    public int getShoppingCounts() {
        return shoppingCounts;
    }

    public void setShoppingCounts(int shoppingCounts) {
        this.shoppingCounts = shoppingCounts;
    }

    public String getShoppingTime() {
        return shoppingTime;
    }

    public void setShoppingTime(String shoppingTime) {
        this.shoppingTime = shoppingTime;
    }
}
