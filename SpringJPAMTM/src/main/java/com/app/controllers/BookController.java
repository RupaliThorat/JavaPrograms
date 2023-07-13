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

import com.app.dto.BookRequestDto;
import com.app.dto.BookResponseDto;
import com.app.entities.Book;
import com.app.services.BookService;

@RestController
@RequestMapping("/course")
public class BookController {

	@Autowired
	private BookService cs;
	
	@GetMapping
	public List<BookResponseDto> getAllCourses(){
		return cs.getAllCourses();
	}
	@PostMapping("/add/")
	public ResponseEntity<Book> addCourse(@RequestBody BookRequestDto c){
		System.out.println("In Course Controller"+c);
		return new ResponseEntity<Book>(cs.addCourse(c), HttpStatus.CREATED);
		
	}
	@PutMapping("update/{cid}")
	public String updateCourse(@PathVariable Long cid, BookRequestDto c){
		System.out.println("In Course update"+c);
		Book crs=cs.getCourseById(cid).get();
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
