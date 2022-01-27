package com.bdtest.learn.mapper;

import com.bdtest.learn.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper {
    UserEntity findUserByUserName(String userName);
}
