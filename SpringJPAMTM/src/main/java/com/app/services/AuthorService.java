package com.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.app.dto.AuthorRequestDto;
import com.app.dto.AuthorResponseDto;
import com.app.entities.Author;

public interface AuthorService {

	Author addStudent(AuthorRequestDto studdto);

	List<Author>  getAllStudentCourseWise(Long cid);

	List<AuthorResponseDto> getAllStudents();
	Author addStudentAndCourse(AuthorRequestDto studdto);

	String assignCourse(Long sid, Long cid);

	Optional<Author> getStudentById(Long sid);

	String updateStudent(Author stud);

	String deleteStudent(Long sid);

}
