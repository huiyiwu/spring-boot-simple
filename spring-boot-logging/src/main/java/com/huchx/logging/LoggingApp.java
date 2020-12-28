package com.huchx.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.logging.LoggingSystem;


/**
 * Hello world!
 *
 */
@SpringBootApplication
public class LoggingApp
{
    static Logger logger =  LoggerFactory.getLogger(LoggingApp.class);
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        logger.info("开始启动");
        SpringApplication.run(LoggingApp.class,args);
    }
}
