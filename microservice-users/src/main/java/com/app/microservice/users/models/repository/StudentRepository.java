package com.app.microservice.users.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.microservice.users.models.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
