package model;

public class Book {
	
	private int id;
	private String name;
	private int copies;
	private double cost;
	private String status;
	private String date;
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(int id, String name, int copies, double cost, String status, String date) {
		super();
		this.id = id;
		this.name = name;
		this.copies = copies;
		this.cost = cost;
		this.status = status;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCopies() {
		return copies;
	}

	public void setCopies(int copies) {
		this.copies = copies;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	

}
