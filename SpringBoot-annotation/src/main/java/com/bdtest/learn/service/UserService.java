package com.bdtest.learn.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String getUserNameById(Integer userId) {
        if(userId != 1) {
            throw  new RuntimeException();
        }
        return "冰点IT";
    }
}
