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
	
}
