package com.bdtest.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

    @RequestMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("msg", "世界 您好！！！");
        return "helloWorld";
    }
}
