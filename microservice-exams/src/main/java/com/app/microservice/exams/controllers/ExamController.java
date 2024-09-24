package com.app.microservice.exams.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.microservice.exams.services.ExamService;
import com.microservice.commons.controllers.CommonController;
import com.microservice.commons.exams.models.entity.Exam;

@RestController
public class ExamController extends CommonController<Exam, ExamService> {
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editExam(@RequestBody Exam exam, @PathVariable Long id) {
		
		Optional<Exam> optionalExam = service.findById(id);
		
		if (optionalExam.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Exam editExam = optionalExam.get();
		
		editExam.setName(exam.getName());
		
		// OBTENEMOS LAS PREGUNTAS, LAS CONVERTIMOS A UN STREAM, 
		// FILTRAMOS POR PREGUNTAS QUE EXISTEN EN BASE DE DATOS PERO QUE NO EXISTEN EN EL JSON DEL CUERPO
		// CON EL FOREACH SE ELIMINAN LAS QUE YA EXISTEN
		editExam.getQuestions()
			.stream()
			.filter(eq -> !exam.getQuestions().contains(eq))
			.forEach(editExam::removeQuestion);
		
		editExam.setQuestions(exam.getQuestions());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(editExam));
	}
	
	@GetMapping("/filter/{param}")
	public ResponseEntity<?> filter(@PathVariable String param) {
		return ResponseEntity.ok(service.findByName(param));
	}
	
	@GetMapping("/subjects")
	public ResponseEntity<?> listSubjects() {
		return ResponseEntity.ok(service.findAllSubjects());
	}
}
