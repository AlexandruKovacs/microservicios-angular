package com.app.microservice.students.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.microservice.students.services.StudentService;
import com.microservice.commons.controllers.CommonController;
import com.microservice.commons.students.models.entity.Student;

@RestController
public class StudentController extends CommonController<Student, StudentService> {
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editStudent(@Validated @RequestBody Student student, BindingResult result, @PathVariable Long id) {
		
		if (result.hasErrors()) {
			return this.validate(result);
		}
		
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
	
	@GetMapping("/filter/{param}")
	public ResponseEntity<?> filter(@PathVariable String param) {
		
		
		
		return ResponseEntity.ok(service.findByNameOrSurname(param));
	}
}
