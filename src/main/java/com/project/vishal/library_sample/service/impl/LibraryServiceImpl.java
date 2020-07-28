package com.project.vishal.library_sample.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.vishal.library_sample.exception.ResourceNotFoundException;
import com.project.vishal.library_sample.model.Book;
import com.project.vishal.library_sample.model.Library;
import com.project.vishal.library_sample.repository.BookRepository;
import com.project.vishal.library_sample.repository.LibraryRepository;
import com.project.vishal.library_sample.service.LibraryService;


@Service
public class LibraryServiceImpl implements LibraryService {
	
	@Autowired
	BookRepository bookRepo;
	
	@Autowired
	LibraryRepository libraryRepository;
	
	@Override
	public Book getBook(Integer id) throws ResourceNotFoundException {
        return bookRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("No book found for this id :: " + id));
    }

	@Override
    public void addBook(Book book) {
    	bookRepo.save(book);
    }
	
	@Override
	public Book updateBook(Integer id, Book book) throws ResourceNotFoundException {
		Book bookEntity = bookRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("No book found for this id :: " + id));
		if((book.getId()!= null) && (bookEntity.getId().intValue() != book.getId().intValue())) {
			throw new ResourceNotFoundException("Id given in url " + bookEntity.getId().intValue() + " does not match with that in request body id value of: " + book.getId().intValue());
		}
		bookEntity.setTitle(book.getTitle());
		bookEntity.setAuthor(book.getAuthor());
		bookEntity.setLibraryId(book.getLibraryId());
	    return bookRepo.save(bookEntity);
    }
	
	@Override
	public List<Book> getAllBooksOfLibrary(Integer libraryId) throws ResourceNotFoundException {
        List<Book> books = new ArrayList<>();
        bookRepo.findByLibraryId(libraryId).orElseThrow(() -> new ResourceNotFoundException("No book found for this library id :: " + libraryId)).forEach(books::add);
        return books;
    }
	
	@Override
	public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        bookRepo.findAll().forEach(books::add);
        return books;
    }

	@Override
    public void deleteBook(Integer id) throws ResourceNotFoundException {
		bookRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("No book found for this id :: " + id));
    	bookRepo.deleteById(id);
    }

	@Override
	public List<Library> getAllLibraries() {
		  List<Library> libraries = new ArrayList<>();
		  libraryRepository.findAll().forEach(libraries::add);
	      return libraries;
	}

	@Override
	public void addLibrary(Library library) {
		libraryRepository.save(library);
		
	}

}
