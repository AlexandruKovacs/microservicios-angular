package com.microservice.commons.exams.models.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "subjects")
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@JsonIgnoreProperties(value = {"children"})
	@ManyToOne(fetch = FetchType.LAZY)
	private Subject parent;
	
	@JsonIgnoreProperties(value = {"parent"}, allowSetters = true)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "parent", cascade = CascadeType.ALL)
	private List<Subject> children;
	
	public Subject() {
		this.children = new ArrayList<>();
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

	public Subject getParent() {
		return parent;
	}

	public void setParent(Subject parent) {
		this.parent = parent;
	}

	public List<Subject> getChildren() {
		return children;
	}

	public void setChildren(List<Subject> children) {
		this.children = children;
	}
}
