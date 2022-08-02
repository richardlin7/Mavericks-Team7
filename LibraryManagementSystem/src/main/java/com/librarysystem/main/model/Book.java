package com.librarysystem.main.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.librarysystem.main.emuns.BookStatus;
@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String bookName;
	@Enumerated
	private BookStatus bookStatus;
	@Column(nullable = false)
	private Integer bookCopies;
	@Column(nullable = false)
	private String bookDescription;
	@Column(nullable = false)
	private LocalDate listedDate;
	@OneToOne
	private Author author;
	@OneToOne
	private Category category;
	@OneToOne
	private Library library;
	@OneToOne
	private UserInfo userInfo;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(Long id, String bookName, BookStatus bookStatus, Integer bookCopies, String bookDescription,
			LocalDate listedDate, Author author, Category category, Library library, UserInfo userInfo) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.bookStatus = bookStatus;
		this.bookCopies = bookCopies;
		this.bookDescription = bookDescription;
		this.listedDate = listedDate;
		this.author = author;
		this.category = category;
		this.library = library;
		this.userInfo = userInfo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public BookStatus getBookStatus() {
		return bookStatus;
	}
	public void setBookStatus(BookStatus bookStatus) {
		this.bookStatus = bookStatus;
	}
	public Integer getBookCopies() {
		return bookCopies;
	}
	public void setBookCopies(Integer bookCopies) {
		this.bookCopies = bookCopies;
	}
	public String getBookDescription() {
		return bookDescription;
	}
	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}
	public LocalDate getListedDate() {
		return listedDate;
	}
	public void setListedDate(LocalDate listedDate) {
		this.listedDate = listedDate;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Library getLibrary() {
		return library;
	}
	public void setLibrary(Library library) {
		this.library = library;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", bookStatus=" + bookStatus + ", bookCopies=" + bookCopies
				+ ", bookDescription=" + bookDescription + ", listedDate=" + listedDate + ", author=" + author
				+ ", category=" + category + ", library=" + library + ", userInfo=" + userInfo + "]";
	}
	
	

}
