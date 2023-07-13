package com.app.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public ResponseEntity<Course> addCourse(@RequestBody CourseRequestDto c){
		System.out.println("In Course Controller"+c);
		return new ResponseEntity<Course>(cs.addCourse(c), HttpStatus.CREATED);
		
	}
	@PutMapping("/{cid}")
	public String updateCourse(@PathVariable Long cid, CourseRequestDto c){
		System.out.println("In Course update"+c);
		Course crs=cs.getCourseById(cid).get();
		crs.setCtitle(c.getCtitle());
		crs.setIntake(c.getIntake());
		return cs.updateCourse(crs);
		
	}

	@DeleteMapping(value="/{cid}")
	public String deleteCourse(@PathVariable Long cid) {
		System.out.println("delete Course");
		return cs.deleteCourse(cid);
	}
	
}
