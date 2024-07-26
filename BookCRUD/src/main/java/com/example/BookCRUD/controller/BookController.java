package com.example.BookCRUD.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookCRUD.model.Book;
import com.example.BookCRUD.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	
	/*
	@GetMapping("/Books")
	// @ResponseBody
	private List<Book> getBooks() {

		List<Book> books = bookService.getAllBooks();
		return books;

	}*/
	
	
	
	
	
	
	@GetMapping("/Books")
	// @ResponseBody
	private ResponseEntity<List<Book>> getBooks() {

		List<Book> books = bookService.getAllBooks();
		if(books.size()<=0) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(books);


	}

	
	
	
	/*
	@GetMapping("/Books/{id}")
	private Book getBooksById(@PathVariable("id") int id) {
		System.out.println(id);
		Book book = bookService.getBookById(id);
		return book;

	}*/
	
	
	@GetMapping("/Books/{id}")
	private ResponseEntity<Book> getBooksById(@PathVariable("id") int id) {
		System.out.println(id);
		Book book = bookService.getBookById(id);
		if(book==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));

	}
	
	//24T6MT62024
	
	
	
/*
	@PostMapping("/Books")
	private Book addBooks(@RequestBody Book b) {
		Book book = bookService.addBooks(b);
		return book;

	}
	*/
	
	
	@PostMapping("/Books")
	private ResponseEntity<Book> addBooks(@RequestBody Book b) {
		try {
			System.out.println(b);
		Book book = bookService.addBooks(b);
		//return ResponseEntity.of(Optional.of(book));
		return ResponseEntity.status(HttpStatus.CREATED).body(book);

		}
		
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}
	
	
	
	
	/*@DeleteMapping("/Books/{id}")
	private void deleteBookById(@PathVariable("id") int id) {
		bookService.deleteBook(id);
		
	}*/
	
	
	
	@DeleteMapping("/Books/{id}")
	private ResponseEntity<Void> deleteBookById(@PathVariable("id") int id) {
		try {
			bookService.deleteBook(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	
	
	
	
	
	/*@PutMapping("/Books/{id}")
	private Book updateBookById(@RequestBody Book book,@PathVariable("id") int id) {
		
		bookService.updateBook(book,id);
		
		return book;
	}*/
	
		@PutMapping("/Books/{id}")
		private ResponseEntity<Book> updateBookById(@RequestBody Book book,@PathVariable("id") int id) {
		try {
			bookService.updateBook(book,id);
			return ResponseEntity.of(Optional.of(book));


		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		

}
}
		



