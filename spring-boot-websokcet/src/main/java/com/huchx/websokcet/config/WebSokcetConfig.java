package com.huchx.websokcet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import javax.websocket.server.ServerEndpoint;

/**
 * Author: Huchx
 * Date: 2021/2/9 9:44
 */
@Configuration
public class WebSokcetConfig {
    /**
     * 自动注册使用@ServerEndpoint注解声明的websocket endpoin
     * @return
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }
}
