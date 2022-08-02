package com.springboot.bookstore.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long admin_id;
	
	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String lastName;
	@Column(nullable = false)
	private String phone;
	
	@OneToOne
	private LoginCredentials loginCredentials;
	
	@Column(name = "registered_date")
	private LocalDate date;
	
	@OneToOne
	private Location location;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(Long admin_id, String firstName, String lastName, String phone, LoginCredentials loginCredentials,
			LocalDate date, Location location) {
		super();
		this.admin_id = admin_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.loginCredentials = loginCredentials;
		this.date = date;
		this.location = location;
	}

	public Long getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(Long admin_id) {
		this.admin_id = admin_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public LoginCredentials getLoginCredentials() {
		return loginCredentials;
	}

	public void setLoginCredentials(LoginCredentials loginCredentials) {
		this.loginCredentials = loginCredentials;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Admin [admin_id=" + admin_id + ", firstName=" + firstName + ", lastName=" + lastName + ", phone="
				+ phone + ", loginCredentials=" + loginCredentials + ", date=" + date + ", location=" + location + "]";
	}

	
}
