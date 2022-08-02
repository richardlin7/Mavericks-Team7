package com.bookstore.main.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookstore.main.DBconnection.DbConnection;
import com.bookstore.main.model.Book;
import com.bookstore.main.model.Checkout;
import com.bookstore.main.model.Cart;

public class CheckoutService {
	DbConnection db = new DbConnection();
	
	public List<Checkout> showAllCheckout(int user_id) {
		db.dbConnect();
		String sql = " Select * from checkout where user_id=? ";
		List<Checkout> list = new ArrayList<>();
		
		try {
			PreparedStatement prep = db.conn.prepareStatement(sql);
			prep.setInt(1, user_id);
			ResultSet result = prep.executeQuery();
			
			while (result.next()) {
				list.add(new Checkout(result.getInt("checkout_id"),
						result.getInt("user_id"),
						result.getInt("book_id"),
						result.getInt("book_copies")));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		db.dbClose();
		return list;
	}
	
	public void insertCheckout(Checkout checkout) {
		db.dbConnect();
		String sql = " INSERT INTO `checkout`(`user_id`, `book_id`, `book_copies`) " + "VALUES (?,?,?) ";
		try {
			PreparedStatement prep = db.conn.prepareStatement(sql);
			prep.setInt(1, checkout.getUser_id());
			prep.setInt(2, checkout.getBook_id());
			prep.setInt(3, checkout.getBook_copies());
			prep.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.dbClose();
	}
	
	public boolean isCheckoutPresent(int user_id) {
		boolean isCheckoutPresent = false;
		db.dbConnect();
		String sql = " select checkout_id from checkout where user_id = ? ";

		try {
			PreparedStatement prep = db.conn.prepareStatement(sql);
			prep.setInt(1, user_id);

			ResultSet result = prep.executeQuery();
			while (result.next()) {
				if (result.getInt("user_id") == user_id) {
					isCheckoutPresent = true;
				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		db.dbClose();
		return isCheckoutPresent;
	}
}
