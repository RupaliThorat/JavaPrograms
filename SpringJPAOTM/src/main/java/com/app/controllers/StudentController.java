package com.app.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	private CourseService cs;
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
	public String addStudentCourseWise(@RequestBody StudentRequestDto s){
		System.out.println(s);
		String msg=null;
		//ss.addStudent(s);
		if(s.getCourse().getCtitle()!=null) {
			System.out.println("IN");
				Student stud=mapper.map(s, Student.class);
			Course c= s.getCourse();
				
			c.addStudent(stud);
			c=cs.addCourse(mapper.map(c, CourseRequestDto.class));
			System.out.println("saved course "+c);
			
			//s.setCourse(c);
			System.out.println("IN"+stud);
		}
		msg=ss.addStudent(s);
		System.out.println(msg);
		
		return msg;
		
	}
}
