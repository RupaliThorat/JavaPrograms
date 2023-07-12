package com.app.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CourseRequestDto;
import com.app.dto.CourseResponseDto;
import com.app.entities.Course;
import com.app.services.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CourseService cs;
	
	@GetMapping
	public List<CourseResponseDto> getAllCourses(){
		return cs.getAllCourses();
	}
	@PostMapping
	public Course addCourse(@RequestBody CourseRequestDto c){
		System.out.println("In Course Controller"+c);
		Course msg=cs.addCourse(c);
		System.out.println(msg);
		
		return msg;
		
	}
}
