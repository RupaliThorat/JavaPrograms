package com.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Author;
@Repository
public interface AuthorRepo extends JpaRepository<Author, Long> {

	List<Author> findByCourseId(Long cid);

}
