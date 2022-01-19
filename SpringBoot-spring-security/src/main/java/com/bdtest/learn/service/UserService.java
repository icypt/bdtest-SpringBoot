package com.bdtest.learn.service;

import com.bdtest.learn.dao.UserDao;
import com.bdtest.learn.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 根据用户名称查询用户信息
     * @param userName
     * @return
     */
    public UserEntity findUserByUserName(String userName) {
        return userDao.findUserByUserName(userName);
    }

}
