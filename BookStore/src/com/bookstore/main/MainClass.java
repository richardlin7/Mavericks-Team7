package com.bookstore.main;

import java.util.Scanner;

import com.bookstore.main.DBconnection.DbConnection;
import com.bookstore.main.model.Admin;
import com.bookstore.main.model.User;
import com.bookstore.main.service.AdminService;
import com.bookstore.main.service.UserService;
import com.bookstore.main.utility.AdminUtility;
import com.bookstore.main.utility.UserUtility;

public class MainClass {

	public static void main(String[] args) {
		
		
		// Creating All object
		Scanner sc = new Scanner(System.in);
		// Users Objects
		UserService userService = new UserService();
		User u = new User();
		UserUtility userUtility = new UserUtility();

		// Admin Objects
		AdminService adminService = new AdminService();
		Admin a = new Admin();
		AdminUtility adminUtility = new AdminUtility();

		// Database Connection
		DbConnection db = new DbConnection();
		db.dbConnect();

		while (true) {
			System.out.println("***********************************");
			System.out.println("|    -------------------------    |");
			System.out.println("*    Library Management System    *");
			System.out.println("|    -------------------------    |");
			System.out.println("***********************************");
			System.out.println("1. User");
			System.out.println("2. Admin");
			System.out.println("0. Exit");
			System.out.println("**********************************");
			System.out.println("Enter your selection: ");
			int index = sc.nextInt();

			if (index == 0) {
				break;
			}

			switch (index) {

			// This is a User Block
			case 1:

				while (true) {

					System.out.println("*****Welcome User*****");
					System.out.println("1. Register Here!");
					System.out.println("2. Login");
					System.out.println("3. Forgot Password");
					System.out.println("0. Exit");
					System.out.println("User Enter your selection: ");
					System.out.println("");
					int user = sc.nextInt();
					if (user == 0) {
						System.out.println("Return to home");
						break;
					}
					// Nested Switch case for User
					switch (user) {
					case 1:
						System.out.println("1. User Register Here!");
						System.out.println("");

						System.out.println("Enter First Name: ");
						// This is just to skip the white space
						sc.nextLine();
						String f_Name = sc.nextLine();

						System.out.println("Enter Last Name: ");
						String l_Name = sc.next();

						System.out.println("Enter Phone Number: ");
						String p_Num = sc.next();

						System.out.println("Enter Username: ");
						String u_Name = sc.next();

						// Checking if userName Present
						while (true) {

							boolean isUserNameValid = userService.isUserNamePresent(u, u_Name);
							if (isUserNameValid == true) {
								System.out.println("Sorry username is already taken...Try Again");

								System.out.println("Enter Username: ");
								u_Name = sc.next();

							} else
								break;

						}

						System.out.println("Enter Password: ");
						String password = sc.next();

						u.setFirst_name(f_Name);
						u.setLast_name(l_Name);
						u.setPhone(p_Num);
						u.setUsername(u_Name);
						u.setPassword(password);

						// Calling user-service to register Users
						userService.registerUser(u);

						String userId = userService.getUserId(u, f_Name, l_Name, u_Name);
						System.out.println("User added Sucessfully. Your Libary Card Number is : " + userId);

						break;
					case 2:
						System.out.println("***** User Login *****");
						System.out.println("");

						System.out.println("Enter Username: ");
						String userName = sc.next();

						System.out.println("Enter Password: ");
						String uPassword = sc.next();

						boolean isPresent = userService.checkUsernameAndPassword(userName, uPassword, u);
						if (isPresent == false) { // if not present, exit
							System.out.println("Username and Password Invalid, Try Again");
							break;
						} else {
							System.out.println("Hello " + userName.toUpperCase() + ", Welcome to Libary!!!");

							userUtility.userMenu(userName);

						}

						break;
					case 3:
						System.out.println("3. Forgot Password");
						System.out.println("");
						
						System.out.println("Enter your First Name: ");
						String fName = sc.next();
						
						System.out.println("Enter your Last Name: ");
						String lName = sc.next();
						
						System.out.println("Enter your Username: ");
						String user_name = sc.next();
						
						boolean isValid = userService.isValidInfo(u,fName,lName,user_name);
						
						if (isValid==false) {
							System.out.println("User info dosenot match..");
							break;
							
						}
						
						System.out.println("Enter new Password: ");
						String newPassword = sc.next();
						
						userService.updatePassword(u,fName,lName,user_name,newPassword);
						
						System.out.println("Hello "+fName+", Your password sucessfully Updated");
						
						

						break;

					default:
						System.out.println("Invalid Selection");
						break;
					}

				}
				break;

				
			// This is a Admin Block
			case 2:

				while (true) {

					System.out.println("*****Welcome Admin*****");
					System.out.println("1. Admin Register Here!");
					System.out.println("2. Admin Login");
					System.out.println("3. Forgot Password");
					System.out.println("0. Exit");
					System.out.println("Admin Enter your selection: ");
					System.out.println("");
					int admin = sc.nextInt();
					if (admin == 0) {
						System.out.println("Return to Home");
						break;
					}
					
					// Nested Switch case for Admin
					switch (admin) {
					case 1:
						System.out.println("Admin Register Here!");
						System.out.println("");

						System.out.println("Enter First Name: ");
						String f_Name = sc.next();

						System.out.println("Enter Last Name: ");
						String l_Name = sc.next();

						System.out.println("Enter Phone Number: ");
						String p_Num = sc.next();

						System.out.println("Enter Username: ");
						String u_Name = sc.next();

						
						// Checking if userName Present

						while (true) {

							boolean isAdminNameValid = adminService.isAdminNamePresent(a, u_Name);
							if (isAdminNameValid == true) {
								System.out.println("Sorry username is already taken...Try Again");
								System.out.println("Enter Username: ");
								u_Name = sc.next();

							} else
								break;
						}

						System.out.println("Enter Password: ");
						String password = sc.next();

						
						// Creating User object to pass the entity
						
						a.setFirst_name(f_Name);
						a.setLast_name(l_Name);
						a.setPhone(p_Num);
						a.setUsername(u_Name);
						a.setPassword(password);

						
						// Creating UserService Object to call the add user methods
						
						adminService.registerAdmin(a);

						String adminId = adminService.getAdminId(a, f_Name, l_Name, u_Name);
						System.out.println("Admin added Sucessfully. Your Admin Number is : " + adminId);
						

						break;
					case 2:
						System.out.println("***** Admin Login *****");
						System.out.println("");

						System.out.println("Enter Username: ");
						String adminUserName = sc.next();

						System.out.println("Enter Password: ");
						String adminPassword = sc.next();

						boolean isPresent = adminService.checkUsernameAndPassword(adminUserName, adminPassword, a);
						if (isPresent == false) { // if not present, exit
							System.out.println("Username and Password Invalid, Try Again");
							break;
						} else {
							System.out.println("Hello " + adminUserName.toUpperCase() + ", Welcome to Libary!!!");

							adminUtility.adminMenu(adminUserName);
						}

						break;
					case 3:

						System.out.println("3. Forgot Password");
						System.out.println("");
						
						System.out.println("Enter your First Name: ");
						String fName = sc.next();
						
						System.out.println("Enter your Last Name: ");
						String lName = sc.next();
						
						System.out.println("Enter your Username: ");
						String user_name = sc.next();
						
						boolean isValid = adminService.isValidInfo(a,fName,lName,user_name);
						
						if (isValid==false) {
							System.out.println("Admin info dosenot match..");
							break;
							
						}
						
						System.out.println("Enter new Password: ");
						String newPassword = sc.next();
						
						adminService.updatePassword(a,fName,lName,user_name,newPassword);
						
						System.out.println("Hello "+fName+", Your password sucessfully Updated");

						break;

					default:
						System.out.println("Invalid Selection");
						break;
					}

				}
				break;

			// Main default message
			default:
				System.out.println("Enter Valid Selection");
				break;
			}

		}
		sc.close();
	}

}
