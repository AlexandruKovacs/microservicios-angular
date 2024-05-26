package com.app.microservice.students.services;

import org.springframework.stereotype.Service;

import com.app.microservice.students.models.repository.StudentRepository;
import com.microservice.commons.services.CommonServiceImpl;
import com.microservice.commons.students.models.entity.Student;

@Service
public class StudentServiceImpl extends CommonServiceImpl<Student, StudentRepository> implements StudentService {

}
