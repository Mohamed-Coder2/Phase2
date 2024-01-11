package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = {"com.example.demo", "Project", "Controllers", "events", "Services"})
public class Phase2Application {
	public static void main(String[] args) {
		SpringApplication.run(Phase2Application.class, args);
	}
}