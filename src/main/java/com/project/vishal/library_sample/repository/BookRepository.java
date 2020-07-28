package com.project.vishal.library_sample.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.vishal.library_sample.model.Book;


@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
	
	Optional<List<Book>> findByLibraryId(Integer libraryId);

}
