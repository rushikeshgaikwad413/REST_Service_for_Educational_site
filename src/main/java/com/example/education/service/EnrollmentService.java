package com.example.education.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.education.entity.Courses;
import com.example.education.entity.Enrollments;
import com.example.education.entity.Student;
import com.example.education.repository.CourseRepository;
import com.example.education.repository.EnrollmentRepository;
import com.example.education.repository.StudentRepository;

@Service
public class EnrollmentService {
	private final EnrollmentRepository enrollmentRepository;
	private final CourseRepository courseRepository;
	private final StudentRepository studentRepository;
	
	
	@Autowired
	//constructor

	public EnrollmentService(EnrollmentRepository enrollmentRepository, CourseRepository courseRepository, StudentRepository studentRepository) {
		super();
		this.enrollmentRepository = enrollmentRepository;
		this.courseRepository = courseRepository;
		this.studentRepository = studentRepository;
	}

    public Enrollments enrollStudentInCourse(Long studentId, Long courseId) {
    	Student student = studentRepository.findById(studentId).orElse(null);
    	Courses courses = courseRepository.findById(courseId).orElse(null);
    	
    	if (student != null && courses != null) {
    		Enrollments enrollments = new Enrollments(student,courses);
    		return enrollmentRepository.save(enrollments);
    	}
    	return null;
    }
	
	

}
