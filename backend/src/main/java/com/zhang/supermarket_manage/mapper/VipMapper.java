package com.zhang.supermarket_manage.mapper;


import com.zhang.supermarket_manage.pojo.VipList;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VipMapper {
    List<VipList> getAllVip();

    void updateVipById(VipList vipList);

    void insertVip(VipList vipList);

    void deleteVip(int id);
}
