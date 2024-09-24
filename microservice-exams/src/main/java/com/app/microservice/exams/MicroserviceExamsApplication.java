package com.app.microservice.exams;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.microservice.commons.exams.models.entity"})
public class MicroserviceExamsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceExamsApplication.class, args);
	}

}
