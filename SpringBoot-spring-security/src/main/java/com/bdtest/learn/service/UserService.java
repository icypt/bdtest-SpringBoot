package com.bdtest.learn.service;

import com.bdtest.learn.dao.UserDao;
import com.bdtest.learn.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

        /**
         * 根据用户ID查询角色信息
         * @param userId
         * @return
         */
        public List<String> findRolesByUserId(Long userId) {
            return userDao.findRolesByUserId(userId);
        }


        /**
         * 根据用户ID查询权限信息
         * @param userId
         * @return
         */
        public List<String> findPersByUserId(Long userId) {
            return userDao.findPersByUserId(userId);
        }
}
