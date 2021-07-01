package com.zhang.supermarket_manage.service;


import com.zhang.supermarket_manage.mapper.VipMapper;
import com.zhang.supermarket_manage.pojo.VipList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VipListService {

    @Autowired
    VipMapper vipMapper;

    public List<VipList> getAllVip(){
        return vipMapper.getAllVip();
    }
    public void updateVipById(VipList vipList){
        vipMapper.updateVipById(vipList);
    }

    public void  insertVip(VipList vipList){
        vipMapper.insertVip(vipList);
    }

    public void  deleteVip(int id){
        vipMapper.deleteVip(id);
    }

}
