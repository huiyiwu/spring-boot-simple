package com.huchx.comtroller;

import com.huchx.pojo.UserPojo;
import com.huchx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Huchx
 * Date: 2021/2/3 15:41
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("info")
    public UserPojo info(){
        return userService.detail();
    }
}
