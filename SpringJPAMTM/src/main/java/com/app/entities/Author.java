package com.app.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

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
public class Author  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="author_id")
	Long id;

//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
	private String fname;
	private String lname;
	private String city;
	@ManyToMany(cascade = {
	        CascadeType.ALL
	    })
	@JoinTable(name="book_author",joinColumns=@JoinColumn(name="author_id"),inverseJoinColumns=@JoinColumn(name="book_id")) 

	Set <Book> books=new HashSet<>();
	
	
//	@Column(name="mobile_no", length=10)
//	private String mobileNo;
//	private String email;
//	@Enumerated(EnumType.STRING)
//	private Type gender;
	
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
