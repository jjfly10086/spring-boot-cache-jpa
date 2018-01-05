package com.jwh.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableCaching
@ImportResource(locations = "classpath:spring/applicationContext.xml")
public class StartApplication {

    public static void main(String[] args){
        SpringApplication.run(StartApplication.class,args);
    }
}
