package com.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.app.dto.StudentRequestDto;
import com.app.dto.StudentResponseDto;
import com.app.entities.Student;

public interface StudentService {

	Student addStudent(StudentRequestDto studdto);

	List<Student>  getAllStudentCourseWise(Long cid);

	List<StudentResponseDto> getAllStudents();
	Student addStudentAndCourse(StudentRequestDto studdto);

	String assignCourse(Long sid, Long cid);

	Optional<Student> getStudentById(Long sid);

	String updateStudent(Student stud);
}
