package com.example.education.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.education.entity.Enrollments;
import com.example.education.service.EnrollmentService;

@Controller
@RequestMapping("/enrollments")
public class EnrollmentController {
	 private final EnrollmentService enrollmentService;

	    @Autowired
	    public EnrollmentController(EnrollmentService enrollmentService) {
	        this.enrollmentService = enrollmentService;
	    }

	    @PostMapping("/enroll-student/{studentId}/in-course/{courseId}")
	    public ResponseEntity<String> enrollStudentInCourse(
	            @PathVariable Long studentId,
	            @PathVariable Long courseId
	    ) {
	        Enrollments enrollment = enrollmentService.enrollStudentInCourse(studentId, courseId);

	        if (enrollment != null) {
	            return ResponseEntity.ok("Student enrolled in the course successfully.");
	        } else {
	            return ResponseEntity.badRequest().body("Unable to enroll student in the course.");
	        }
	    }

}