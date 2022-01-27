package com.bdtest.learn.service.impl;

import com.bdtest.learn.entity.UserEntity;
import com.bdtest.learn.mapper.UserMapper;
import com.bdtest.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserEntity findUserByUserName(String userName) {
       return userMapper.findUserByUserName(userName);
    }
}
