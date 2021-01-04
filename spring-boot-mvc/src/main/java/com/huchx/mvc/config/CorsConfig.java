package com.huchx.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 *全局跨域请求配置
 */
@Configuration
public class CorsConfig {
    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",config());
        return new CorsFilter(source);
    }

    private CorsConfiguration config() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("http://10.2.102.40:8080");//or  config.addAllowedOrigin("http://10.2.102.40:8080");
        return config;
    }
}
