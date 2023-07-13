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

	private Course course;
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public StudentRequestDto(String fname, String lname, String mobileNo, String email, Gender gender, Course course) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.mobileNo = mobileNo;
		this.email = email;
		this.gender = gender;
		this.course = course;
	}
	public StudentRequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}
}
