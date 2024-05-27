package com.task.management.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;

@SpringBootApplication
public class TaskManagementApiApplication {

    public static void main(String[] args) throws FileNotFoundException {
        System.setOut(Logger.getPrintStream());
        SpringApplication.run(TaskManagementApiApplication.class, args);
    }
}