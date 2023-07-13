package com.app.services;

import java.util.List;
import java.util.Optional;

import com.app.dto.CourseRequestDto;
import com.app.dto.CourseResponseDto;
import com.app.entities.Course;

public interface CourseService {
	public List<CourseResponseDto> getAllCourses();
	public Course addCourse( CourseRequestDto c);
	public Optional<Course> getCourseById(Long cid);
	public String updateCourse(Course crs);
	String deleteCourse(Long cid);
}
