package com.bdtest.learn.service.impl;

import com.bdtest.learn.entity.UserEntity;
import com.bdtest.learn.mapper.UserMapper;
import com.bdtest.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;


    @Override
    public UserEntity findUserByUserName(String userName) {
        String userKey = "userinfo:" + userName;
        UserEntity userEntity;
        if(redisTemplate.hasKey(userKey)) {
            userEntity = (UserEntity) redisTemplate.opsForValue().get(userKey);
        } else {
            userEntity = userMapper.findUserByUserName(userName);
            redisTemplate.opsForValue().set(userKey, userEntity);
        }
       return userEntity;
    }
}
