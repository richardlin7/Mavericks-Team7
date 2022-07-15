package com.bookstore.main.DBconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	public Connection conn;

	// Database connection
	public void dbConnect() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// System.out.println("Driver Loaded Successfully...");
		} catch (ClassNotFoundException e) {
			System.out.println("Error Occur While loading driver...");
			e.printStackTrace();
		}
		try {
			//Personal Device Connection
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore"
					,"root","");
			
			//Server Connection
//			conn = DriverManager.getConnection("jdbc:mysql://cmsc508.com/humanresources_pradhanr", "pradhanr",
//					"V00942207");
			
			
			// System.out.println("Connection successful....");
		} catch (SQLException e) {
			System.out.println("Could not able to connect to Database...");
			e.printStackTrace();
		}

	}

	// Database close
	public void dbClose() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
