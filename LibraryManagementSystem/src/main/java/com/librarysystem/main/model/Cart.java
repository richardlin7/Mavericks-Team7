package com.librarysystem.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@OneToOne
	private Book book;
	@OneToOne
	private UserInfo userInfo;
	
	private Integer bookCopies;

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(Long id, Book book, UserInfo userInfo, Integer bookCopies) {
		super();
		this.id = id;
		this.book = book;
		this.userInfo = userInfo;
		this.bookCopies = bookCopies;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public Integer getBookCopies() {
		return bookCopies;
	}

	public void setBookCopies(Integer bookCopies) {
		this.bookCopies = bookCopies;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", book=" + book + ", userInfo=" + userInfo + ", bookCopies=" + bookCopies + "]";
	}
	
	

}
