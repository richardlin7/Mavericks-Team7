package com.bookstore.main.utility;

import java.util.List;
import java.util.Scanner;

import com.bookstore.main.model.Book;
import com.bookstore.main.model.Cart;
import com.bookstore.main.model.Checkout;
import com.bookstore.main.service.BookService;
import com.bookstore.main.service.UserService;
import com.bookstore.main.service.CartService;

public class UserUtility {

	Scanner sc = new Scanner(System.in);
	// Creating all the Class Objects
	//Creating userService Object
	UserService service = new UserService();
	BookService bookService = new BookService();
	CartService cartService = new CartService();
	Book book= new Book();
	Cart cart= new Cart();
	Checkout checkout= new Checkout();
	
	

	@SuppressWarnings("null")
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
				System.out.println("***** The Collections of Books *****\n");
				
				// Showing all the books
				List<Book> list = bookService.showAllBooks();
				
				for (Book book : list) {
					
					System.out.println("Book Name: "+ book.getBook_name()+", Aviliable Copies: "+book.getBook_copies()+ ", Book Status: "+book.getBook_status()+", Listed date: "+book.getListed_date()+".");
				}
				System.out.println(" ");
				
				break;
			case 2:
				System.out.println("***** Book Search *****\n");
				
				System.out.println("Enter Book_ID");
				int bookId = sc.nextInt();
				 
				Book bk = bookService.searchBook(bookId); 
				if(bk == null) {
					System.out.println("Book ID does not exist. Returning to previous selection...");
					break;
				}
				System.out.println("Existing book for Book ID: "+bookId);
				System.out.println("Book Name: "+ bk.getBook_name()+", Available Copies: "+bk.getBook_copies()+ ", Book Status: "+bk.getBook_status()+", Listed date: "+bk.getListed_date()+".");
				 
				System.out.println("\n Would you like to add this book to cart?");
				System.out.println("1. Yes");
			    System.out.println("2. No");
				index = sc.nextInt();
				
				switch (index) {
				case 1:
					if (bk.getBook_copies() == 0) {
						System.out.println("Unavailable. Returning to previous selection...");
						break;
					}
					int copies = bk.getBook_copies()-1;
					if (copies == 0) {
						bk.setBook_status("Unavailable");
					}else {
						bk.setBook_status("Available");
					}
					bk.setBook_copies(copies);
					bookService.updateBook(bk);
					int userId = Integer.parseInt(service.getUserIdByUsername(userName));
					
					Cart crt = cartService.searchCart(bookId, userId);
					if(crt == null) {
						crt = new Cart();
						crt.setUser_id(userId);
						crt.setBook_id(bookId);
						crt.setBook_copies(1);
						cartService.insertCart(crt);
						System.out.println("Book added to cart.");
						break;
					}
					int cartCopies = crt.getBook_copies()+1;
					crt.setBook_copies(cartCopies);
					cartService.updateCart(crt);
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
				System.out.println("***** Checkout Book *****\n");
				System.out.println("Here is what's in your cart\n");
				int userId = Integer.parseInt(service.getUserIdByUsername(userName));
				List<Cart> cartList = cartService.showAllCart(userId);
				
				for (Cart cart : cartList) {
					
					System.out.println("Cart ID: "+cart.getCart_id()+", Book ID: "+cart.getBook_id()+", Book Name: "+ bookService.getBookNameById(cart.getBook_id())+", Book Copies: "+cart.getBook_copies()+".");
				}
				System.out.println(" ");
				
				break;
			default:
				break;
			}
		}
	}
}
