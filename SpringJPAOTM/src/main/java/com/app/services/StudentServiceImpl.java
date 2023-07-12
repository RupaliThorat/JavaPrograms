package com.app.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.CourseRequestDto;
import com.app.dto.StudentRequestDto;
import com.app.dto.StudentResponseDto;
import com.app.entities.Course;
import com.app.entities.Student;
import com.app.repositories.StudentRepo;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepo sr;
	@Autowired
	private CourseService cs;
	@Autowired
	private ModelMapper mapper;

//	@Override
//	public String addStudentCourseWise(Student studdto) {
//		
//		Student s1=sr.save(studdto);
//		
//		return "Inserted Successfully";
//	}
	// add student with without course
	@Override
	public Student addStudent(StudentRequestDto studdto) {
		System.out.println("In Service Student - ");
		Student s1 = mapper.map(studdto, Student.class);

		return sr.save(s1);
	}

	@Override
	public List<Student> getAllStudentCourseWise(Long cid) {

		return sr.findByCourseId(cid);
	}

	public List<StudentResponseDto> getAllStudents() {
		return sr.findAll().stream().map(e -> mapper.map(e, StudentResponseDto.class)) // Entity --> DTO
				.collect(Collectors.toList());

	}

	@Override
	public Student addStudentAndCourse(StudentRequestDto studdto) {
		Student s1 = mapper.map(studdto, Student.class);
		Course c=cs.addCourse(mapper.map(s1.getCourse(),CourseRequestDto.class));
		c.addStudent(s1);
		s1.setCourse(c);
		return sr.save(s1);

	}

	@Override
	public String assignCourse(Long sid, Long cid) {
		Optional<Student> s = sr.findById(sid);
		Optional<Course> c = cs.getCourseById(cid);
		Student s1 = s.get();
		s1.setCourse(c.get());
		sr.save(s1);
		return "Asigned Succesfully";

	}

	@Override
	public Optional<Student> getStudentById(Long sid) {
		return sr.findById(sid);
	}

	@Override
	public String updateStudent(Student stud) {
		sr.save(stud);
		return "Student Updated";
	}

}
