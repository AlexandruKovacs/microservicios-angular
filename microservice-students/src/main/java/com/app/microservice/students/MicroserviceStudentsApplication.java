package com.app.microservice.students;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.microservice.commons.students.models.entity"})
public class MicroserviceStudentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceStudentsApplication.class, args);
	}

}
