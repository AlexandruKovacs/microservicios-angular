package com.app.microservice.courses.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.microservice.courses.models.entity.Course;
import com.app.microservice.courses.services.CourseService;
import com.microservice.commons.controllers.CommonController;
import com.microservice.commons.students.models.entity.Student;

@RestController
public class CourseController extends CommonController<Course, CourseService> {

	@PutMapping("/{id}")
	public ResponseEntity<?> editCourse(@RequestBody Course course, @PathVariable Long id) {
		
		Optional<Course> optionalCourse = service.findById(id);
		
		if (optionalCourse.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Course editedCourse = optionalCourse.get();
		
		editedCourse.setName(course.getName());
		editedCourse.setDuration(course.getDuration());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(editedCourse));
	}
	
	@PutMapping("/{id}/add-students")
	public ResponseEntity<?> addStudents(@RequestBody List<Student> students, @PathVariable Long id) {
		
		Optional<Course> optionalCourse = service.findById(id);
		
		if (optionalCourse.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Course foundCourse = optionalCourse.get();
		
		students.forEach(student -> {
			foundCourse.addStudent(student);
		});
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(foundCourse));
	}
	
	@PutMapping("/{id}/delete-student")
	public ResponseEntity<?> deleteStudents(@RequestBody Student student, @PathVariable Long id) {
		
		Optional<Course> optionalCourse = service.findById(id);
		
		if (optionalCourse.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Course foundCourse = optionalCourse.get();
		
		foundCourse.removeStudent(student);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(foundCourse));
	}
}
