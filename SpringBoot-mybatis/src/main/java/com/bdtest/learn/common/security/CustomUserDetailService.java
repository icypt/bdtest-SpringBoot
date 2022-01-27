package com.bdtest.learn.common.security;

import com.bdtest.learn.entity.UserEntity;
import com.bdtest.learn.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserServiceImpl userService;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        List<GrantedAuthority> permissions = new ArrayList<>();
        UserEntity userEntity = userService.findUserByUserName(userName);
        if(userEntity == null) {
            throw new UsernameNotFoundException("");
        }
        //查询角色
        List<String> userRoles = userService.findRolesByUserId(userEntity.getUserId());
        //查询权限
        List<String> userPers = userService.findPersByUserId(userEntity.getUserId());
        //角色和权限进行封装
        for(String role : userPers) {
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(role);
            permissions.add(simpleGrantedAuthority);
        }
        for(String per : userRoles) {
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(per);
            permissions.add(simpleGrantedAuthority);
        }
        return new User(userName, userEntity.getPassword(), permissions);
    }
}
