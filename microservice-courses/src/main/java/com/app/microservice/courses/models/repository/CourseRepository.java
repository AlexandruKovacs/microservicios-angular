package com.app.microservice.courses.models.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.app.microservice.courses.models.entity.Course;
import com.microservice.commons.repository.CrudAndPagingAndSortingRepository;

public interface CourseRepository extends CrudAndPagingAndSortingRepository<Course, Long> {

	@Query("SELECT c from Course c JOIN FETCH c.students a WHERE a.id = ?1")
	public Course findCourseByStudentId(Long id);
}
