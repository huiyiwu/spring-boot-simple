package com.huchx.comtroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RunAs;

/**
 * Author: Huchx
 * Date: 2021/2/3 11:00
 */
@RestController
public class IndexController {

    @RequestMapping("/")
    public  String index(){
        return "Hello World";
    }
}
