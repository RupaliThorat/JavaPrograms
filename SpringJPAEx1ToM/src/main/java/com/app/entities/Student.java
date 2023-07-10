package com.app.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
