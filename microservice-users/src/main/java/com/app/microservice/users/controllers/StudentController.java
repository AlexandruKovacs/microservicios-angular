package com.app.microservice.users.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.microservice.users.models.entity.Student;
import com.app.microservice.users.services.StudentService;
import com.microservice.commons.controllers.CommonController;

@RestController
public class StudentController extends CommonController<Student, StudentService> {
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editStudent(@RequestBody Student student, @PathVariable Long id) {
		
		Optional<Student> optionalStudent = service.findById(id);
		
		if (optionalStudent.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Student editedStudent = optionalStudent.get();
		
		editedStudent.setName(student.getName());
		editedStudent.setSurname(student.getSurname());
		editedStudent.setEmail(student.getEmail());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(editedStudent));
	}
}
