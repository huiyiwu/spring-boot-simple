package com.huchx.application.controller;

import com.huchx.application.config.HuchxProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Index {
    @Autowired
    HuchxProperty huchxProperty;
    @Value("${name}")
    String name;
    @Value("${random}")
    int randomValue;


    @RequestMapping("test1")
    public Object index(){
        return  huchxProperty;
    }

    @RequestMapping("test2")
    public String test(){
        return "name："+name+";随机值为:"+randomValue;
    }
}
