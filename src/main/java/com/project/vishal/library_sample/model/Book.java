package com.project.vishal.library_sample.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Book")
public class Book {
	
	@Id
	private Integer id;
	
    private String title;
    
    private String author;
    
    private Integer libraryId;
    
    public Book() {
    	
    }
    
	public Book(Integer id, String title, String author, Integer libraryId) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.libraryId = libraryId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getLibraryId() {
		return libraryId;
	}

	public void setLibraryId(Integer libraryId) {
		this.libraryId = libraryId;
	}

}
