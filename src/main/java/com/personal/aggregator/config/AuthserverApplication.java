package com.personal.aggregator.config;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.personal.aggregator")
@EnableJpaRepositories(basePackages = "com.personal.aggregator")
@EntityScan(basePackages = "com.personal.aggregator.entity")
@Configuration
public class AuthserverApplication {
    public static void main(String[] args){
        SpringApplication.run(AuthserverApplication.class, args);
    }

    @Bean
    public Gson getGson(){
        return new Gson();
    }

    @Bean
    public OkHttpClient getOkHttpClient(){
        return new OkHttpClient();
    }
}
