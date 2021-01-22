package com.huchx.rest.customizer;

import org.springframework.boot.web.reactive.function.client.WebClientCustomizer;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Author: Huchx
 * Date: 2021/1/22 15:45
 */
@Component
public class MyWebClientCustomizer implements WebClientCustomizer {
    @Override
    public void customize(WebClient.Builder webClientBuilder) {
        webClientBuilder.defaultCookie("huchx","123456").defaultHeader("huchx","123456");
    }
}
