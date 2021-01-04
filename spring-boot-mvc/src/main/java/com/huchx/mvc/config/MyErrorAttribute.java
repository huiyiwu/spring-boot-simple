package com.huchx.mvc.config;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Configuration
public class MyErrorAttribute extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String,Object> attributes = super.getErrorAttributes(webRequest,includeStackTrace);
        attributes.put("code","-1");
        attributes.put("message","发生异常");
        return attributes;
    }
}
