package com.bdtest.learn.controller;

import com.bdtest.learn.entity.UserEntity;
import com.bdtest.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private UserService userService;



    @GetMapping("/findUserByUserName")
    public UserEntity findUserByUserName(String userName){
        return userService.findUserByUserName(userName);
    }
}
