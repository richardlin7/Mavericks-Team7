package model;

public class User {

	private int id;
	private String fname; 
	private String lname; 
	private String username; 
	private String password;
	private String userComment;
	private String userReview; 
	private double balance; 
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(int id, String fname, String lname, String username, 
			String password, String userComment, String userReview, double balance) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.username = username;
		this.password = password;
		this.userComment = userComment;
		this.userReview = userReview;
		this.balance = balance;
	}
	
	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getFname() {
		return fname;
	}



	public void setFname(String fname) {
		this.fname = fname;
	}



	public String getLname() {
		return lname;
	}



	public void setLname(String lname) {
		this.lname = lname;
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



	public double getBalance() {
		return balance;
	}



	public void setBalance(double balance) {
		this.balance = balance;
	}



	@Override
	public String toString() {
		return "Employee [id=" + id + ", fname=" + fname + ", lname=" + lname + ", username=" + username + ", password="
				+ password + ", userComment=" + userComment + ", userReview=" + userReview +", balance=" + balance + "]";
	} 
	
	
}
