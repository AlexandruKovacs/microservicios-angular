package com.microservice.commons.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservice.commons.services.CommonService;

public class CommonController<E, S extends CommonService<E>> {

	@Autowired
	protected S service;
	
	@GetMapping
	public ResponseEntity<?> listAll() {
		return ResponseEntity.ok().body(service.findAll());	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getOneById(@PathVariable Long id) {
		
		Optional<E> optionalEntity = service.findById(id);
		
		if (optionalEntity.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(optionalEntity.get());
	}
	
	@PostMapping
	public ResponseEntity<?> save(@Validated @RequestBody E entity, BindingResult result) {
		
		if (result.hasErrors()) {
			return this.validate(result);
		}
		
		E newEntity = service.save(entity);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(newEntity);
	}
	
	@DeleteMapping
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		service.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
	
	protected ResponseEntity<?> validate(BindingResult result) {
		
		Map<String, Object> errors = new HashMap<>();
		
		result.getFieldErrors().forEach(err -> {
			errors.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
		});
		
		return ResponseEntity.badRequest().body(errors);
	}
}
