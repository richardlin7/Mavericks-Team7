package com.springboot.bookstore.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long user_id;
	
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
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Long user_id, String first_name, String last_name, String phone, String username, String password) {
		super();
		this.user_id = user_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.phone = phone;
		this.username = username;
		this.password = password;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
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
	@Override
	public int hashCode() {
		return Objects.hash(first_name, last_name, password, phone, user_id, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(first_name, other.first_name) && Objects.equals(last_name, other.last_name)
				&& Objects.equals(password, other.password) && Objects.equals(phone, other.phone)
				&& Objects.equals(user_id, other.user_id) && Objects.equals(username, other.username);
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", first_name=" + first_name + ", last_name=" + last_name + ", phone="
				+ phone + ", username=" + username + ", password=" + password + "]";
	}
	
	

}
