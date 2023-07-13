package com.app.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.BookRequestDto;
import com.app.dto.BookResponseDto;
import com.app.entities.Book;
import com.app.repositories.BookRepo;
@Service
@Transactional

public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepo cr;
	@Autowired
	private ModelMapper mapper;
	@Override
	public List<BookResponseDto> getAllCourses() {
		
		return cr.findAll().stream().map(e -> mapper.map(e, BookResponseDto.class)) // Entity --> DTO
				.collect(Collectors.toList());
	}

	@Override
	public Book addCourse(BookRequestDto cdto) {
		Book c=mapper.map(cdto, Book.class);
		//cr.save(c);
		return cr.save(c);
	}
	public Optional<Book> getCourseById(Long cid){
		return cr.findById(cid);
	}

	@Override
	public String updateCourse(Book c) {
		
		cr.save(c);
		return "Updated";
		
	}

	@Override
	public String deleteCourse(Long cid) {
		cr.deleteById(cid);
		return "Course Deleted" ;
	}

}
