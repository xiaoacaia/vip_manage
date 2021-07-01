package com.zhang.supermarket_manage.mapper;

import com.zhang.supermarket_manage.pojo.GoodsList;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsListMapper {

    List<GoodsList> getAllGoodsList();

    void updateGoodsById(GoodsList goodsList);

    void insertGoods(GoodsList goodsList);

    void deleteGoods(int id);
}
