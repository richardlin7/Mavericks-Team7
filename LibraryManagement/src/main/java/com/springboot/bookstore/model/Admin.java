package com.springboot.bookstore.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long admin_id;
	
	@Column(nullable = false)
	private String first_name;
	@Column(nullable = false)
	private String last_name;
	@Column(nullable = false)
	private String phone;
	@Column(nullable = false)
	private String username;
	@Column(nullable = false)
	private String password;
	
	@Column(name = "registered_date")
	private LocalDate date;
	
	@OneToOne
	private Location location;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(Long admin_id, String first_name, String last_name, String phone, String username, String password,
			LocalDate date, Location location) {
		super();
		this.admin_id = admin_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.phone = phone;
		this.username = username;
		this.password = password;
		this.date = date;
		this.location = location;
	}

	public Long getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(Long admin_id) {
		this.admin_id = admin_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		return "Admin [admin_id=" + admin_id + ", first_name=" + first_name + ", last_name=" + last_name + ", phone="
				+ phone + ", username=" + username + ", password=" + password + ", date=" + date + ", location="
				+ location + "]";
	}

	

}
