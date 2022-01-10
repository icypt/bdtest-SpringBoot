package com.bdtest.learn.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value("${projectAttr}")
    public String projectAttr;

    @RequestMapping("/test")
    public String test() {
        return projectAttr;
    }

}
