package com.microservice.commons.exams.models.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name="exams")
public class Exam {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@Column(name = "create_at")
	private LocalDateTime createAt;
	
	@JsonIgnoreProperties(value = {"exam"}, allowSetters = true)
	@OneToMany(mappedBy = "exam", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Question> questions;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Subject subject;

	public Exam() {
		this.questions = new ArrayList<>();
	}

	@PrePersist
	public void onCreate() {
		this.createAt = LocalDateTime.now();
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

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions.clear();
		questions.forEach(this::addQuestion);
	}
	
	public void addQuestion(Question question) {
		this.questions.add(question);
		question.setExam(this);
	}
	
	public void removeQuestion(Question question) {
		this.questions.remove(question);
		question.setExam(null);
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj) {
			return true;
		}
		
		if (!(obj instanceof Exam)) {
			return false;
		}
		
		Exam e = (Exam) obj;
		
		return this.id != null && this.id.equals(e.getId());
	}
}
