package com.bookstore.main.model;

public class Book {
	private int book_id;
	private String book_name;
	private int book_copies;
	private double book_cost;
	private String book_status;
	private String listed_date;
	private Author author;
	private Categories category;
	private Library library;
	private Admin admin;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(int book_id, String book_name, int book_copies, double book_cost, String book_status,
			String listed_date, Author author, Categories category, Library library, Admin admin) {
		super();
		this.book_id = book_id;
		this.book_name = book_name;
		this.book_copies = book_copies;
		this.book_cost = book_cost;
		this.book_status = book_status;
		this.listed_date = listed_date;
		this.author = author;
		this.category = category;
		this.library = library;
		this.admin = admin;
	}
	public Book(String book_name, int book_copies, String book_status, String listed_date) {
		this.book_name = book_name;
		this.book_copies = book_copies;
		this.book_status = book_status;
		this.listed_date = listed_date;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public int getBook_copies() {
		return book_copies;
	}
	public void setBook_copies(int book_copies) {
		this.book_copies = book_copies;
	}
	public double getBook_cost() {
		return book_cost;
	}
	public void setBook_cost(double book_cost) {
		this.book_cost = book_cost;
	}
	public String getBook_status() {
		return book_status;
	}
	public void setBook_status(String book_status) {
		this.book_status = book_status;
	}
	public String getListed_date() {
		return listed_date;
	}
	public void setListed_date(String listed_date) {
		this.listed_date = listed_date;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public Categories getCategory() {
		return category;
	}
	public void setCategory(Categories category) {
		this.category = category;
	}
	public Library getLibrary() {
		return library;
	}
	public void setLibrary(Library library) {
		this.library = library;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	@Override
	public String toString() {
		return "Book [book_id=" + book_id + ", book_name=" + book_name + ", book_copies=" + book_copies + ", book_cost="
				+ book_cost + ", book_status=" + book_status + ", listed_date=" + listed_date + ", author=" + author
				+ ", category=" + category + ", library=" + library + ", admin=" + admin + "]";
	}
	
}
