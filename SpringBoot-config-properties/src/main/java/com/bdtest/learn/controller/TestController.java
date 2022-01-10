package com.bdtest.learn.controller;


import com.bdtest.learn.config.TestConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @Value("${projectAttr}")
    private String projectAttr;

    @Autowired
    private TestConfig testConfig;

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return testConfig.toString();
    }

}
