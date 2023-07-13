package com.app.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
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
import com.app.dto.AuthorRequestDto;
import com.app.dto.AuthorResponseDto;
import com.app.entities.Book;
import com.app.entities.Author;
import com.app.services.BookService;
import com.app.services.AuthorService;

@RestController
@RequestMapping("/students")
public class AuthorController {

	@Autowired
	private AuthorService ss;
	@Autowired
	private BookService cs;
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping("/{cid}")
	public List<Author> getAllStudentsCourseWise(@PathVariable Long cid){
		System.out.println(cid);
		return ss.getAllStudentCourseWise(cid);
	}
	@GetMapping("/getallstud")
	public List<AuthorResponseDto> getAllStudents(){
		return ss.getAllStudents();
	}
	@PostMapping("/add")
	public ResponseEntity<Author> addStudent(@RequestBody AuthorRequestDto s){
		System.out.println(s);
	
		
		//if(s.getCourse()!=null) {
			System.out.println("IN with course");
		
		//}
		//System.out.println("Without Course");
		return new ResponseEntity<Author>(ss.addStudent(s), HttpStatus.CREATED);
		
		
	}
	@PutMapping(value="/assigncourse/{sid},{cid}")
	public String assignCourse(@PathVariable("sid") Long sid, @PathVariable("cid") Long cid){
		System.out.println("In assign"+sid.getClass());
		return ss.assignCourse(sid, cid);
	}
	@PutMapping(value="update/{sid}")
	public String updateStudent(@PathVariable("sid") Long sid, @RequestBody AuthorRequestDto stud){
		System.out.println("In Student update"+stud);
		Author s=ss.getStudentById(sid).get();
		s.setFname(stud.getFname());
		s.setLname(stud.getLname());
		s.setEmail(stud.getEmail());
		s.setMobileNo(stud.getMobileNo());
		s.setCourse(stud.getCourse());
		s.setGender(stud.getGender());
		return ss.updateStudent(s);
		
	}
	@PostMapping("/withcourse")
			public Author addStudentWithCourse(@RequestBody AuthorRequestDto s) {
				System.out.println("add course with student");
				return ss.addStudentAndCourse(s);
			}

	@DeleteMapping(value="/{sid}")
	public String deleteStudent(@PathVariable Long sid) {
		System.out.println("delete student");
		return ss.deleteStudent(sid);
	}
	
}
