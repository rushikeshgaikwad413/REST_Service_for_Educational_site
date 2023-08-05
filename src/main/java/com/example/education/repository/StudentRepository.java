package com.example.education.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.education.entity.Student;

public interface StudentRepository extends JpaRepository <Student, Long> {

}
