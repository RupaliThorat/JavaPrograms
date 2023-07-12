
package com.app.entities;

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
@Entity
public class Course extends BaseEntity {
	
	private String ctitle;
	private int intake;
	@OneToMany(mappedBy="course", fetch = FetchType.EAGER)
	private List< Student> studList=new ArrayList<>() ;
	public void addStudent(Student s) {
		studList.add(s);
	}
}
