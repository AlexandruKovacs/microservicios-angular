package com.app.microservice.exams.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.microservice.exams.models.repository.ExamRepository;
import com.app.microservice.exams.models.repository.SubjectRepository;
import com.microservice.commons.exams.models.entity.Exam;
import com.microservice.commons.exams.models.entity.Subject;
import com.microservice.commons.services.CommonServiceImpl;

@Service
public class ExamServiceImpl extends CommonServiceImpl<Exam, ExamRepository> implements ExamService {

	@Autowired
	private SubjectRepository subjectRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Exam> findByName(String param) {
		return repository.findByName(param);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Subject> findAllSubjects() {
		return subjectRepository.findAll();
	}

}
