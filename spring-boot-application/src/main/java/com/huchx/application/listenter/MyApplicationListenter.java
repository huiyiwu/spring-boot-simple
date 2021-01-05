package com.huchx.application.listenter;

import org.springframework.boot.context.event.*;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class MyApplicationListenter implements ApplicationListener{
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if (applicationEvent instanceof ApplicationStartingEvent){
            System.out.println("**********ApplicationStartingEvent：程序开始启动**********");
        }else if (applicationEvent instanceof ApplicationEnvironmentPreparedEvent){
            System.out.println("**********ApplicationEnvironmentPreparedEvent：开始准备上下文**********");
        }else if (applicationEvent instanceof ApplicationPreparedEvent){
            System.out.println("**********ApplicationPreparedEvent：上下文已经准备完毕,加载bea**********n");
        }else if (applicationEvent instanceof ApplicationStartedEvent){
            System.out.println("**********ApplicationStartedEvent：程序已启动**********");
        }else if (applicationEvent instanceof ApplicationReadyEvent){
            System.out.println("**********ApplicationReadyEvent：程序已已准备好提供服务**********");
        }else if (applicationEvent instanceof ApplicationFailedEvent){
            System.out.println("**********ApplicationFailedEvent：程序发生异常**********");
        }
    }
}
