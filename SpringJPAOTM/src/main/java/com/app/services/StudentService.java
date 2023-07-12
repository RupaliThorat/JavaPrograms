package com.app.services;

import java.util.List;

import com.app.dto.StudentRequestDto;
import com.app.dto.StudentResponseDto;
import com.app.entities.Student;

public interface StudentService {

	String addStudentCourseWise(Student studdto);
	String addStudent(StudentRequestDto studdto);

	List<Student>  getAllStudentCourseWise(Long cid);

	List<StudentResponseDto> getAllStudents();

}
