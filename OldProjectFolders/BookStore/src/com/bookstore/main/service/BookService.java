package com.bookstore.main.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookstore.main.DBconnection.DbConnection;
import com.bookstore.main.model.Book;

public class BookService {
	
	DbConnection db = new DbConnection();
	
	//List<Book> list = new ArrayList<>();
	

	public List<Book> showAllBooks() {
		//List<String> list = new ArrayList<>();
		db.dbConnect();
		String sql = " Select * from book ";
		List<Book> list = new ArrayList<>();
		
		try {
			PreparedStatement prep = db.conn.prepareStatement(sql);
			
			ResultSet result = prep.executeQuery();
			
			while (result.next()) {
//				String book_name = result.getString();
//				String book_copies = result.getString("book_copies");
//				String book_status = result.getString("book_status");
//				String listed_date = result.getString("listed_date");
//				
//				list=Arrays.asList(book_name,book_copies,book_status,listed_date);
				
				list.add(new Book(result.getInt("book_id"),
								result.getString("book_name"),
								result.getInt("book_copies"),
								result.getString("book_status"),
								result.getString("listed_date")));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		db.dbClose();
		return list;
	}
	
	public String getBookNameById(int book_id) {
		db.dbConnect();
		String bookName = null;
		String sql = " SELECT book_name FROM `book` WHERE book_id=?";
		try {
			PreparedStatement prep = db.conn.prepareStatement(sql);
			prep.setInt(1, book_id);
			
			ResultSet res = prep.executeQuery();
			while (res.next()) {
				bookName = res.getString("book_name");

			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		db.dbClose();

		return bookName;
	}
	
	public int getBookIdByName(String book_name) {
		db.dbConnect();
		int bookId=0;
		String sql = " SELECT book_id FROM `book` WHERE book_name=?";
		try {
			PreparedStatement prep = db.conn.prepareStatement(sql);
			prep.setString(1, book_name);
			
			ResultSet res = prep.executeQuery();
			while (res.next()) {
				bookId = res.getInt("book_id");

			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		db.dbClose();

		return bookId;
	}
	
	public Book searchBook(int id) {
		db.dbConnect();
		String sql="select book_id, book_name,book_copies,book_cost,book_status,listed_date from book where book_id=?";
		Book e = null; 
		try {
			PreparedStatement pstmt = db.conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet result = pstmt.executeQuery();
			
			while(result.next()) {
			e = new Book(result.getInt("book_id"),
					result.getString("book_name"),
					result.getInt("book_copies"),
					result.getString("book_status"),
					result.getString("listed_date")
					  );
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		db.dbClose();
		return e;
	}
	
	public void removeBook(int book) { //add book to cart
		db.dbConnect();
		String sql="delete from book where book_id=?";
		try {
			PreparedStatement result = db.conn.prepareStatement(sql);
			result.setInt(1, book);
			result.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		db.dbClose();
	}
	
	public void updateBook(Book book) { //add book to cart
		db.dbConnect();
		String sql="update book SET book_name=?, book_status=?, book_cost=?, book_copies=?, listed_date=? where book_id=?";
		try {
			PreparedStatement result = db.conn.prepareStatement(sql);
			result.setString(1, book.getBook_name());
			result.setString(2, book.getBook_status());
			result.setDouble(3, book.getBook_cost());
			result.setInt(4, book.getBook_copies());
			result.setString(5, book.getListed_date());
			result.setInt(6, book.getBook_id());
			result.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		db.dbClose();
	}

}
