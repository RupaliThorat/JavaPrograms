package com.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Student;
@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

	List<Student> findByCourseId(Long cid);

}
