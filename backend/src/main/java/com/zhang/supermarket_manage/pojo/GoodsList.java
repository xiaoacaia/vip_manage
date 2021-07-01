package com.zhang.supermarket_manage.pojo;

public class GoodsList {

    private int id;
    private String goodsID;
    private String goodsName;
    private int goodsPrice;
    private int goodsCount;
    private int gradeRule;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodsID() {
        return goodsID;
    }

    public void setGoodsID(String goodsID) {
        this.goodsID = goodsID;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(int goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public int getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(int goodsCount) {
        this.goodsCount = goodsCount;
    }

    public int getGradeRule() {
        return gradeRule;
    }

    public void setGradeRule(int gradeRule) {
        this.gradeRule = gradeRule;
    }
}
