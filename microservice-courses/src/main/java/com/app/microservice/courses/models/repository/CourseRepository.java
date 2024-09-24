package com.app.microservice.courses.models.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.app.microservice.courses.models.entity.Course;

public interface CourseRepository extends CrudRepository<Course, Long> {

	@Query("SELECT c from Course c JOIN FETCH c.students a WHERE a.id = ?1")
	public Course findCourseByStudentId(Long id);
}
