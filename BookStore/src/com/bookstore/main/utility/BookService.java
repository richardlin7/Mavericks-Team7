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
	

	public List<Book> showAllBooks() {
		//List<String> list = new ArrayList<>();
		db.dbConnect();
		String sql = " Select book_name,book_copies,book_status, listed_date from book ";
		List<Book> list = new ArrayList<>();
		
		try {
			PreparedStatement prep = db.conn.prepareStatement(sql);
			
			ResultSet result = prep.executeQuery();
			
			while (result.next()) {

				
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

}
