package com.huchx.application;

import com.huchx.application.listenter.MyApplicationListenter;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@RestController
@SpringBootApplication
public class Application
{


    public static void main(String[] args) {
        //自定义SpringApplication
        SpringApplication app = new SpringApplication(Application.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.addListeners(new MyApplicationListenter());
        app.run(args);


        //使用SpringApplicationBuilder构建
//        new SpringApplicationBuilder()
//                .sources(Parent.class)
//                .child(App.class)
//                .bannerMode(Banner.Mode.OFF)
//                .run(com.huchx.application.args);

        // 退出
//        System.exit(SpringApplication.exit(SpringApplication.run(App.class,com.huchx.application.args)));
    }
}
