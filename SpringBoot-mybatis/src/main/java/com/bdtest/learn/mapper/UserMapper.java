package com.bdtest.learn.mapper;

import com.bdtest.learn.entity.UserEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    void insert(UserEntity userEntity);

    List<UserEntity> findAllUsers(@Param("conditions") Map<String, Object> conditions);

    void batchInsert(@Param("userList") List<UserEntity> userList);

    UserEntity findUserByUserName(@Param("userName") String userName);

}
