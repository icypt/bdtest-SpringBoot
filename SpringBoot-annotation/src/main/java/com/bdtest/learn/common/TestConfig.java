package com.bdtest.learn.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Configuration
@ConfigurationProperties(prefix = "project")
public class TestConfig {

    @Value("${projectName}")
    private String projectName;

    private Map<String, Object>  maps = new HashMap<>();


    @Bean
    public Person getPerson() {
        Person person = new Person();
        person.setName("小明");
        person.setAge(18);
        return person;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }
}
