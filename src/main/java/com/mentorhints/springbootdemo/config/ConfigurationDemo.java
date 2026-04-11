package com.springboot.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationDemo {


    @Bean
    public String createConfiguration() {
        System.out.println("Configuration applied to this app!!");
        return "Configuration applied to this app!!";
    }


    public void nonConfig() {
        System.out.println("non config!!!");
    }
}