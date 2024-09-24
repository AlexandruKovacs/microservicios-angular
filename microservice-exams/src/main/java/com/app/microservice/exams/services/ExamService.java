package com.app.microservice.exams.services;

import java.util.List;

import com.microservice.commons.exams.models.entity.Exam;
import com.microservice.commons.exams.models.entity.Subject;
import com.microservice.commons.services.CommonService;

public interface ExamService extends CommonService<Exam> {

	public List<Exam> findByName(String param);
	
	public Iterable<Subject> findAllSubjects();
	
}
