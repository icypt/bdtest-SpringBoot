package com.bdtest.learn.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Configuration
@ConfigurationProperties(prefix = "project")
public class TestConfig {

    @Value("${projectAttr}")
    private String projectAttr;
    @Value("${projectNameVal}")
    private String projectNameVal;
    private Map<String,Object> maps = new HashMap<>();
    private List<String> lists = new ArrayList<>();


    public String getProjectAttr() {
        return projectAttr;
    }

    public void setProjectAttr(String projectAttr) {
        this.projectAttr = projectAttr;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<String> getLists() {
        return lists;
    }

    public void setLists(List<String> lists) {
        this.lists = lists;
    }

    public String getProjectNameVal() {
        return projectNameVal;
    }

    public void setProjectNameVal(String projectNameVal) {
        this.projectNameVal = projectNameVal;
    }

    @Override
    public String toString() {
        return "TestConfig{" +
                "projectAttr='" + projectAttr + '\'' +
                ", projectNameVal='" + projectNameVal + '\'' +
                ", maps=" + maps +
                ", lists=" + lists +
                '}';
    }
}
