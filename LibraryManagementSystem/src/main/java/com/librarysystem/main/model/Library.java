package com.librarysystem.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Library {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String libraryName;
	@Column(nullable = false)
	private String phone;
	public Library() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Library(Long id, String libraryName, String phone) {
		super();
		this.id = id;
		this.libraryName = libraryName;
		this.phone = phone;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLibraryName() {
		return libraryName;
	}
	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Library [id=" + id + ", libraryName=" + libraryName + ", phone=" + phone + "]";
	}
	
	

}
