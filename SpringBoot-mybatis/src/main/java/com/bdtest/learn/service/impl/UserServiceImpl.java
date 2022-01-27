package com.bdtest.learn.service.impl;

import com.bdtest.learn.dao.UserDao;
import com.bdtest.learn.entity.UserEntity;
import com.bdtest.learn.mapper.UserMapper;
import com.bdtest.learn.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private static Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

        /**
         * 根据用户名称查询用户信息
         * @param userName
         * @return
         */
        public UserEntity findUserByUserName(String userName) {
            return userMapper.findUserByUserName(userName);
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

    @Override
    public Boolean insert(UserEntity userEntity) {
        try {
            userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
            userMapper.insert(userEntity);
            LOGGER.info("递增主键ID：{}", userEntity.getUserId());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("用户信息插入异常");
        }
        return true;
    }

    @Override
    public List<UserEntity> findAllUsers(Map<String, Object> conditions) {
        return userMapper.findAllUsers(conditions);
    }

    @Override
    public Boolean batchInsert(List<UserEntity> userList) {
        try {
            userMapper.batchInsert(userList);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("用户信息批量插入异常");
        }
        return true;
    }
}
