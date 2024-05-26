package com.app.microservice.courses.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.microservice.courses.models.entity.Course;

public interface CourseRepository extends CrudRepository<Course, Long> {

}
