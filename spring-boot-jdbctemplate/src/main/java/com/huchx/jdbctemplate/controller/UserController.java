package com.huchx.jdbctemplate.controller;

import com.huchx.jdbctemplate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("select")
    public Map<String,Object> getUsers(){
        Map<String,Object> result =new HashMap<>();
        result.put("code","200");
        result.put("msg","success");
        result.put("result", userService.select());
        return result;
    }
    @RequestMapping("insert")
    public Map<String,Object> addUser(String name){
        Map<String,Object> result =new HashMap<>();
        result.put("code","200");
        result.put("msg","success");
        userService.insert(name);
        return result;
    }
    @RequestMapping("update")
    public Map<String,Object> updateUser(String id,String name){
        Map<String,Object> result =new HashMap<>();
        result.put("code","200");
        result.put("msg","success");
        userService.update(Integer.parseInt(id),name);
        return result;
    }
    @RequestMapping("delete")
    public Map<String,Object> delUser(String id){
        Map<String,Object> result =new HashMap<>();
        result.put("code","200");
        result.put("msg","success");
        userService.delete(Integer.parseInt(id));
        return result;
    }
}
