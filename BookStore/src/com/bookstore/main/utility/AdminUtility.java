package com.bookstore.main.utility;

import java.util.Scanner;

public class AdminUtility {

	public void adminMenu(String adminUserName) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.println("*******Admin Menu*******");
			System.out.println("1. Add Book");
			System.out.println("2. Remove Book");
			System.out.println("3. Update Book");
			System.out.println("4. View Users");
			System.out.println("5. Delete User");
			System.out.println("6. Create New Admin");
			System.out.println("0. Log Out");

			System.out.println("Hi " + adminUserName.toUpperCase() + ", Please select the opreation: ");
			int index = sc.nextInt();

			if (index == 0) {
				System.out.println("Logout..Returining to the menu.");
				break;
			}

			switch (index) {
			case 1:
				System.out.println("***** Add Book *****");

				break;
			case 2:
				System.out.println("2. Remove Book");

				break;
			case 3:
				System.out.println("3. Update Book");

				break;
			case 4:
				System.out.println("4. View Users");

				break;
			case 5:
				System.out.println("5. Delete User");

				break;
			case 6:
				System.out.println("6. Create New Admin");

				break;

			default:
				break;
			}

		}
		// sc.close();

	}

}
