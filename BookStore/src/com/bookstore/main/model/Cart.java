package com.bookstore.main.model;

public class Cart {
	private int cart_id;
	private User user_id;
	private Book book_id;
	private int book_copies;
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(int cart_id, Book book_id, User user_id, int book_copies) {
		super();
		this.cart_id = cart_id;
		this.book_id = book_id;
		this.user_id = user_id;
		this.book_copies = book_copies;
	}
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public User getUser_id() {
		return user_id;
	}
	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}
	public Book getBook_id() {
		return book_id;
	}
	public void setBook_id(User book_id) {
		this.user_id = book_id;
	}
	public int getBook_copies() {
		return book_copies;
	} 
	public void setBook_copies(int book_copies) {
		this.book_copies = book_copies;
	}
	
	@Override
	public String toString() {
		return "Cart [cart_id=" + cart_id + ", user_id=" + user_id + ", book_id=" + book_id + ", book_copies="
				+ book_copies + "]";
	}
}
