package com.app.microservice.students.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.microservice.students.models.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
