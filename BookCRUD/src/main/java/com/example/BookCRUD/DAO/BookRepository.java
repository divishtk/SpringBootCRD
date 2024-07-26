package com.example.BookCRUD.DAO;

import org.springframework.data.repository.CrudRepository;

import com.example.BookCRUD.model.Book;

public interface BookRepository extends CrudRepository<Book, Integer>{

	public Book findBookById(int id);
}
