package com.example.education.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Enrollments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name ="student_id")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name = "Course_id")
	private Courses Courses;
	
	// Contructors
	
	public Enrollments() {
		
	}

	public Enrollments(Student student, com.example.education.entity.Courses courses) {
		super();
		this.student = student;
		Courses = courses;
	}
	
	//Getters and Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Courses getCourses() {
		return Courses;
	}

	public void setCourses(Courses courses) {
		Courses = courses;
	}
	
	
	
	
	
	

}
