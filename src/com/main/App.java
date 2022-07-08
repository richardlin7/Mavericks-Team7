package com.main;
import java.util.List;
import java.util.Scanner;
enum State {NOLOGIN, USER, ADMIN, QUIT};

public class App {
	public static void main(String[] args) {
		//DB db = new DB();
		//Employee employee = new Employee();
		Scanner sc = new Scanner(System.in);
		State state = State.NOLOGIN;
		while(state != State.QUIT) {
			switch(state) {
			case NOLOGIN:
				System.out.println("*****LIBRARY SYSTEM******");
				System.out.println("1. Log In User");
				System.out.println("2. Log In Admin");
				System.out.println("2. Create User Account");
				System.out.println("0. Exit");
				int input = sc.nextInt();
				if(input == 0) {
					System.out.println("Exiting.... Bye!!");
					state = State.QUIT;
					break;
				}
				switch(input) {
				case 1:
					System.out.println("Enter Username");
					sc.nextLine();
					String userName = sc.nextLine();
					//TODO: Login Logic
					//If Login Successful:
					state = State.USER;
					break;
				case 2:
					System.out.println("Enter Username");
					sc.nextLine();
					userName = sc.nextLine();
					//TODO: Login Logic
					//If Login Successful:
					state = State.ADMIN;
					break;
				case 3:
					System.out.println("*****ACCOUNT CREATION******");
					System.out.println("Enter Username");
					sc.nextLine();
					userName = sc.nextLine();
					//TODO: Login Logic
					//If Login Successful:
					state = State.USER;
					break;
				default:
					System.out.println("Please Enter Valid Input!");	
				}
				break;
			case USER:
				System.out.println("*****USER SYSTEM******");
				System.out.println("1. Show Books");
				System.out.println("2. Search Books");
				System.out.println("3. Checkout Book");
				System.out.println("0. Log Out");
				input = sc.nextInt();
				if(input == 0) {
					System.out.println("Logging Out...");
					state = State.NOLOGIN;
					break;
				}
				switch(input) {
				case 1:
					System.out.println("1. Show Books");
					System.out.println("Implement Stuff");
					break;
				case 2:
					System.out.println("2. Search Books");
					System.out.println("Implement Stuff");
					break;
				case 3:
					System.out.println("3. Checkout Book");
					System.out.println("Implement Stuff");
					break;
				default:
					System.out.println("Please Enter Valid Input!");	
				}
				break;
			case ADMIN:
				System.out.println("*****ADMIN SYSTEM******");
				System.out.println("1. Add Book");
				System.out.println("2. Remove Book");
				System.out.println("3. Update Book");
				System.out.println("4. View Users");
				System.out.println("5. Delete User");
				System.out.println("6. Create New Admin");
				System.out.println("0. Log Out");
				input = sc.nextInt();
				if(input == 0) {
					System.out.println("Logging Out...");
					state = State.NOLOGIN;
					break;
				}
				switch(input) {
				case 1:
					System.out.println("1. Add Book");
					System.out.println("Implement Stuff");
					break;
				case 2:
					System.out.println("2. Remove Book");
					System.out.println("Implement Stuff");
					break;
				case 3:
					System.out.println("3. Update Book");
					System.out.println("Implement Stuff");
					break;
				case 4:
					System.out.println("4. View Users");
					System.out.println("Implement Stuff");
					break;
				case 5:
					System.out.println("5. Delete User");
					System.out.println("Implement Stuff");
					break;
				case 6:
					System.out.println("6. Create New Admin");
					System.out.println("Implement Stuff");
					break;
					
				default:
					System.out.println("Please Enter Valid Input!");	
				}
				
			default:
				break;
			}
			
		}
		sc.close();
		
	}
}
