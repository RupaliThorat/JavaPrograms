package com.app.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.CourseRequestDto;
import com.app.dto.CourseResponseDto;
import com.app.entities.Course;
import com.app.repositories.CourseRepo;
@Service
@Transactional

public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepo cr;
	@Autowired
	private ModelMapper mapper;
	@Override
	public List<CourseResponseDto> getAllCourses() {
		
		return cr.findAll().stream().map(e -> mapper.map(e, CourseResponseDto.class)) // Entity --> DTO
				.collect(Collectors.toList());
	}

	@Override
	public Course addCourse(CourseRequestDto cdto) {
		Course c=mapper.map(cdto, Course.class);
		//cr.save(c);
		return cr.save(c);
	}
	public Optional<Course> getCourseById(Long cid){
		return cr.findById(cid);
	}

	@Override
	public String updateCourse(Course c) {
		
		cr.save(c);
		return "Updated";
		
	}

	@Override
	public String deleteCourse(Long cid) {
		cr.deleteById(cid);
		return "Course Deleted" ;
	}

}
