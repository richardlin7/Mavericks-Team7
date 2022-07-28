package com.springboot.bookstore.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.springboot.bookstore.enums.Role;

@Entity
@Table(name = "users")
public class AllUserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	
	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String lastName;
	@Column(nullable = false)
	private String phone;
	@Column(nullable = false)
	private String username;
	@Column(nullable = false)
	private String password;
	@Column(name = "registered_date")
	private LocalDate date;
	
	@Enumerated
	private Role role;
	
	@OneToOne
	private Location location;

	public AllUserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AllUserDetails(Long userId, String firstName, String lastName, String phone, String username, String password,
			LocalDate date, Role role, Location location) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.username = username;
		this.password = password;
		this.date = date;
		this.role = role;
		this.location = location;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", phone="
				+ phone + ", username=" + username + ", password=" + password + ", date=" + date + ", role=" + role
				+ ", location=" + location + "]";
	}

	

	

}
