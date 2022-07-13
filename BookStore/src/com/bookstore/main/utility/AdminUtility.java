package com.bookstore.main.utility;

import java.util.Scanner;

import com.bookstore.main.model.Book;
import com.bookstore.main.service.BookService;

public class AdminUtility {

	public void adminMenu(String adminUserName) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		BookService bookService = new BookService();

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
				//To Do

				break;
			case 2:
				System.out.println("2. Remove Book");
				System.out.println("Enter ID of Book to remove:");
				int bid = sc.nextInt();
				Book book = bookService.searchBook(bid);
				if(book == null) {
					System.out.println("Please Enter Valid ID");
					break;
				}
				bookService.removeBook(bid);
				break;
			case 3:
				System.out.println("3. Update Book");
				System.out.println("Enter ID of Book to update:");
				bid = sc.nextInt();
				book = bookService.searchBook(bid);
				if(book == null) {
					System.out.println("Please Enter Valid ID");
					break;
				}
				//TODO REMOVE IF NOT ALREADY FIXED
				book.setBook_id(bid);
				System.out.println("Current status:");
				System.out.println(book);
				System.out.println("\nUpdate Book Name:");
				book.setBook_name(sc.next());
				System.out.println("Update Book Copies:");
				book.setBook_copies(sc.nextInt());
				System.out.println("Update Book Cost:");
				book.setBook_cost(sc.nextDouble());
				System.out.println("Update Book Status:");
				book.setBook_status(sc.next());
				System.out.println("Update Book Due Date:");
				book.setListed_date(sc.next());
				//System.out.println("Update Book Author:");
				//book.setBook_name(sc.next());
				System.out.println("TODO: Allow update Author categories and library and admins");
				
				bookService.updateBook(book);
				break;
			case 4:
				System.out.println("4. View Users");
				//To Do

				break;
			case 5:
				System.out.println("5. Delete User");
				//To Do

				break;
			case 6:
				System.out.println("6. Create New Admin");
				//To Do

				break;

			default:
				break;
			}

		}
		// sc.close();

	}

}
