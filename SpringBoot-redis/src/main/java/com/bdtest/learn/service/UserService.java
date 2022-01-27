package com.bdtest.learn.service;

import com.bdtest.learn.entity.UserEntity;

public interface UserService {
    UserEntity findUserByUserName(String userName);
}
