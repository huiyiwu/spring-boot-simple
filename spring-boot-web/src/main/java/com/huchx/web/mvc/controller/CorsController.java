package com.huchx.web.mvc.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CorsController {
    @CrossOrigin(origins = "http://10.2.102.66")
    @RequestMapping("cors")
    public String cors(){
        return "success";
    }
}
