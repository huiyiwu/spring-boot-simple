package com.huchx.mongo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("user")
public class UserController {

    @RequestMapping("insert")
    public String insert(String name,String id,String type){

        return "success";
    }
    @RequestMapping("select")
    public Object select(String key,String type){
       return "success";
    }
}
