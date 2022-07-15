package com.bookstore.main.utility;

import java.util.List;
import java.util.Scanner;

import com.bookstore.main.model.Book;
import com.bookstore.main.model.Cart;
import com.bookstore.main.model.Checkout;
import com.bookstore.main.service.BookService;
import com.bookstore.main.service.UserService;
import com.bookstore.main.service.CartService;
import com.bookstore.main.service.CheckoutService;

public class UserUtility {

	Scanner sc = new Scanner(System.in);
	// Creating all the Class Objects
	//Creating userService Object
	UserService service = new UserService();
	BookService bookService = new BookService();
	CartService cartService = new CartService();
	CheckoutService checkoutService = new CheckoutService();
	Book book= new Book();
	Cart cart= new Cart();
	Checkout checkout= new Checkout();
	
	

	@SuppressWarnings("null")
	public void userMenu(String userName) {

		while (true) {

			System.out.println("*******User Menu*******");
			System.out.println("1. Show Books");
			System.out.println("2. Search Books");
			System.out.println("3. Checkout Books");
//			System.out.println("4. Checked Out Books");
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
					
					System.out.println("Book ID: " + bookService.getBookIdByName(book.getBook_name()) + ", Book Name: "+ book.getBook_name()+", Aviliable Copies: "+book.getBook_copies()+ ", Book Status: "+book.getBook_status()+", Listed date: "+book.getListed_date()+".");
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
				System.out.println("***** Checkout Books *****\n");
				System.out.println("Here is what's in your cart: \n");
				int userId = Integer.parseInt(service.getUserIdByUsername(userName));
//				if(cartService.isCartPresent(userId) == false) {
//					System.out.println("There's nothing in your cart! Returning to previous selection...\n");
//					break;
//				}
				List<Cart> cartList = cartService.showAllCart(userId);
				
				for (Cart cart : cartList) {
					System.out.println("Cart ID: "+cart.getCart_id()+", Book ID: "+cart.getBook_id()+", Book Name: "+ bookService.getBookNameById(cart.getBook_id())+", Book Copies: "+cart.getBook_copies()+".\n");
				}
				
//				System.out.println("Would you like to check these books out?");
//				System.out.println("1. Yes\n2. No");
//				index = sc.nextInt();
//				
//				Checkout chkout = new Checkout();
//				int chkBookID = 0;
//				int chkBookCopies = 0;
//				switch (index) {
//				case 1:
//					for (Cart cart : cartList) {
//						
//						chkout = new Checkout();
//						chkBookID = cart.getBook_id();
//						chkBookCopies = cart.getBook_copies();
//						chkout.setUser_id(userId);
//						chkout.setBook_id(chkBookID);
//						chkout.setBook_copies(chkBookCopies);
//						checkoutService.insertCheckout(chkout);
//						cartService.removeCart(cart.getCart_id());
//					}
//					System.out.println("You have successfully checked out these books.\n");
//					break;
//				case 2:
//					System.out.println("Returning to previous selection...\n");
//					break;
//				default:
//					System.out.println("Invalid Input. Returning to previous selection...\n");
//					break;
//				}
				break;
//			case 4:
//				System.out.println("***** Checked Out Books *****\n");
//				System.out.println("Here is what you've checked out: \n");
//				userId = Integer.parseInt(service.getUserIdByUsername(userName));
//				
//				List<Checkout> checkoutList = checkoutService.showAllCheckout(userId);
////				if(checkoutService.isCheckoutPresent(userId) == false) {
////					System.out.println("There's nothing you've checked out! Returning to previous selection...\n");
////					break;
////				}
//				for (Checkout checkout : checkoutList) {
//					System.out.println("Checkout ID: "+checkout.getCheckout_id()+", Book ID: "+checkout.getBook_id()+", Book Name: "+ bookService.getBookNameById(checkout.getBook_id())+", Book Copies: "+checkout.getBook_copies()+".\n");
//				}
//				break;
			default:
				break;
			}
		}
	}
}
