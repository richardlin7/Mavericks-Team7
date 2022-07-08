package db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import model.User;


public class DB {
	Connection con; 
	
	public void dbConnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//System.out.println("Driver loaded..");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}  
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore"
					,"root","Password");
			//System.out.println("Connection Established..");
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
	}
	
	public void dbClose() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertUser(User user) {
		 dbConnect();
		 String sql="insert into user(user_id,first_name,last_name,username,password,userComment,userReview,user_balance) "
		 		+ "values (?,?,?,?,?,?,?,?)";
		 
		 try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, user.getId() );
			pstmt.setString(2, user.getFname() );
			pstmt.setString(3, user.getLname() );
			pstmt.setString(4, user.getUsername() );
			pstmt.setString(5, user.getPassword() );
			pstmt.setString(6, user.getUserComment());
			pstmt.setString(7, user.getUserReview());
			pstmt.setDouble(8, user.getBalance());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
		 dbClose();
	}
	
	public List<User> fetchUsers() {
		dbConnect();
		String sql="select * from user";
		List<User> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet  rst = pstmt.executeQuery();
			
			while(rst.next()) {
				list.add(new User(rst.getInt("user_id"),
									  rst.getString("first_name"),
									  rst.getString("last_name"), 
									  rst.getString("username"),
									  rst.getString("password"),
									  rst.getString("userComment"),
									  rst.getString("userReview"),
									  rst.getDouble("user_balance")
									  ));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbClose();
		return list;
	}
	
	
	public void deleteUser(int id) {
		dbConnect();
		String sql="delete from user where user_id=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbClose();
	}

}
