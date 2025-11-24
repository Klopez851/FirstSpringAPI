package com.example.first_spring_app;

import com.example.first_spring_app.Controller.TaskController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

///what makes your project a Spring Boot project,a bundle of @s including @conponetscan, which scans for controllers,
/// service, repo...etc)
@SpringBootApplication
public class FirstSpringApp {
    public static void main(String[] args) {
        SpringApplication.run(FirstSpringApp.class, args);
        // program stars here and launches webserver, controllers, and all autoconfigs
    }
}
