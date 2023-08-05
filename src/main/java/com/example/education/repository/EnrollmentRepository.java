package com.example.education.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.education.entity.Enrollments;

public interface EnrollmentRepository extends JpaRepository<Enrollments, Long>{

}
