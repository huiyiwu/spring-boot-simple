package com.huchx.webservice.client.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.webservices.client.WebServiceTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.client.core.WebServiceTemplate;

@Configuration
public class WebServiceCnnfig {
    String uri = "http://localhost:8080/huchx/service?wsdl";
    @Bean
    public WebServiceTemplate webServiceTemplate(WebServiceTemplateBuilder webServiceTemplateBuilder){
        WebServiceTemplate template = webServiceTemplateBuilder.setDefaultUri(uri).build();
        return template;
    }
}
