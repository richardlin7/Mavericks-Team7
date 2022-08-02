package com.bookstore.main.model;

public class User {
	private int user_id;
	private String first_name;
	private String last_name;
	private String phone;
	private String username;
	private String password;
	private String userComment;
	private String userReview;
	private double user_balance;

	public User() {
		super();

	}

	public User(int user_id, String first_name, String last_name, String phone, String username, String password,
			String userComment, String userReview, double user_balance) {
		super();
		this.user_id = user_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.phone = phone;
		this.username = username;
		this.password = password;
		this.userComment = userComment;
		this.userReview = userReview;
		this.user_balance = user_balance;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
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

	public String getUserComment() {
		return userComment;
	}

	public void setUserComment(String userComment) {
		this.userComment = userComment;
	}

	public String getUserReview() {
		return userReview;
	}

	public void setUserReview(String userReview) {
		this.userReview = userReview;
	}

	public double getUser_balance() {
		return user_balance;
	}

	public void setUser_balance(double user_balance) {
		this.user_balance = user_balance;
	}

	@Override
	public String toString() {
		return "user id=" + user_id + ", first_name=" + first_name + ", last_name=" + last_name + ", phone="
				+ phone + ", username=" + username + ", password=" + password + ", userComment=" + userComment
				+ ", userReview=" + userReview + ", user_balance=" + user_balance;
	}

}
