package com.bdtest.learn.controller;


import com.bdtest.learn.controller.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {
    public static Logger  LOGGER = LoggerFactory.getLogger(TestController.class);


    @GetMapping("/")
    public String test(Model model) {
        model.addAttribute("testMsg", "测试数据");
        model.addAttribute("testFlag", "2");
        List<UserDTO> userList = new ArrayList<>();
        UserDTO userDTO1 = new UserDTO(1L, "张三");
        UserDTO userDTO2 = new UserDTO(2L, "李四");
        UserDTO userDTO3 = new UserDTO(3L, "王五");
        userList.add(userDTO1);
        userList.add(userDTO2);
        userList.add(userDTO3);
        model.addAttribute("userList", userList);
        return "index";
    }
}
