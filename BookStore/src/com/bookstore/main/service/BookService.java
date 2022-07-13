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
		String sql = " Select book_name,book_copies,book_status, listed_date from book ";
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
				
				list.add(new Book(result.getString("book_name"),
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
	
	public Book searchBook(int id) {
		db.dbConnect();
		String sql="select book_id,book_name,book_copies,book_cost,book_status,listed_date,author_id,category_id,library_id,admin_id from book where book_id=?";
		Book e = new Book(); 
		try {
			PreparedStatement pstmt = db.conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet result = pstmt.executeQuery();
			result.next();
			e = new Book(result.getString("book_name"),
					result.getInt("book_copies"),
					result.getString("book_status"),
					result.getString("listed_date")
					  );
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		db.dbClose();
		return e;
	}
	
	public void addBookToCart(Book book) { //add book to cart
		db.dbConnect();
		String sql="update book SET book_status=?, book_copies=? where book_id=?";
		try {
			PreparedStatement result = db.conn.prepareStatement(sql);
			result.setString(1, book.getBook_status());
			result.setInt(2, book.getBook_copies());
			result.setInt(3, book.getBook_id());
			result.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		db.dbClose();
	}

}
