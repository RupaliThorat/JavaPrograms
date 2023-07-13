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

import com.app.dto.CourseRequestDto;
import com.app.dto.StudentRequestDto;
import com.app.dto.StudentResponseDto;
import com.app.entities.Course;
import com.app.entities.Student;
import com.app.services.CourseService;
import com.app.services.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService ss;
	
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping("/{cid}")
	public List<Student> getAllStudentsCourseWise(@PathVariable Long cid){
		System.out.println(cid);
		return ss.getAllStudentCourseWise(cid);
	}
	@GetMapping
	public List<StudentResponseDto> getAllStudents(){
		return ss.getAllStudents();
	}
	@PostMapping
	public ResponseEntity<Student> addStudent(@RequestBody StudentRequestDto s){
		System.out.println(s);
		//if(s.getCourse()!=null) {
			System.out.println("IN with course");
		//}
		//System.out.println("Without Course");
		return new ResponseEntity<Student>(ss.addStudent(s), HttpStatus.CREATED);
		
		
	}
	@PutMapping("/{sid},{cid}")
	public String assignCourse(@PathVariable Long sid, @PathVariable Long cid){
		System.out.println("In assign"+sid.getClass());
		return ss.assignCourse(sid, cid);
	}
	@PutMapping("/{sid}")
	public String updateStudent(@PathVariable Long sid, StudentRequestDto s){
		System.out.println("In Student update"+s);
		Student stud=ss.getStudentById(sid).get();
		s.setFname(stud.getFname());
		s.setLname(stud.getLname());
		s.setEmail(stud.getEmail());
		s.setMobileNo(stud.getMobileNo());
		s.setCourse(stud.getCourse());
		s.setGender(stud.getGender());
		return ss.updateStudent(stud);
		
	}
	@PostMapping("/withcourse")
			public Student addStudentWithCourse(@RequestBody StudentRequestDto s) {
				System.out.println("add course with student"+s.getCourse());
				return ss.addStudentAndCourse(s);
			}

	@DeleteMapping(value="/{sid}")
	public String deleteStudent(@PathVariable Long sid) {
		System.out.println("delete student");
		return ss.deleteStudent(sid);
	}
	
}
