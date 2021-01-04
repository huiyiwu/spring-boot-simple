package com.huchx.mvc.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CorsController {
    /**
     * 单独接口的跨域请求配置
     * @return
     */
//    @CrossOrigin(origins = "http://10.2.102.40:8080")
    @RequestMapping("cors")
    public String cors(){
        return "success";
    }
}
