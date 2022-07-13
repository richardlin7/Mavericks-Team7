package com.bookstore.main.model;

public class Admin {
	private int admin_id;
	private String first_name;
	private String last_name;
	private String phone;
	private String username;
	private String password;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(int admin_id, String first_name, String last_name, String phone, String username, String password) {
		super();
		this.admin_id = admin_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.phone = phone;
		this.username = username;
		this.password = password;
	}
	
	public Admin(int admin_id, String first_name, String last_name) {
		// TODO Auto-generated constructor stub
		this.admin_id = admin_id;
		this.first_name = first_name;
		this.last_name = last_name;
	}

	public int getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(int admin_id) {
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

	@Override
	public String toString() {
		return "Admin [admin_id=" + admin_id + ", first_name=" + first_name + ", last_name=" + last_name + ", phone="
				+ phone + ", username=" + username + ", password=" + password + "]";
	}

}
