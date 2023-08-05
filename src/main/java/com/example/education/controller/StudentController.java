package com.example.education.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.education.entity.Student;
import com.example.education.service.StudentService;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudent();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}






//
//@Controller
//public class StudentController {
//	private final StudentService studentservice;
//
//	
//	public StudentController(StudentService studentservice) {
//		super();
//		this.studentService = studentService;
//	}
//	
//	@GetMapping
//	public List<Student> getAllStudents(){
//		return studentservice.getAllStudent();
//		
//	}
//	
//	
////	@GetMapping("/students")
////	public String listStudents(Model model) {
////		model.addAttribute("Students", studentService.getAllStudents());
////		return "students";
//		
//	
//	
//	
//	@GetMapping("/{id}")
//    public Student getStudentById(@PathVariable Long id) {
//        return studentservice.getStudentById(id);
//    }
//
//    @PostMapping
//    public Student addStudent(@RequestBody Student student) {
//        return studentservice.addStudent(student);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteStudent(@PathVariable Long id) {
//        studentservice.deleteStudent(id);
//    }
//	
//	
//	
//
//}
