package com.bookstore.main.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookstore.main.DBconnection.DbConnection;
import com.bookstore.main.model.Admin;
import com.bookstore.main.model.Book;
import com.bookstore.main.model.User;



public class AdminService {
	DbConnection db = new DbConnection();

	// Inserting admin info into the database
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

	// Getting Admin ID or Library Card from database
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

	// Validating username and password for loging ascess
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

	// Checking is the username is already presence in the database
	public boolean isAdminNamePresent(Admin a, String u_Name) {
		boolean isUserNameValid = false;
		db.dbConnect();// db call connect
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

		db.dbClose();// db call close
		return isUserNameValid;
	}

	// Checking if the admin credential is present before changing the password
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

	// Updating the admin password
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

	public boolean isAuthorPresent(String authFirstName, String authLastName) {

		boolean isValid = false;
		db.dbConnect();

		String sql = " select * from book_author where first_name=? and last_name=? ";

		try {
			PreparedStatement prep = db.conn.prepareStatement(sql);

			prep.setString(1, authFirstName);
			prep.setString(2, authLastName);

			ResultSet result = prep.executeQuery();
			while (result.next()) {

				if (result.getString("first_name").equalsIgnoreCase(authFirstName)
						&& result.getString("last_name").equalsIgnoreCase(authLastName)) {
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

	public int getAuthorId(String authFirstName, String authLastName) {

		int authorId = 0;

		db.dbConnect();

		String sql = " select * from book_author where first_name=? and last_name=? ";

		try {
			PreparedStatement prep = db.conn.prepareStatement(sql);

			prep.setString(1, authFirstName);
			prep.setString(2, authLastName);

			ResultSet result = prep.executeQuery();
			while (result.next()) {

				if (result.getString("first_name").equalsIgnoreCase(authFirstName)
						&& result.getString("last_name").equalsIgnoreCase(authLastName)) {
					authorId = result.getInt("author_id");
				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		db.dbClose();

		return authorId;
	}

	public void insertAuthor(String authFirstName, String authLastName) {
		db.dbConnect();

		String sql = " INSERT INTO `book_author`( `first_name`, `last_name`) " + "VALUES (?,?)";

		try {
			PreparedStatement prep = db.conn.prepareStatement(sql);

			prep.setString(1, authFirstName);
			prep.setString(2, authLastName);

			prep.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		db.dbClose();

	}

	public boolean isCategoryIdPresent(String cateName) {
		boolean isValid = false;
		db.dbConnect();

		String sql = " select * from categories where category_name=? ";

		try {
			PreparedStatement prep = db.conn.prepareStatement(sql);

			prep.setString(1, cateName);

			ResultSet result = prep.executeQuery();
			while (result.next()) {

				if (result.getString("category_name").equalsIgnoreCase(cateName)) {
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

	public int getCategoryId(String cateName) {
		int cateId = 0;

		db.dbConnect();

		String sql = " select * from categories where category_name=? ";

		try {
			PreparedStatement prep = db.conn.prepareStatement(sql);

			prep.setString(1, cateName);

			ResultSet result = prep.executeQuery();
			while (result.next()) {

				if (result.getString("category_name").equalsIgnoreCase(cateName)) {
					cateId = result.getInt("category_id");
				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		db.dbClose();

		return cateId;
	}

	public void insertCategory(String cateName) {
		db.dbConnect();

		String sql = " INSERT INTO `categories`( `category_name`) " + "VALUES (?)";

		try {
			PreparedStatement prep = db.conn.prepareStatement(sql);

			prep.setString(1, cateName);

			prep.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		db.dbClose();

	}

	public boolean isLibraryIdPresent(String libName) {
		boolean isValid = false;
		db.dbConnect();

		String sql = " select * from library where library_name=? ";

		try {
			PreparedStatement prep = db.conn.prepareStatement(sql);

			prep.setString(1, libName);

			ResultSet result = prep.executeQuery();
			while (result.next()) {

				if (result.getString("library_name").equalsIgnoreCase(libName)) {
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

	public int getLibraryId(String libName) {
		int libId = 0;

		db.dbConnect();

		String sql = " select * from library where library_name=? ";

		try {
			PreparedStatement prep = db.conn.prepareStatement(sql);

			prep.setString(1, libName);

			ResultSet result = prep.executeQuery();
			while (result.next()) {

				if (result.getString("library_name").equalsIgnoreCase(libName)) {
					libId = result.getInt("library_id");
				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		db.dbClose();

		return libId;
	}

	public void insertLibrary(String libName, String phone) {
		db.dbConnect();
		String sql = " INSERT INTO `library`( `library_name`, `phone`) " + "VALUES (?,?)";

		try {
			PreparedStatement prep = db.conn.prepareStatement(sql);
			prep.setString(1, libName);
			prep.setString(2, phone);
			prep.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		db.dbClose();

	}

	public void insertBook(Book book, int libraryId, int categoryId, int authorId, int adminId) {

		db.dbConnect();

		String sql = " INSERT INTO `book`(`book_name`, `book_copies`, `book_cost`, `book_status`, `listed_date`, `author_id`, `category_id`, `library_id`, `admin_id`) "
				+ "VALUES (?,?,?,?,?,?,?,?,?) ";
		try {
			PreparedStatement prep = db.conn.prepareStatement(sql);
			prep.setString(1, book.getBook_name());
			prep.setInt(2, book.getBook_copies());
			prep.setDouble(3, book.getBook_cost());
			prep.setString(4, book.getBook_status());
			prep.setString(5, book.getListed_date());
			prep.setInt(6, authorId);
			prep.setInt(7, categoryId);
			prep.setInt(8, libraryId);
			prep.setInt(9, adminId);

			prep.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		db.dbClose();

	}

	public List<Admin> getAllAdminDetails() {
		List<Admin> list = new ArrayList<>();
		db.dbConnect();
		String sql = " select * from admin";
		try {
			PreparedStatement prep = db.conn.prepareStatement(sql);

			ResultSet result = prep.executeQuery();

			while (result.next()) {

				list.add(new Admin(result.getInt("admin_id"), result.getString("first_name"),
						result.getString("last_name")));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.dbClose();
		return list;
	}
	public List<User> fetchUsers() {
		db.dbConnect();
		String sql="select * from user";
		List<User> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = db.conn.prepareStatement(sql);
			ResultSet  rst = pstmt.executeQuery();
			
			while(rst.next()) {
				User user = new User();

				/*list.add(new User(rst.getInt("user_id"),
									  rst.getString("first_name"),
									  rst.getString("last_name"), 
									  rst.getString("phone"),
									  rst.getString("username"),
									  rst.getString("password"),
									  rst.getString("userComment"),
									  rst.getString("userReview"),
									  rst.getDouble("user_balance")
									  ));*/
				
				user.setUser_id(rst.getInt("user_id"));
				user.setFirst_name(rst.getString("first_name"));
				user.setLast_name(rst.getString("last_name"));
				user.setPhone(rst.getString("phone"));
				user.setUsername(rst.getString("username"));
				user.setPassword(rst.getString("password"));
				
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		db.dbClose();
		return list;
	}
	
	public void deleteUser(int id) {
		db.dbConnect();
		String sql="delete from user where user_id=?";
		try {
			PreparedStatement pstmt = db.conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		db.dbClose();
	}

	
	public List<Admin> fetchAdmins() {
		db.dbConnect();
		String sql="select * from admin";
		List<Admin> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = db.conn.prepareStatement(sql);
			ResultSet  rst = pstmt.executeQuery();
			
			while(rst.next()) {
				list.add(new Admin(rst.getInt("admin_id"),
									  rst.getString("first_name"),
									  rst.getString("last_name"), 
									  rst.getString("phone"),
									  rst.getString("username"),
									  rst.getString("password")
									  ));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		db.dbClose();
		return list;
	}

}
