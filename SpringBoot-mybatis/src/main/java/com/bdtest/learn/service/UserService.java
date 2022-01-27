package com.bdtest.learn.service;

import com.bdtest.learn.entity.UserEntity;

import java.util.List;
import java.util.Map;

public interface UserService {
    /**
     * 根据用户名称查询用户信息
     * @param userName
     * @return
     */
    public UserEntity findUserByUserName(String userName);

    /**
     * 根据用户ID查询角色信息
     * @param userId
     * @return
     */
    public List<String> findRolesByUserId(Long userId);


    /**
     * 根据用户ID查询权限信息
     * @param userId
     * @return
     */
    public List<String> findPersByUserId(Long userId);

    /**
     * 用户信息插入
     * @param userEntity
     * @return
     */
    public Boolean insert(UserEntity userEntity);

    /**
     * 根据条件查询所有用户
     * @param conditions
     * @return
     */
    public List<UserEntity> findAllUsers(Map<String, Object> conditions);


    /**
     * 批量插入用户数据
     * @param userList
     * @return
     */
    public Boolean batchInsert(List<UserEntity> userList);
}
