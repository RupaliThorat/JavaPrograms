package com.app.services;

import java.util.List;
import java.util.Optional;

import com.app.dto.BookRequestDto;
import com.app.dto.BookResponseDto;
import com.app.entities.Book;

public interface BookService {
	public List<BookResponseDto> getAllCourses();
	public Book addCourse( BookRequestDto c);
	public Optional<Book> getCourseById(Long cid);
	public String updateCourse(Book crs);
	String deleteCourse(Long cid);
}
