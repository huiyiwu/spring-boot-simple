package com.huchx.datajpa.controller;

import com.huchx.datajpa.entity.MUserEntity;
import com.huchx.datajpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("select")
    public List<MUserEntity> users(String type){
        if (type.equals("0")){
            return  userService.findAll();
        }else if (type.equals("1")){
            return userService.findAllByStatus(0);
        }else if (type.equals("2")){
            return userService.finAllByQuery();
        }
        return  null;
    }
}
