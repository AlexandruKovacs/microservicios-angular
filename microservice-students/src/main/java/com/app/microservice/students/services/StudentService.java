package com.app.microservice.students.services;

import java.util.List;

import com.microservice.commons.services.CommonService;
import com.microservice.commons.students.models.entity.Student;

public interface StudentService extends CommonService<Student> {

	public List<Student> findByNameOrSurname(String param);
	
}
