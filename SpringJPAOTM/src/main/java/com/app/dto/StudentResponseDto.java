package com.app.dto;



import com.app.entities.Course;
import com.app.entities.Gender;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentResponseDto  {
	
	private String fname;
	private String lname;
	private String mobileNo;
	private String email;
	private Gender gender;
	
	private Course course;
}
