package com.bookstore.main.utility;

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
	

//	public void showAllBooks() {
//		List<Book> list = new ArrayList<>();
//		db.dbConnect();
//		String sql = " Select book_name,book_copies,book_status, listed_date from book ";
//		
//		try {
//			PreparedStatement prep = db.conn.prepareStatement(sql);
//			
//			ResultSet result = prep.executeQuery();
//			
//			while (result.next()) {
//				//result.getString("book_name");
//				
//				
//			}
//			
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		db.dbClose();
//		
//		
//	}

}
