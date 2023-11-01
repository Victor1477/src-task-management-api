package com.task.management.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.PrintStream;

@SpringBootApplication
public class TaskManagementApiApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        System.setOut(new PrintStream(new JFrameApplicationOutput()));
        SpringApplication.run(TaskManagementApiApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST", "DELETE", "PUT", "OPTIONS");
            }
        };
    }
}