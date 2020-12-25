package com.huchx.property.config;

import com.huchx.property.pojo.HuchxPojo;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ConfigurationProperties(prefix = "huchx")
public class HuchxProperty {
    private String name;
    private int age;
    private List<HuchxPojo> list = new ArrayList<>();

    public List<HuchxPojo> getList() {
        return list;
    }

    public void setList(List<HuchxPojo> list) {
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
