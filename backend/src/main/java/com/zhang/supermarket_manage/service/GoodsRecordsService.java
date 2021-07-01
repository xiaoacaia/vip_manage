package com.zhang.supermarket_manage.service;

import com.zhang.supermarket_manage.mapper.GoodsRecordsMapper;
import com.zhang.supermarket_manage.pojo.DisplayRecords;
import com.zhang.supermarket_manage.pojo.GoodsRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsRecordsService {

    @Autowired
    GoodsRecordsMapper goodsRecordsMapper;

    public List<GoodsRecords> getAllGoodsRecords(){
        return goodsRecordsMapper.getAllGoodsRecords();
    }

    public List<DisplayRecords> getDisplayGoodsRecords(){
        return goodsRecordsMapper.getDisplayGoodsRecords();
    }

    public void  insertGoodsRecords(GoodsRecords goodsRecords){
        goodsRecordsMapper.insertGoodsRecords(goodsRecords);
    }

    public void  deleteGoodsRecords(int id){
        goodsRecordsMapper.deleteGoodsRecords(id);
    }

    public void updateVipInformation(GoodsRecords goodsRecords){
        goodsRecordsMapper.updateVipInformation(goodsRecords);
    }

}
