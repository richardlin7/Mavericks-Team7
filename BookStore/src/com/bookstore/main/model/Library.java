package com.bookstore.main.model;

public class Library {

	private int library_id;
	private String library_name;
	private String phone;
	public Library() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Library(int library_id, String library_name, String phone) {
		super();
		this.library_id = library_id;
		this.library_name = library_name;
		this.phone = phone;
	}
	public int getLibrary_id() {
		return library_id;
	}
	public void setLibrary_id(int library_id) {
		this.library_id = library_id;
	}
	public String getLibrary_name() {
		return library_name;
	}
	public void setLibrary_name(String library_name) {
		this.library_name = library_name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Library [library_id=" + library_id + ", library_name=" + library_name + ", phone=" + phone + "]";
	}
	
	
	

}
