package com.johana.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.johana.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
