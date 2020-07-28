package com.project.vishal.library_sample.service;

import java.util.List;

import com.project.vishal.library_sample.exception.ResourceNotFoundException;
import com.project.vishal.library_sample.model.Book;
import com.project.vishal.library_sample.model.Library;


public interface LibraryService {
	
   public List<Library> getAllLibraries();
	
	public Book getBook(Integer id) throws ResourceNotFoundException;
	
	public void addBook(Book book);
	
	public void addLibrary(Library library);
	
	public List<Book> getAllBooks();
	
	public List<Book> getAllBooksOfLibrary(Integer libraryId) throws ResourceNotFoundException;
	
	public Book updateBook(Integer id, Book book) throws ResourceNotFoundException;
	
	public void deleteBook(Integer id) throws ResourceNotFoundException;
	
	
 

}
