package com.issac.webflux.router;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@SpringBootApplication
public class WebfluxRouterApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebfluxRouterApplication.class, args);
	}

}
