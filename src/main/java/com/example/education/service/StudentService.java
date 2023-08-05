package com.example.education.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.education.entity.Student;
import com.example.education.repository.StudentRepository;

@Service
public class StudentService {
	private final StudentRepository studentRepository;
	
	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
		
	}
//	
//	public List<Student> getAllStudent(){
//		return studentRepository.findAll();
		
//	}
	
	public Student getStudentById(Long id) {
		return studentRepository.findById(id).orElse(null);
		
	}
	
	public Student addStudent(Student student) {
		return studentRepository.save(student);
		
	}
	
	public void deleteStudent (Long id) {
		studentRepository.deleteById(id);
		
	}

	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
