package com.librarysystem.main.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class BorrowerRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private LocalDate issueDate;
	@Column(nullable = false)
	private LocalDate dueDate;
	
	@OneToOne
	private UserInfo userInfo;
	@OneToOne
	private Book book;
	@Column(nullable = false)
	private String status;
	public BorrowerRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BorrowerRecord(Long id, LocalDate issueDate, LocalDate dueDate, UserInfo userInfo, Book book,
			String status) {
		super();
		this.id = id;
		this.issueDate = issueDate;
		this.dueDate = dueDate;
		this.userInfo = userInfo;
		this.book = book;
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "BorrowerRecord [id=" + id + ", issueDate=" + issueDate + ", dueDate=" + dueDate + ", userInfo="
				+ userInfo + ", book=" + book + ", status=" + status + "]";
	}
	
	

}
