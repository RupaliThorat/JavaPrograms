
package com.app.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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

public class CourseResponseDto {
	
	private String ctitle;
	private int intake;
//	public String getCtitle() {
//		return ctitle;
//	}
//	public void setCtitle(String ctitle) {
//		this.ctitle = ctitle;
//	}
//	public int getIntake() {
//		return intake;
//	}
//	public void setIntake(int intake) {
//		this.intake = intake;
//	}
//	public CourseResponseDto() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	public CourseResponseDto(String ctitle, int intake) {
//		super();
//		this.ctitle = ctitle;
//		this.intake = intake;
//	}
}
