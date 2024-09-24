package com.app.microservice.students.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.microservice.students.models.repository.StudentRepository;
import com.microservice.commons.services.CommonServiceImpl;
import com.microservice.commons.students.models.entity.Student;

@Service
public class StudentServiceImpl extends CommonServiceImpl<Student, StudentRepository> implements StudentService {

	@Override
	@Transactional(readOnly = true)
	public List<Student> findByNameOrSurname(String param) {
		return repository.findByNameOrSurname(param);
	}

}
