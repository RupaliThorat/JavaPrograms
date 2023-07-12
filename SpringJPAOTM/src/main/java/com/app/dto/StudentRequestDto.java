package com.app.dto;



import com.app.entities.Course;
import com.app.entities.Gender;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

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
public class StudentRequestDto  {
	
	private String fname;
	private String lname;
	private String mobileNo;
	private String email;
	private Gender gender;
//	@JsonIgnore
	private Course course;
}
