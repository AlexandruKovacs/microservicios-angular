package com.app.microservice.users.services;

import org.springframework.stereotype.Service;

import com.app.microservice.users.models.entity.Student;
import com.app.microservice.users.models.repository.StudentRepository;
import com.microservice.commons.services.CommonServiceImpl;

@Service
public class StudentServiceImpl extends CommonServiceImpl<Student, StudentRepository> implements StudentService {

}
