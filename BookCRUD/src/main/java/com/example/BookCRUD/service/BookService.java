package com.example.BookCRUD.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.BookCRUD.DAO.BookRepository;
import com.example.BookCRUD.model.Book;

@Service
public class BookService {

	//private static List<Book> list = new ArrayList<>();
	
	@Autowired
	private BookRepository bookRepository;

	/*static {

		list.add(new Book(1, "MERN", 250));
		list.add(new Book(2, "DSA", 129));
		list.add(new Book(3, "JAVA", 499));

	}*/

	
	/*public List<Books> getAllBooks() {
		return list;
	}*/
	
	
	
	public List<Book> getAllBooks() {
		List<Book> list = (List<Book>) this.bookRepository.findAll();
		return list;
	}
	
	
	

	public Book getBookById(int id) {
		Book book=null;
		try {
			
			//book= list.stream().filter(b -> b.getId() == id).findFirst().get();
			
		book = this.bookRepository.findBookById(id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}

	/*
	 * 
	 * for(Book b:list) {
	 * 
	 * if(b.getId() == id) { return b; } } return null;
	 */

	
	public Book addBooks(Book b) {

		//list.add(b);
		
		Book book = this.bookRepository.save(b);
		return book;

	}
	
	
	

	public void deleteBook(int id) {
		//list = list.stream().filter(book -> book.getId() != id).collect(Collectors.toList());
		
		this.bookRepository.deleteById(id);

		/*
		 * for (int i = 0; i < list.size(); i++) { if (list.get(i).getId() == id) {
		 * list.remove(i); return; } }
		 */

		/*
		 * Iterator<Book> iterator = list.iterator(); while (iterator.hasNext()) { Book
		 * b = iterator.next(); if (b.getId() == id) { iterator.remove(); return; } }
		 */
	}

	public Book updateBook(Book book, int id)
	{

	/*	list = list.stream().map(b -> {
			if (b.getId() == id) {
				b.setName(book.getName());
				b.setCost(book.getCost());
			}
			return b;
		}).collect(Collectors.toList());

		return book;
	}*/
		book.setId(id);
		return this.bookRepository.save(book);

}
}