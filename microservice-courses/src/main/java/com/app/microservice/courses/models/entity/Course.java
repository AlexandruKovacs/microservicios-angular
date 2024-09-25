package com.app.microservice.courses.models.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.microservice.commons.exams.models.entity.Exam;
import com.microservice.commons.students.models.entity.Student;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "courses")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private String name;
	
	@NotNull
	private Integer duration;
	
	@Column(name = "create_at")
	private LocalDateTime createAt;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Student> students;
	
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Exam> exams;
	
	@PrePersist
	public void onCreate() {
		this.createAt = LocalDateTime.now();
	}
	
	public Course() {
		this.students = new ArrayList<Student>();
		this.exams = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	public void addStudent(Student student) {
		this.students.add(student);
	}
	
	public void removeStudent(Student student) {
		this.students.remove(student);
	}

	public List<Exam> getExams() {
		return exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}
	
	public void addExam(Exam exam) {
		this.exams.add(exam);
	}
	
	public void removeExam(Exam exam) {
		this.exams.remove(exam);
	}
}
