package com.example.education.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.education.entity.Courses;
import com.example.education.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {
	 private final CourseService courseService;

	    @Autowired
	    public CourseController(CourseService courseService) {
	        this.courseService = courseService;
	    }

	    @GetMapping
	    public List<Courses> getAllCourses() {
	        return courseService.getAllCourses();
	    }

	    @GetMapping("/{id}")
	    public Courses getCourseById(@PathVariable Long id) {
	        return courseService.getCourseById(id);
	    }

	    @PostMapping
	    public Courses addCourse(@RequestBody Courses course) {
	        return courseService.addCourse(course);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteCourse(@PathVariable Long id) {
	        courseService.deleteCourse(id);
	    }

}
