package com.huchx.webservice.config;

import com.huchx.webservice.service.HuchxService;
import com.huchx.webservice.service.impl.HuchxServiceImpl;
import org.apache.catalina.servlets.CGIServlet;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * Author: Huchx
 * Date: 2021/3/1 15:59
 */
@Configuration
public class CxfConfig {

    //注入服务
    @Bean
    public HuchxService huchxService(){
        return new HuchxServiceImpl();
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus(){
        return new SpringBus();
    }
    //使用ServletRegistrationBean以使Spring Boot支持Servlet功能
    // 此处通过CXFServelet处理/huchx/路径下的所有请求
    @Bean
    public ServletRegistrationBean dispatcherServelet(){
        return new ServletRegistrationBean(new CXFServlet(),"/huchx/*");
    }
    //通过端点发布WebService服务器
    @Bean
    public Endpoint endpoint(){
        EndpointImpl endpoint =new EndpointImpl(springBus(),huchxService());
        endpoint.publish("/service");
        return endpoint;
    }
}
