package com.app.SpringBootProject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootProjectApplication {
	private static final Logger LOGGER = LogManager.getLogger(SpringBootProjectApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProjectApplication.class, args);
		LOGGER.info("Application started. . .!!!");

	}
}
