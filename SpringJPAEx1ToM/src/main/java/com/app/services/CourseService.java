package com.app.services;

import java.util.List;

import com.app.entities.Course;

public interface CourseService {
	public List<Course> getAllCourses();
	public String addCourse( Course c);
}
