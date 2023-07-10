package com.app.services;

import java.util.List;
import java.util.Optional;

import com.app.dto.StudentRequestDto;
import com.app.entities.Student;

public interface StudentService {

	String addStudentCourseWise(Student studdto);

	List<Student>  getAllStudentCourseWise(Long cid);

}
