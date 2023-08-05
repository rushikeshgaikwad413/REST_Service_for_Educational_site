package com.example.education.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.education.entity.Courses;
import com.example.education.repository.CourseRepository;


@Service
public class CourseService {
	private final CourseRepository courseRepository;
	
	@Autowired
	public CourseService(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}
	
	public List<Courses> getAllCourses(){
		return courseRepository.findAll();
	}
	
	public Courses getCourseById(Long id) {
		return courseRepository.findById(id).orElse(null);
		
	}
	
	public Courses addCourse(Courses courses) {
		return courseRepository.save(courses);
	}
	
	public void deleteCourse(Long id) {
		courseRepository.deleteById(id);
	}
	

}
