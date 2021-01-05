package com.huchx.application.args;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

@Component
public class ArgmugentsBean {
    @Autowired
    public ArgmugentsBean(ApplicationArguments args) {
        System.out.println(args);
    }
}
