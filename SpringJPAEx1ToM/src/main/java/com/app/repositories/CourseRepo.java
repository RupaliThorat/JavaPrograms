package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Course;
@Repository
public interface CourseRepo extends JpaRepository<Course, Long> {

}
