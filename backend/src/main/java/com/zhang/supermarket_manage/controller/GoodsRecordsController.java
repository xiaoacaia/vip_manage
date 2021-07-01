package com.zhang.supermarket_manage.controller;

import com.zhang.supermarket_manage.pojo.DisplayRecords;
import com.zhang.supermarket_manage.pojo.GoodsList;
import com.zhang.supermarket_manage.pojo.GoodsRecords;
import com.zhang.supermarket_manage.service.GoodsRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/supermark_manage")
public class GoodsRecordsController {

    @Autowired
    GoodsRecordsService goodsRecordsService;


    @RequestMapping(value = "/getAllGoodsRecords", method = RequestMethod.GET)
    @ResponseBody
    public List<GoodsRecords> getAllGoodsRecords(){
        return goodsRecordsService.getAllGoodsRecords();
    }

    @RequestMapping(value = "/getDisplayGoodsRecords", method = RequestMethod.GET)
    @ResponseBody
    public List<DisplayRecords> getDisplayGoodsRecords(){
        return goodsRecordsService.getDisplayGoodsRecords();
    }


    @RequestMapping(value = "/deleteGoodsRecords", method = RequestMethod.POST)
    @ResponseBody
    public void deleteGoodsRecords(@RequestBody int id){
        goodsRecordsService.deleteGoodsRecords(id);
    }



    @RequestMapping(value = "/insertGoodsRecords", method = RequestMethod.POST)
    @ResponseBody
    public void insertGoodsRecords(@RequestBody GoodsRecords goodsRecords){
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime()); //2013-01-14 22:45:36.484
        goodsRecords.setShoppingTime(timestamp.toString());
        goodsRecordsService.insertGoodsRecords(goodsRecords);
    }

    @RequestMapping(value = "/updateVipInformation", method = RequestMethod.POST)
    @ResponseBody
    public void updateVipInformation(@RequestBody GoodsRecords goodsRecords){
        goodsRecordsService.updateVipInformation(goodsRecords);
    }





}
