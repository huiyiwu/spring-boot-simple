package com.huchx.property;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class PropertyApp
{
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(PropertyApp.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}
