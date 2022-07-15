package com.bookstore.main.utility;

import java.util.List;
import java.util.Scanner;

import com.bookstore.main.model.Admin;
import com.bookstore.main.model.Book;
import com.bookstore.main.service.AdminService;
import com.bookstore.main.service.BookService;
import com.bookstore.main.service.UserService;
import com.bookstore.main.model.User;



public class AdminUtility {

	public void adminMenu(String adminUserName) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		BookService bookService = new BookService();
		AdminService service = new AdminService();
		UserService userService = new UserService();

		while (true) {

			System.out.println("*******Admin Menu*******");
			System.out.println("1. Add Book");
			System.out.println("2. Remove Book");
			System.out.println("3. Update Book");
			System.out.println("4. View Users");
			System.out.println("5. Delete User");
			System.out.println("6. Show Books");
			System.out.println("0. Log Out");

			System.out.println("Hi " + adminUserName.toUpperCase() + ", Please select the opreation: ");
			String index = sc.next();

			if (index.equals("0")) {
				System.out.println("Logging out... Returning to the menu.");
				break;
			}

			switch (index) {
			case "1":
				System.out.println("***** Add Book *****");

				System.out.println("Enter Book Name: ");
				sc.nextLine();
				String bookName = sc.nextLine();
				System.out.println("Enter the book copies: ");
				int bookCopies = sc.nextInt();
				System.out.println("Enter the cost: ");
				double bookCost = sc.nextDouble();
				System.out.println("Book Status Available/Unavailable: ");
				String bookStatus = sc.next();

				System.out.println("Book Listed Date: ");
				String date = sc.next();

				System.out.println("Enter Author First Name: ");
				String authFirstName = sc.next();
				System.out.println("Enter Author Last Name: ");
				String authLastName = sc.next();

				
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
				sc.nextLine();
				String libName = sc.nextLine();


				int libraryId;
				// Checking weather Library is present in database
				boolean isLibraryValid = service.isLibraryIdPresent(libName);

				if (isLibraryValid == true) {
					libraryId = service.getLibraryId(libName);
				} else {
					System.out.println("Enter Library phone: ");
					String phone = sc.next();
					service.insertLibrary(libName, phone);
				}
				libraryId = service.getLibraryId(libName);
				
				System.out.println("*****List of all the Admin*****");
				System.out.println(" ");
				
				List<Admin> list = service.getAllAdminDetails();
				
				//Stream implement
				list.stream().forEach(a->System.out.println(a));
				
				System.out.println(" ");
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
			case "2":
				System.out.println("*****Delete Book*****");
				System.out.println("List of all Available Books");
				
				List<Book> bookList = bookService.showAllBooks();
				bookList.stream().forEach(b->System.out.println(b));
				
				System.out.println("Enter ID of Book to remove:");
				int bid = sc.nextInt();
				Book books = bookService.searchBook(bid);
				if(books == null) {
					System.out.println("Please Enter Valid Book ID");
					break;
				}
				bookService.removeBook(bid);
				System.out.println(" The book " + books.getBook_name() + " deleted Successfully!!!");
				break;
			case "3":
				System.out.println("*****Update Book*****");
				
				System.out.println("List of all Available Books");
				
				bookList = bookService.showAllBooks();
				bookList.stream().forEach(b->System.out.println(b));
				
				System.out.println("Enter ID of Book to update:");
				bid = sc.nextInt();
				books = bookService.searchBook(bid);
				if(books == null) {
					System.out.println("Please Enter Valid Book ID");
					break;
				}
				//TODO REMOVE IF NOT ALREADY FIXED
				books.setBook_id(bid);
				System.out.println("Current status:");
				System.out.println(books);
				System.out.println("\nUpdate Book Name:");
				sc.nextLine();
				books.setBook_name(sc.nextLine());
				System.out.println("Update Book Copies:");
				books.setBook_copies(sc.nextInt());
				System.out.println("Update Book Cost:");
				books.setBook_cost(sc.nextDouble());
				System.out.println("Update Book Status:");
				books.setBook_status(sc.next());
				System.out.println("Update Book Listed Date:");
				books.setListed_date(sc.next());
				//System.out.println("Update Book Author:");
				//book.setBook_name(sc.next());
				//System.out.println("TODO: Allow update Author categories and library and admins");
				
				bookService.updateBook(books);
				System.out.println(" The book " + books.getBook_name() + " updated Successfuly!!!");
				break;
			case "4":
				System.out.println("*****View Users*****");
				//To Do
				List<User> list1 = service.fetchUsers();
				 for(User e: list1) {
					 System.out.println(e);
				 }

				break;
			case "5":
				System.out.println("*****Delete User*****");
				//To Do
				System.out.println("Enter User ID");
				 int user_id = sc.nextInt();
				 
				 if(!userService.checkUserID(user_id)) {
					 System.out.println("User ID does not exist, please try again.");
				 }else {
					 service.deleteUser(user_id);
					 System.out.println("User Deleted from DB..");

				 }

				break;
			case "6":
				//To Do
				System.out.println("***** The Collections of Books *****");
				System.out.println(" ");
				
				// Showing all the books
				List<Book> list2 = bookService.showAllBooks();
				
				for (Book e : list2) {
					
					System.out.println("Book Name: "+ e.getBook_name()+", Aviliable Copies: "+e.getBook_copies()+ ", Book Status: "+e.getBook_status()+", Listed date: "+e.getListed_date()+".");
				}
				System.out.println(" ");
				

				break;

			default:
				break;
			}

		}
		// sc.close();

	}

}
