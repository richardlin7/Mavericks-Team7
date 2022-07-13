package com.bookstore.main.utility;

import java.util.Scanner;

import com.bookstore.main.model.Book;
import com.bookstore.main.service.AdminService;

public class AdminUtility {

	public void adminMenu(String adminUserName) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		AdminService service = new AdminService();

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

				System.out.println("Enter Book Name: ");
				sc.nextLine();
				String bookName = sc.nextLine();
				System.out.println("Enter the book copies: ");
				int bookCopies = sc.nextInt();
				System.out.println("Enter the cost: ");
				double bookCost = sc.nextDouble();
				System.out.println("Book Satatus Active/Inactive: ");
				String bookStatus = sc.next();

				System.out.println("Book Listed Date: ");
				String date = sc.next();

				System.out.println("Enter Author First Name: ");
				String authFirstName = sc.next();
				System.out.println("Enter Author Last Name: ");
				String authLastName = sc.next();

				// System.out.println("Checking Author....");

				// int authorId = service.getAuthorId(authFirstName,authLastName);
				int authorId;
				// Checking weather author is present in batabase
				boolean isValid = service.isAuthorPresent(authFirstName, authLastName);

				if (isValid == true) {
					authorId = service.getAuthorId(authFirstName, authLastName);
				} else if (isValid == false) {
					service.insertAuthor(authFirstName, authLastName);
				}

				authorId = service.getAuthorId(authFirstName, authLastName);

				System.out.println("Enter Category Name: ");
				String cateName = sc.next();

				int CategoryId;
				// Checking weather Category is present in batabase
				boolean isCategoryValid = service.isCategoryIdPresent(cateName);

				if (isCategoryValid == true) {
					CategoryId = service.getCategoryId(cateName);
				} else {
					service.insertCategory(cateName);
				}
				CategoryId = service.getCategoryId(cateName);

				System.out.println("Enter Library Name: ");
				String libName = sc.next();

//				System.out.println("Enter Library phone: ");
//				String phone = sc.next();

				int libraryId;
				// Checking weather Library is present in batabase
				boolean isLibraryValid = service.isLibraryIdPresent(libName);

				if (isLibraryValid == true) {
					libraryId = service.getLibraryId(libName);
				} else {
					System.out.println("Enter Library phone: ");
					String phone = sc.next();
					service.insertLibrary(libName, phone);
				}
				libraryId = service.getLibraryId(libName);

				System.out.println("Enter Your Admin ID: ");
				int adminId = sc.nextInt();

				Book book = new Book();

				book.setBook_name(bookName);
				book.setBook_copies(bookCopies);
				book.setBook_cost(bookCost);
				book.setBook_status(bookStatus);
				book.setListed_date(date);

				service.insertBook(book, libraryId, CategoryId, authorId, adminId);

				System.out.println(" The book " + bookName + " added Sucessfully!!!");

				break;
			case 2:
				System.out.println("2. Remove Book");
				// To Do

				break;
			case 3:
				System.out.println("3. Update Book");
				// To Do

				break;
			case 4:
				System.out.println("4. View Users");
				// To Do

				break;
			case 5:
				System.out.println("5. Delete User");
				// To Do

				break;
			case 6:
				System.out.println("6. Create New Admin");
				// To Do

				break;

			default:
				break;
			}

		}
		// sc.close();

	}

}
