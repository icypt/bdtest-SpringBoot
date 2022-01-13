package com.bdtest.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @RequestMapping("/")
    public String goIndex() {
        return "index";
    }

    @RequestMapping(path = "/test4", method = RequestMethod.GET)
    @ResponseBody
    public String test4() {
        return "test4";
    }

    @RequestMapping(path = "/test4", method = RequestMethod.POST)
    @ResponseBody
    public String test5() {
        return "test5";
    }
}
