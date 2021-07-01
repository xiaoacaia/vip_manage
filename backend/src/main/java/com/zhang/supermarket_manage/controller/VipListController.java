package com.zhang.supermarket_manage.controller;


import com.zhang.supermarket_manage.pojo.User;
import com.zhang.supermarket_manage.pojo.VipList;
import com.zhang.supermarket_manage.service.VipListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/supermark_manage")
public class VipListController {

    @Autowired
    VipListService vipListService;

//    @RequestMapping("getVip/{id}")
//    public String GetVip(@PathVariable int id){
//        System.out.println(vipListService.Sel(id));
//        return vipListService.Sel(id).toString();
//    }

    @RequestMapping(value = "/getAllVip", method = RequestMethod.GET)
    @ResponseBody
    public List<com.zhang.supermarket_manage.pojo.VipList> getAllVip(){
        return vipListService.getAllVip();
    }

    @RequestMapping(value = "/updateVip", method = RequestMethod.POST)
    @ResponseBody
    public void updateVip(@RequestBody VipList vipList){
        vipListService.updateVipById(vipList);
    }

    @RequestMapping(value = "/insertVip", method = RequestMethod.POST)
    @ResponseBody
    public void insertVip(@RequestBody VipList vipList){
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime()); //2013-01-14 22:45:36.484
        vipList.setCreateTime(timestamp.toString());
        vipListService.insertVip(vipList);
    }

    @RequestMapping(value = "/deleteVip", method = RequestMethod.POST)
    @ResponseBody
    public void deleteVip(@RequestBody int id){
        vipListService.deleteVip(id);
    }

}
