package com.bdtest.learn.controller;


import com.bdtest.learn.entity.UserEntity;
import com.bdtest.learn.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {
    public static Logger  LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    @PostMapping("/loginSuccess")
    @ResponseBody
    public Object loginSuccess(HttpSession session) {
        User principal = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userName = principal.getUsername();
        UserEntity userEntity = userService.findUserByUserName(userName);
        session.setAttribute("userInfo", userEntity);
        Map<String, Object> result = new HashMap<>();
        result.put("code", "000");
        return result;
    }

    @PostMapping("/loginFail")
    @ResponseBody
    public Object loginFail(HttpServletRequest request) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", "FFF");
        AuthenticationException authException = (AuthenticationException)request.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
        if(authException instanceof BadCredentialsException) {
            result.put("msg", "用户名或密码错误");
        } else {
            result.put("msg", "认证失败");
        }
        return result;
    }

    @GetMapping("/toIndex")
    public String toIndex() {
        return "index";
    }

}
