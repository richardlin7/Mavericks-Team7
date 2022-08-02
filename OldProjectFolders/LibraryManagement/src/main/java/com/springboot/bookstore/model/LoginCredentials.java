package com.springboot.bookstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.springboot.bookstore.enums.Roles;

@Entity
@Table(name="login")
public class LoginCredentials {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String username;
	@Column(nullable = false)
	private String password;
	//(EnumType.STRING)
	@Enumerated
	private Roles roles;

	public LoginCredentials() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginCredentials(Long id, String username, String password, Roles roles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "LoginCredentials [id=" + id + ", username=" + username + ", password=" + password + ", roles=" + roles
				+ "]";
	}
	
	

}
