package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Course;
import com.app.repositories.CourseRepo;
@Service
@Transactional

public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepo cr;
	@Override
	public List<Course> getAllCourses() {
		
		return cr.findAll();
	}

	@Override
	public String addCourse(Course c) {
		cr.save(c);
		return "Course Added";
	}

}
