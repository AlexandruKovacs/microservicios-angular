package com.app.microservice.students.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.microservice.commons.students.models.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
	
	@Query("SELECT s FROM Student s WHERE s.name LIKE %?1% OR s.surname LIKE %?1%")
	public List<Student> findByNameOrSurname(String param);
	
}
