package com.app.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.StudentRequestDto;
import com.app.dto.StudentResponseDto;
import com.app.entities.Student;
import com.app.repositories.StudentRepo;



@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepo sr;
	@Autowired
	private ModelMapper mapper;
	
//	@Override
//	public String addStudentCourseWise(Student studdto) {
//		
//		Student s1=sr.save(studdto);
//		
//		return "Inserted Successfully";
//	}
	@Override
	public String addStudent(StudentRequestDto studdto) {
		System.out.println("In Service Student - "+studdto.getCourse());
		Student s1 =mapper.map(studdto, Student.class);
		
		 sr.save(s1);
		
		return "Inserted Successfully";
	}
	@Override
	public List<Student> getAllStudentCourseWise(Long cid) {
		
		return sr.findByCourseId(cid);
	}
	public List<StudentResponseDto> getAllStudents(){
		return sr.findAll().stream().map(e -> mapper.map(e, StudentResponseDto.class)) // Entity --> DTO
		.collect(Collectors.toList());
	
		
	}
	@Override
	public String addStudentCourseWise(Student studdto) {
		// TODO Auto-generated method stub
		return null;
	}

}
