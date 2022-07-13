package com.bookstore.main.utility;

import java.util.List;
import java.util.Scanner;

import com.bookstore.main.model.Book;
import com.bookstore.main.service.UserService;

public class UserUtility {

	Scanner sc = new Scanner(System.in);
	// Creating all the Class Objects
	// Creating userService Object
	UserService service = new UserService();
	BookService bookService = new BookService();
	Book book = new Book();

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
				System.out.println(" ");

				// Showing all the books
				List<Book> list = bookService.showAllBooks();

				for (Book book : list) {

					System.out.println("Book Name: " + book.getBook_name() + ", Aviliable Copies: "
							+ book.getBook_copies() + ", Book Status: " + book.getBook_status() + ", Listed date: "
							+ book.getListed_date() + ".");
				}
				System.out.println(" ");

				break;
			case 2:
				System.out.println("2. Search Books");

				// To Do

				break;
			case 3:
				System.out.println("3. Sort Book");

				// To Do

				break;
			case 4:
				System.out.println("4. Checkout Book");

				// To Do

				break;

			default:
				break;
			}

		}

	}

}
