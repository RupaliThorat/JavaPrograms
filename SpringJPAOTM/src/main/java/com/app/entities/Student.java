package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
@Entity
public class Student extends BaseEntity {
	
	private String fname;
	private String lname;
	@Column(name="mobile_no", length=10)
	private String mobileNo;
	private String email;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="course_id")
	private Course course;
//	public String getFname() {
//		return fname;
//	}
//	public void setFname(String fname) {
//		this.fname = fname;
//	}
//	public String getLname() {
//		return lname;
//	}
//	public void setLname(String lname) {
//		this.lname = lname;
//	}
//	public String getMobileNo() {
//		return mobileNo;
//	}
//	public void setMobileNo(String mobileNo) {
//		this.mobileNo = mobileNo;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	public Gender getGender() {
//		return gender;
//	}
//	public void setGender(Gender gender) {
//		this.gender = gender;
//	}
//	public Course getCourse() {
//		return course;
//	}
//	public void setCourse(Course course) {
//		this.course = course;
//	}
//	public Student(String fname, String lname, String mobileNo, String email, Gender gender, Course course) {
//		super();
//		this.fname = fname;
//		this.lname = lname;
//		this.mobileNo = mobileNo;
//		this.email = email;
//		this.gender = gender;
//		this.course = course;
//	}
//	public Student() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
	
}
