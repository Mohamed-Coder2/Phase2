package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo", "Project"})
public class Phase2Application {

	public static void main(String[] args) {
		SpringApplication.run(Phase2Application.class, args);

	}
}