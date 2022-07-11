package com.bookstore.main.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bookstore.main.DBconnection.DbConnection;
import com.bookstore.main.model.Admin;

public class AdminService {
	DbConnection db = new DbConnection();

	//Inserting admin info into the database
	public void registerAdmin(Admin a) {
		db.dbConnect();
		String sql = " INSERT INTO `admin`( `first_name`, `last_name`, `phone`, `username`, `password`) "
				+ "VALUES (?,?,?,?,?)";

		try {
			PreparedStatement prep = db.conn.prepareStatement(sql);
			prep.setString(1, a.getFirst_name());
			prep.setString(2, a.getLast_name());
			prep.setString(3, a.getPhone());
			prep.setString(4, a.getUsername());
			prep.setString(5, a.getPassword());
			prep.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		db.dbClose();

	}

	//Getting Admin ID or Library Card from database
	public String getAdminId(Admin a, String f_Name, String l_Name, String u_Name) {
		db.dbConnect();
		String adminId = null;
		String sql = " SELECT admin_id FROM `admin` WHERE first_name = ? and last_name=? and username =?";
		try {
			PreparedStatement prep = db.conn.prepareStatement(sql);
			prep.setString(1, f_Name);
			prep.setString(2, l_Name);
			prep.setString(3, u_Name);

			ResultSet res = prep.executeQuery();
			while (res.next()) {
				adminId = res.getString("admin_id");

				// System.out.println(userId);
			}

			// prep.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		db.dbClose();

		return adminId;
	}

	
	//Validating username and password for loging ascess
	public boolean checkUsernameAndPassword(String adminUserName, String adminPassword, Admin a) {
		boolean isValid = false;
		db.dbConnect();

		String sql = " select username,password from admin where username = ? and password = ? ";
		try {
			PreparedStatement prep = db.conn.prepareStatement(sql);
			prep.setString(1, adminUserName);
			prep.setString(2, adminPassword);

			ResultSet result = prep.executeQuery();

			while (result.next()) {

				if (result.getString("username").equals(adminUserName)
						&& result.getString("password").equals(adminPassword))

					isValid = true;

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		db.dbClose();
		return isValid;
	}

	
	//Checking is the username is already presence in the database
	public boolean isAdminNamePresent(Admin a, String u_Name) {
		boolean isUserNameValid = false;
		db.dbConnect();//db call connect
		String sql = " select username from admin where username = ? ";

		try {
			PreparedStatement prep = db.conn.prepareStatement(sql);
			prep.setString(1, u_Name);

			ResultSet result = prep.executeQuery();
			while (result.next()) {
				if (result.getString("username").equals(u_Name)) {
					isUserNameValid = true;
				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		db.dbClose();//db call close
		return isUserNameValid;
	}

	//Checking if the admin credential is present before changing the password
	public boolean isValidInfo(Admin a, String fName, String lName, String user_name) {

		boolean isValid = false;

		db.dbConnect();

		String sql = " select first_name, last_name, username from admin ";

		try {
			PreparedStatement prep = db.conn.prepareStatement(sql);

			ResultSet result = prep.executeQuery();

			while (result.next()) {

				if (result.getString("first_name").equals(fName) && result.getString("last_name").equals(lName)
						&& result.getString("username").equals(user_name)) {
					isValid = true;
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		db.dbClose();
		return isValid;
	}

	//Updating the admin password
	public void updatePassword(Admin a, String fName, String lName, String user_name, String newPassword) {

		db.dbConnect();

		String sql = " UPDATE `admin` SET `password`=? WHERE first_name=? and last_name=? and username=? ";

		try {
			PreparedStatement prep = db.conn.prepareStatement(sql);
			prep.setString(1, newPassword);
			prep.setString(2, fName);
			prep.setString(3, lName);
			prep.setString(4, user_name);
			prep.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		db.dbClose();

	}

}
