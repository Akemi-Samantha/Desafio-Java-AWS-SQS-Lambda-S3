package com.estudo.desafiojavaaws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class DesafioJavaAwsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioJavaAwsApplication.class, args);
	}

}
