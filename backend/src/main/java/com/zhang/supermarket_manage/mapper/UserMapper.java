package com.zhang.supermarket_manage.mapper;


import com.zhang.supermarket_manage.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    User isUser(String user_name);

}
