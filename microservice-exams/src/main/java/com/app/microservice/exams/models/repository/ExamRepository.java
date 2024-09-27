package com.app.microservice.exams.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.microservice.commons.exams.models.entity.Exam;
import com.microservice.commons.repository.CrudAndPagingAndSortingRepository;

public interface ExamRepository extends CrudAndPagingAndSortingRepository<Exam, Long> {

	@Query("SELECT e FROM Exam e WHERE e.name LIKE %?1%")
	public List<Exam> findByName(String param);
	
}
