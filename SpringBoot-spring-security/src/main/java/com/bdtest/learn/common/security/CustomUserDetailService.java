package com.bdtest.learn.common.security;

import com.bdtest.learn.entity.UserEntity;
import com.bdtest.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
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
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        List<GrantedAuthority> permissions = new ArrayList<>();
        UserEntity userEntity = userService.findUserByUserName(userName);
        if(userEntity == null) {
            throw new UsernameNotFoundException("");
        }
        return new User(userName, userEntity.getPassword(), permissions);
    }
}
