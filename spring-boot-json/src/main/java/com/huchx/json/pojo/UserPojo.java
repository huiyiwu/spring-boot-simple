package com.huchx.json.pojo;

import com.huchx.json.annotation.GsonTransparent;

import java.io.Serializable;

public class UserPojo implements Serializable {
    private String name;
    private String age;

    public UserPojo() {
    }

    public UserPojo(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
