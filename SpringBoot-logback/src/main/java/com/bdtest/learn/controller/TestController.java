package com.bdtest.learn.controller;


import com.bdtest.learn.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    public static Logger  LOGGER = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private TestService testService;

    @GetMapping("/")
    public void test() {
        LOGGER.trace("controller trace 级别日志");
        LOGGER.debug("controller debug 级别日志");
        LOGGER.info("controller info 级别日志");
        LOGGER.warn("controller warn 级别日志");
        LOGGER.error("controller error 级别日志");
//        testService.test();
    }
}
