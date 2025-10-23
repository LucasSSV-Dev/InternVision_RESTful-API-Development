package com.internvision.RESTfulAPIDevelopment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.internvision.RESTfulAPIDevelopment.user.application.repository")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

        System.out.println( "Application Started");
	}

}
