package com.huchx.pojo;

/**
 * Author: Huchx
 * Date: 2021/2/3 14:57
 */
public class UserPojo {
    private String name;
    private int age;

    public UserPojo() {
    }

    public UserPojo(String name, int age) {
        this.name = name;
        this.age = age;
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
