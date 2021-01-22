package com.huchx.rest.customizer;

import com.huchx.rest.interceptors.CustomizerIntercerptor;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Author: Huchx
 * Date: 2021/1/22 16:27
 */
@Component
public class MyRestTemplateCustomizer implements RestTemplateCustomizer {
    @Override
    public void customize(RestTemplate restTemplate) {
        restTemplate.getInterceptors().add(new CustomizerIntercerptor());
    }
}
