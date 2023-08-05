package com.example.education.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.education.entity.Courses;

public interface CourseRepository extends JpaRepository<Courses, Long> {

}
