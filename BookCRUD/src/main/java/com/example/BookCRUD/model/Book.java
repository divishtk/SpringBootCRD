package com.example.BookCRUD.model;



import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="books_table")
public class Book {
	

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="book_id")
		private int id;
		
		private String name;
		
		@OneToOne(cascade = CascadeType.ALL)
		@JsonManagedReference
		private Author author;
		
		private int cost;
		
		
		
		//for SB JPA
		 public Book() {
		    }
		
		
		
		public Book(int id, String name, Author author, int cost) {
			super();
			this.id = id;
			this.name = name;
			this.author = author;
			this.cost = cost;
		}

		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		public Author getAuthor() {
			return author;
		}

		public void setAuthor(Author author) {
			this.author = author;
		}
		
		public int getCost() {
			return cost;
		}
		public void setCost(int cost) {
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Book [id=" + id + ", name=" + name + ", author=" + author + ", cost=" + cost + "]";
		}
		
		
	
		
		
}
