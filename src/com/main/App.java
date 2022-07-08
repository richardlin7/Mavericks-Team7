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
				default:
					System.out.println("Please Enter Valid Input!");	
				}
				break;
			case USER:
				System.out.println("*****USER SYSTEM******");
				System.out.println("1. Show Books");
				System.out.println("0. Log Out");
				input = sc.nextInt();
				if(input == 0) {
					System.out.println("Logging Out...");
					state = State.NOLOGIN;
					break;
				}
				switch(input) {
				case 1:
					System.out.println("Implement Stuff");
					break;
				default:
					System.out.println("Please Enter Valid Input!");	
				}
				break;
			case ADMIN:
				System.out.println("*****ADMIN SYSTEM******");
				System.out.println("1. Show Books");
				System.out.println("0. Log Out");
				input = sc.nextInt();
				if(input == 0) {
					System.out.println("Logging Out...");
					state = State.NOLOGIN;
					break;
				}
				switch(input) {
				case 1:
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
			/*System.out.println("*****DB OPS******");
			System.out.println("1. Log In User");
			System.out.println("2. Log In Admin");
			System.out.println("3. Delete Employee");
			System.out.println("4. Update Employee");
			System.out.println("5. Show All Vendors");
			System.out.println("0. Exit");
			System.out.println("Enter your input");
			int input = sc.nextInt();
			if(input == 0) {
				System.out.println("Exiting.... Bye!!");
				break;
			}
			switch(input) {
			case 1:
				System.out.println("Enter Employee Name");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.println("Enter Employee Salary");
				double salary = sc.nextDouble();
				System.out.println("Enter Employee City");
				String city = sc.next();
				System.out.println("Enter Dempartment Name");
				String departmentName = sc.next();
				
				employee.setName(name);
				employee.setSalary(salary);
				employee.setCity(city);
				employee.setDepartmentName(departmentName);
				db.insertEmployee(employee);
				System.out.println("Employee added to DB..");
				break;
			case 2:
				List<Employee> list = db.fetchEmployees();
				for(Employee e : list) {
					System.out.println(e);
				}
				break;
			case 3:
				System.out.println("Enter Employee ID");
				int id = sc.nextInt();
				boolean isValid = EmployeeUtility.validateId(db.fetchEmployees(),id);
				if(!isValid) {
					System.out.println("Invalid ID, Try Again");
					break;
				}
				db.deleteEmployee(id);
				System.out.println("Employee Deleted from DB...");
				break;
			case 4:
				System.out.println("Enter Employee ID");
				id = sc.nextInt();
				isValid = EmployeeUtility.validateId(db.fetchEmployees(), id);
				if(!isValid) {
					System.out.println("Invalid ID, Try Again!");
					break;
				}
				Employee emp = db.fetchEmployee(id);
				System.out.println("Existing Record of ID: "+id);
				System.out.println(emp);
				System.out.println("Enter Employee Name to Update");
				sc.nextLine();
				name = sc.nextLine();
				System.out.println("Enter Employee Salary");
				salary = sc.nextDouble();
				System.out.println("Enter Employee City");
				city = sc.next();
				System.out.println("Enter Department Name");
				departmentName = sc.next();
				employee.setId(id);
				employee.setName(name);
				employee.setSalary(salary);
				employee.setCity(city);
				employee.setDepartmentName(departmentName);
				db.updateEmployee(employee);
				System.out.println("Employee Record Updated!!");
				break;
			case 5:
				List<Product> plist = db.fetchAllProductsWithVendor();
				for(Product p : plist) {
					System.out.println(p);
				}
			default:
				System.out.println("Please use valid Input");
				break;
			}
		}//*/
		
	}
}
