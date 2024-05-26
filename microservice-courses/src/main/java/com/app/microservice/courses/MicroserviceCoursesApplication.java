package com.app.microservice.courses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.microservice.commons.students.models.entity",
			 "com.app.microservice.courses.models.entity"})
public class MicroserviceCoursesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceCoursesApplication.class, args);
	}

}
