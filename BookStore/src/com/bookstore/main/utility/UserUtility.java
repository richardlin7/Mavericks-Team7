package com.bookstore.main.utility;

import java.util.List;
import java.util.Scanner;

import com.bookstore.main.model.Book;
import com.bookstore.main.service.BookService;
import com.bookstore.main.service.UserService;

public class UserUtility {

	Scanner sc = new Scanner(System.in);
	// Creating all the Class Objects
	//Creating userService Object
	UserService service = new UserService();
	BookService bookService = new BookService();
	Book book= new Book();
	
	

	public void userMenu(String userName) {

		while (true) {

			System.out.println("*******User Menu*******");
			System.out.println("1. Show Books");
			System.out.println("2. Search Books");
			System.out.println("3. Checkout Book");
			System.out.println("0. Log Out");

			System.out.println("Hi " + userName.toUpperCase() + ", Please select the operation: ");
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
					
					System.out.println("Book Name: "+ book.getBook_name()+", Aviliable Copies: "+book.getBook_copies()+ ", Book Status: "+book.getBook_status()+", Listed date: "+book.getListed_date()+".");
				}
				System.out.println(" ");
				
				break;
			case 2:
				System.out.println("***** Book Search *****");
				
				System.out.println("Enter Book_ID");
				int id = sc.nextInt();
				 
				Book bk = bookService.searchBook(id); 
				if(bk == null) {
					System.out.println("Please Enter Valid Book ID");
					break;
				}
				System.out.println("Existing book for book_id: "+id);
				System.out.println("Book Name: "+ bk.getBook_name()+", Aviliable Copies: "+bk.getBook_copies()+ ", Book Status: "+bk.getBook_status()+", Listed date: "+bk.getListed_date()+".");
				 
				System.out.println("\n Would you like to add this book to cart?");
				System.out.println("1. Yes");
			    System.out.println("2. No");
				index = sc.nextInt();
				
				switch (index) {
				case 1:
					int copies = bk.getBook_copies()-1;
					book.setBook_id(id);
					if (copies == 0) {
						book.setBook_status("Unavailable");
					}else {
						book.setBook_status("Available");
					}
					book.setBook_copies(copies);
					bookService.addBookToCart(book);
					
					System.out.println("Book added to cart.");
					break;
				case 2:
					System.out.println("Returning to previous selection...");
					break;
				default:
					System.out.println("Invalid Input. Returning to previous selection...");
					break;
				}
				break;
			case 3:
				System.out.println("3. Checkout Book");
				
				//To Do

				break;
			default:
				break;
			}
		}
	}
}
