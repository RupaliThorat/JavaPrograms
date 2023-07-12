package com.app.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Course;
import com.app.services.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CourseService cs;
	
	@GetMapping
	public List<Course> getAllCourses(){
		return cs.getAllCourses();
	}
	@PostMapping
	public String addCourse(@RequestBody Course c){
		System.out.println(c);
		String msg=cs.addCourse(c);
		System.out.println(msg);
		
		return msg;
		
	}
}
