package com.bdtest.learn.dao;

import com.bdtest.learn.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserDao {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserEntity findUserByUserName(String userName) {
        //构建用户数据，模拟用户表
        List<UserEntity> userEntityList = new ArrayList<>();
        for(int i=1; i<=3; i++) {
            UserEntity userEntity = new UserEntity();
            userEntity.setUserId((long)i);
            userEntity.setUserName("test_0" + i);
            userEntity.setPassword(passwordEncoder.encode("123"));
            userEntityList.add(userEntity);
        }
        //根据用户名称进行过滤，模拟数据库查询
        userEntityList = userEntityList.stream().
                filter(userEntity -> userEntity.getUserName().equalsIgnoreCase(userName)).
                collect(Collectors.toList());
        return userEntityList.size() > 0 ? userEntityList.get(0) : null;
    }
}
