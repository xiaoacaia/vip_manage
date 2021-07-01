package com.zhang.supermarket_manage.mapper;

import com.zhang.supermarket_manage.pojo.DisplayRecords;
import com.zhang.supermarket_manage.pojo.GoodsRecords;

import java.util.List;

public interface GoodsRecordsMapper {
    List<GoodsRecords> getAllGoodsRecords();

    List<DisplayRecords> getDisplayGoodsRecords();

    void insertGoodsRecords(GoodsRecords goodsRecords);

    void deleteGoodsRecords(int id);

    void updateVipInformation(GoodsRecords goodsRecords);
}
