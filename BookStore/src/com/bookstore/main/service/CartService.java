package com.bookstore.main.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookstore.main.DBconnection.DbConnection;
import com.bookstore.main.model.Book;
import com.bookstore.main.model.Cart;

public class CartService {
	DbConnection db = new DbConnection();
	
	public List<Cart> showAllCart(int user_id) {
		//List<String> list = new ArrayList<>();
		db.dbConnect();
		String sql = " Select * from cart where user_id=? ";
		List<Cart> list = new ArrayList<>();
		
		try {
			PreparedStatement prep = db.conn.prepareStatement(sql);
			prep.setInt(1, user_id);
			ResultSet result = prep.executeQuery();
			
			while (result.next()) {
//				String book_name = result.getString();
//				String book_copies = result.getString("book_copies");
//				String book_status = result.getString("book_status");
//				String listed_date = result.getString("listed_date");
//				
//				list=Arrays.asList(book_name,book_copies,book_status,listed_date);
				
				list.add(new Cart(result.getInt("cart_id"),
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
	
	public Cart searchCart(int book_id, int user_id) {
		db.dbConnect();
		String sql="select cart_id, user_id, book_id,book_copies from cart where book_id=? and user_id=?";
		Cart e = null; 
		try {
			PreparedStatement pstmt = db.conn.prepareStatement(sql);
			pstmt.setInt(1, book_id);
			pstmt.setInt(2, user_id);
			ResultSet result = pstmt.executeQuery();
			
			while(result.next()) {
			e = new Cart(result.getInt("cart_id"),
					result.getInt("user_id"),
					result.getInt("book_id"),
					result.getInt("book_copies")
					  );
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		db.dbClose();
		return e;
	}
	
	public void insertCart(Cart cart) {
		db.dbConnect();
		String sql = " INSERT INTO `cart`(`user_id`, `book_id`, `book_copies`) " + "VALUES (?,?,?) ";
		try {
			PreparedStatement prep = db.conn.prepareStatement(sql);
			prep.setInt(1, cart.getUser_id());
			prep.setInt(2, cart.getBook_id());
			prep.setInt(3, cart.getBook_copies());
			prep.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.dbClose();
	}
	
	public void updateCart(Cart cart) { //add book to cart
		db.dbConnect();
		String sql="update cart SET user_id=?, book_id=?,book_copies=? where cart_id=?";
		try {
			PreparedStatement result = db.conn.prepareStatement(sql);
			result.setInt(1, cart.getUser_id());
			result.setInt(2, cart.getBook_id());
			result.setInt(3, cart.getBook_copies());
			result.setInt(4, cart.getCart_id());
			result.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		db.dbClose();
	}
	
}
