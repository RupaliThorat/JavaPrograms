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

import com.app.dto.BookRequestDto;
import com.app.dto.AuthorRequestDto;
import com.app.dto.AuthorResponseDto;
import com.app.entities.Book;
import com.app.entities.Author;
import com.app.repositories.AuthorRepo;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {
	@Autowired
	private AuthorRepo sr;
	@Autowired
	private BookService cs;
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
	public Author addStudent(AuthorRequestDto studdto) {
		System.out.println("In Service Student - ");
		Author s1 = mapper.map(studdto, Author.class);
		return sr.save(s1);
	}

	
	@Override
	public List<Author> getAllStudentCourseWise(Long cid) {

		return sr.findByCourseId(cid);
	}

	public List<AuthorResponseDto> getAllStudents() {
		return sr.findAll().stream().map(e -> mapper.map(e, AuthorResponseDto.class)) // Entity --> DTO
				.collect(Collectors.toList());

	}

	@Override
	public Author addStudentAndCourse(AuthorRequestDto studdto) {
		Author s1 = mapper.map(studdto, Author.class);
		Book c=cs.addCourse(mapper.map(s1.getCourse(),BookRequestDto.class));
		c.addStudent(s1);
		s1.setCourse(c);
		return sr.save(s1);

	}

	@Override
	public String assignCourse(Long sid, Long cid) {
		Optional<Author> s = sr.findById(sid);
		Optional<Book> c = cs.getCourseById(cid);
		Author s1 = s.get();
		s1.setCourse(c.get());
		sr.save(s1);
		return "Asigned Succesfully";

	}

	@Override
	public Optional<Author> getStudentById(Long sid) {
		return sr.findById(sid);
	}

	@Override
	public String updateStudent(Author stud) {
		sr.save(stud);
		return "Student Updated";
	}

	@Override
	public String deleteStudent(Long sid) {
		Author s=sr.findById(sid).get();
		s.getCourse().removeStudent(s);
		sr.delete(s);
		return "Student Deleted" ;
	}

}
