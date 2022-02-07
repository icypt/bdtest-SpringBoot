package com.bdtest.learn.controller;

import com.bdtest.learn.entity.UserEntity;
import com.bdtest.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

@RestController
public class TestController {
    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;



    @GetMapping("/findUserByUserName")
    public UserEntity findUserByUserName(String userName){
        return userService.findUserByUserName(userName);
    }

    @GetMapping("/delete")
    public String delete(String key) {
        redisTemplate.delete(key);
        return "ok";
    }

    @GetMapping("/expire")
    public String expire(String key) {
        redisTemplate.expire(key,10, TimeUnit.SECONDS);
        return "ok";
    }
}
