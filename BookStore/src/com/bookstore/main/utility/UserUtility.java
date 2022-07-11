package com.bookstore.main.utility;

import java.util.Scanner;

public class UserUtility {

	Scanner sc = new Scanner(System.in);

	public void userMenu(String userName) {

		while (true) {

			System.out.println("*******User Menu*******");
			System.out.println("1. Show Books");
			System.out.println("2. Search Books");
			System.out.println("3. Short Book");
			System.out.println("4. Checkout Book");
			System.out.println("0. Log Out");

			System.out.println("Hi " + userName.toUpperCase() + ", Please select the opreation: ");
			int index = sc.nextInt();

			if (index == 0) {
				System.out.println("Logout..Returining to the menu.");
				break;
			}

			switch (index) {
			case 1:
				System.out.println("***** The Collections of Books *****");

				break;
			case 2:
				System.out.println("2. Search Books");

				break;
			case 3:
				System.out.println("3. Sort Book");

				break;
			case 4:
				System.out.println("4. Checkout Book");

				break;

			default:
				break;
			}

		}

	}

}
