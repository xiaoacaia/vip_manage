package com.zhang.supermarket_manage.controller;

import com.zhang.supermarket_manage.pojo.User;
import com.zhang.supermarket_manage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/supermark_manage")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Boolean getPassword(@RequestBody User user){
        if(userService.getPassword(user.getUserName()) != null){
            return userService.getPassword(user.getUserName()).equals(user.getPassword());
        }
        return false ;
    }
}
