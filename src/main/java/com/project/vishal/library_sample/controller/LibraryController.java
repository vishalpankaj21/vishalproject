package com.project.vishal.library_sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.vishal.library_sample.exception.ResourceNotFoundException;
import com.project.vishal.library_sample.model.Book;
import com.project.vishal.library_sample.model.Library;
import com.project.vishal.library_sample.service.LibraryService;

@RestController
@CrossOrigin()
public class LibraryController {

	@Autowired
	LibraryService library;

	@GetMapping("/test")
	public String testApi() {
		return "Hello from Library Controller";
	}

	@GetMapping("/libraries")
	public List<Library> getAllLibraries() {
		return library.getAllLibraries();
	}

	@GetMapping("/books/library/{id}")
	public ResponseEntity getAllBooksOfLibrary(@PathVariable Integer id) throws Exception {
		List<Book> books = null;
		try {
			books = library.getAllBooksOfLibrary(id);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		return ResponseEntity.ok().body(books);
	}

	@GetMapping("/books")
	public List<Book> getAllBooks() {
		return library.getAllBooks();
	}

	@GetMapping("/books/{id}")
	public ResponseEntity getBook(@PathVariable(value = "id") Integer bookId) throws Exception {
		Book book = null;
		try {
			book = library.getBook(bookId);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		return ResponseEntity.ok().body(book);
	}
	
	@PostMapping("/addLibrary")
	public void addLibrary(@RequestBody Library lib) {
		library.addLibrary(lib);
	}

	@PostMapping("/books")
	public void addBook(@RequestBody Book book) {
		library.addBook(book);
	}

	@PutMapping("/books/{id}")
	public ResponseEntity updateBook(@PathVariable(value = "id") Integer bookId, @RequestBody Book book)
			throws Exception {
		Book updatedBook = null;
		try {
			updatedBook = library.updateBook(bookId, book);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		return ResponseEntity.ok().body(updatedBook);
	}

	@DeleteMapping("/books/{id}")
	public String deleteBook(@PathVariable(value = "id") Integer bookId) throws Exception {
		String response = null;
		try {
			library.deleteBook(bookId);
		} catch (ResourceNotFoundException e) {
			return e.getMessage();
		}
		response = "Deleted successfully";
		return response;
	}

}
