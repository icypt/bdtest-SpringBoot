package com.bdtest.learn.controller;

import com.bdtest.learn.common.Person;
import com.bdtest.learn.common.TestConfig;
import com.bdtest.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private TestConfig testConfig;

    @Autowired
    private Person getPerson;

    @GetMapping("/test1")
    public String test1() {
        return "test1";
    }

    @PostMapping("/test1")
    public String test2() {
        return "test2";
    }

    @PostMapping("/test1/{userName}")
    @ResponseBody
    public String test3(@PathVariable(name = "userName") String userName) {
        return userName;
    }

    @GetMapping("/getUserNameById/{userId}")
    public String getUserNameById(@PathVariable(name = "userId") String userId) {
        return userService.getUserNameById(Integer.parseInt(userId));
    }

    @GetMapping("/getPersonInfo")
    public String getPersonInfo() {
        return getPerson.toString();
    }

    @GetMapping("/getConfigInfo")
    public String getConfigInfo() {
        return testConfig.getProjectName() + "&&" + testConfig.getMaps();
    }

}
