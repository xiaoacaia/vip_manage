package com.zhang.supermarket_manage.service;


import com.zhang.supermarket_manage.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public String getPassword(String user_name){
        return userMapper.isUser(user_name) != null ?  userMapper.isUser(user_name).getPassword() : null;
    }
}
