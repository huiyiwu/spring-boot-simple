package com.huchx.webservice.client.controller;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.dom4j.io.DocumentResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.xml.transform.StringSource;

import javax.xml.transform.Source;

/**
 * Author: Huchx
 * Date: 2021/3/1 16:58
 */
@RequestMapping("/huchx")
@RestController
public class WebServiceController {
    @Autowired
    WebServiceTemplate webServiceTemplate;
    @RequestMapping("/webservice")
    public String visitService(){
        JaxWsDynamicClientFactory factory = JaxWsDynamicClientFactory.newInstance();
        Client client = factory.createClient("http://localhost:8080/huchx/service?wsdl");
        try {
            Object[] objects =  client.invoke("sayHello","huchx");
            System.out.println("sayHello 返回结果："+objects[0].toString());
            return  objects[0].toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "获取失败";
        }
    }

    /**
     * 未实现使用WebServiceTemplate访问WebService
     */
}
