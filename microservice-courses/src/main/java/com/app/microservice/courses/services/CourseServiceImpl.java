package com.app.microservice.courses.services;

import org.springframework.stereotype.Service;

import com.app.microservice.courses.models.entity.Course;
import com.app.microservice.courses.models.repository.CourseRepository;
import com.microservice.commons.services.CommonServiceImpl;

@Service
public class CourseServiceImpl extends CommonServiceImpl<Course, CourseRepository> implements CourseService {

}
