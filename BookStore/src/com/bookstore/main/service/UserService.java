package com.bookstore.main.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.bookstore.main.DBconnection.DbConnection;
import com.bookstore.main.model.User;

public class UserService {
	DbConnection db = new DbConnection();

	public void registerUser(User u) {
		db.dbConnect();
		String sql = " INSERT INTO `user`( `first_name`, `last_name`, `phone`, `username`, `password`) "
				+ "VALUES (?,?,?,?,?)";

		try {
			PreparedStatement prep = db.conn.prepareStatement(sql);
			prep.setString(1, u.getFirst_name());
			prep.setString(2, u.getLast_name());
			prep.setString(3, u.getPhone());
			prep.setString(4, u.getUsername());
			prep.setString(5, u.getPassword());
			prep.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		db.dbClose();

	}

	public String getUserId(String f_Name, String l_Name, String u_Name) {
		db.dbConnect();
		String userId = null;
		String sql = " SELECT user_id FROM `user` WHERE first_name = ? and last_name=? and username =?";
		try {
			PreparedStatement prep = db.conn.prepareStatement(sql);
			prep.setString(1, f_Name);
			prep.setString(2, l_Name);
			prep.setString(3, u_Name);

			ResultSet res = prep.executeQuery();
			while (res.next()) {
				userId = res.getString("user_id");

			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		db.dbClose();

		return userId;
	}
	
	public String getUserIdByUsername(String u_Name) {
		db.dbConnect();
		String userId = null;
		String sql = " SELECT user_id FROM `user` WHERE username =?";
		try {
			PreparedStatement prep = db.conn.prepareStatement(sql);
			prep.setString(1, u_Name);
			
			ResultSet res = prep.executeQuery();
			while (res.next()) {
				userId = res.getString("user_id");

			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		db.dbClose();

		return userId;
	}

	public boolean checkUsernameAndPassword(String userName, String uPassword, User u) {

		boolean isValid = false;
		db.dbConnect();

		String sql = " select username,password from user where username = ? and password = ? ";
		try {
			PreparedStatement prep = db.conn.prepareStatement(sql);
			prep.setString(1, userName);
			prep.setString(2, uPassword);

			ResultSet result = prep.executeQuery();

			while (result.next()) {

				if (result.getString("username").equals(userName) && result.getString("password").equals(uPassword))

					isValid = true;

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		db.dbClose();
		return isValid;
	}

	public boolean isUserNamePresent(User u, String u_Name) {

		boolean isUserNameValid = false;
		db.dbConnect();
		String sql = " select username from user where username = ? ";

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

		db.dbClose();
		return isUserNameValid;
	}

	public boolean isValidInfo(User u, String fName, String lName, String user_name) {

		boolean isValid = false;

		db.dbConnect();

		String sql = " select first_name, last_name, username from user ";

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

	public void updatePassword(User u, String fName, String lName, String user_name, String newPassword) {

		db.dbConnect();

		String sql = " UPDATE `user` SET `password`=? WHERE first_name=? and last_name=? and username=? ";

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
	
	
	public boolean checkUserID(int userID) {

		boolean isValid = false;
		db.dbConnect();

		String sql = " select user_id from user where user_id = ? ";
		try {
			PreparedStatement prep = db.conn.prepareStatement(sql);
			prep.setInt(1, userID);

			ResultSet result = prep.executeQuery();

			while (result.next()) {

				if (result.getInt("user_id")==(userID))

					isValid = true;

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		db.dbClose();
		return isValid;
	}
}
