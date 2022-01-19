package com.bdtest.learn.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    public static Logger LOGGER = LoggerFactory.getLogger(TestService.class);

    public void test() {
        LOGGER.trace("service trace 级别日志");
        LOGGER.debug("service debug 级别日志");
        LOGGER.info("service info 级别日志");
        LOGGER.warn("service warn 级别日志");
        LOGGER.error("service error 级别日志");
    }
}
