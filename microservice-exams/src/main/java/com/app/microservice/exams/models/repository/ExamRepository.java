package com.app.microservice.exams.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.microservice.commons.exams.models.entity.Exam;

public interface ExamRepository extends CrudRepository<Exam, Long> {

	@Query("SELECT e FROM Exam e WHERE e.name LIKE %?1%")
	public List<Exam> findByName(String param);
	
}
