package com.bdtest.learn.controller;


import com.alibaba.fastjson.JSON;
import com.bdtest.learn.entity.UserEntity;
import com.bdtest.learn.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TestController {
    public static Logger  LOGGER = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/insert")
    public Object insert(UserEntity userEntity) {
        return userService.insert(userEntity);
    }

    @RequestMapping("/findAllUsers")
    public Object findAllUsers(String userId,String userName) {
        Map<String, Object> conditions = new HashMap<>();
        conditions.put("userId",userId);
        conditions.put("userName",userName);
        return userService.findAllUsers(conditions);
    }

    @RequestMapping("/batchInsert")
    public Object batchInsert(@RequestBody String userData) {
        List<UserEntity> userList =  JSON.parseArray(userData,UserEntity.class );
        return userService.batchInsert(userList);
    }

}
