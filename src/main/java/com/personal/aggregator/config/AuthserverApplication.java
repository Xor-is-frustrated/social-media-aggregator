package com.personal.aggregator.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.personal.aggregator")
public class AuthserverApplication {
    public static void main(String[] args){
        System.out.println("ok");
        SpringApplication.run(AuthserverApplication.class, args);
    }
}
