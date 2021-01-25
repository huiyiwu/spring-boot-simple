package com.huchx.validated.vo;

import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * Author: Huchx
 * Date: 2021/1/25 9:43
 */
public class UserVo  implements Serializable {
    public interface Default {
    }

    public interface Group1 {
    }

    @NotBlank(message = "userName不能为空")
    private String userName;
    @Max(value = 150,message = "年龄不能超过150")
    @Min(value = 18,message = "最小年龄不能小于18")
    private int age;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
