package com.zhang.supermarket_manage.service;

import com.zhang.supermarket_manage.mapper.GoodsListMapper;
import com.zhang.supermarket_manage.mapper.VipMapper;
import com.zhang.supermarket_manage.pojo.GoodsList;
import com.zhang.supermarket_manage.pojo.VipList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {

    @Autowired
    GoodsListMapper goodsListMapper;

    public List<GoodsList> getAllGoodsList(){
        return goodsListMapper.getAllGoodsList();
    }
    public void updateGoodsById(GoodsList goodsList){
        goodsListMapper.updateGoodsById(goodsList);
    }

    public void  insertGoods(GoodsList goodsList){
        goodsListMapper.insertGoods(goodsList);
    }

    public void  deleteGoods(int id){
        goodsListMapper.deleteGoods(id);
    }



}
