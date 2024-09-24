package com.app.microservice.exams.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.microservice.commons.exams.models.entity.Subject;

public interface SubjectRepository extends CrudRepository<Subject, Long> {

}
