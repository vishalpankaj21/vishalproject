package com.project.vishal.library_sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.vishal.library_sample.model.Library;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Integer>{

}
