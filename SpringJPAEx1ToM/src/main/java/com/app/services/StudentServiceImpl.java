package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Student;
import com.app.repositories.StudentRepo;



@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepo sr;

	
	@Override
	public String addStudentCourseWise(Student studdto) {
		
		Student s1=sr.save(studdto);
		
		return "Inserted Successfully";
	}

	@Override
	public List<Student> getAllStudentCourseWise(Long cid) {
		
		return sr.findByCourseId(cid);
	}

}
