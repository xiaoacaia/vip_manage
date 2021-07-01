package com.zhang.supermarket_manage.controller;

import com.zhang.supermarket_manage.pojo.GoodsList;
import com.zhang.supermarket_manage.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/supermark_manage")
public class GoodsListController {

    @Autowired
    GoodsService goodsService;


    @RequestMapping(value = "/getAllGoods", method = RequestMethod.GET)
    @ResponseBody
    public List<GoodsList> getAllGoods(){
        return goodsService.getAllGoodsList();
    }

    @RequestMapping(value = "/updateGoods", method = RequestMethod.POST)
    @ResponseBody
    public void updateGoodsById(@RequestBody GoodsList goodsList){
        goodsService.updateGoodsById(goodsList);
    }

    @RequestMapping(value = "/insertGoods", method = RequestMethod.POST)
    @ResponseBody
    public void insertGoods(@RequestBody GoodsList goodsList){
        goodsService.insertGoods(goodsList);
    }

    @RequestMapping(value = "/deleteGoods", method = RequestMethod.POST)
    @ResponseBody
    public void deleteGoods(@RequestBody int id){
        goodsService.deleteGoods(id);
    }

}