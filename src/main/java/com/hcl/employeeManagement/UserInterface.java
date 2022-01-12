package com.hcl.employeeManagement;

import java.util.Scanner;

public class UserInterface {
	
		private static Scanner sc = new Scanner(System.in);

		public static void startApp() {
			showMainMenu();
		}
		
		//main menu where all other sub menus originate
		//each option leads to another menu where additional actions can be taken
		static void showMainMenu() {
			int option = 0;
			
			while(option != 5) {
				System.out.println("Employee Management System\n");
				System.out.println("1. SELECT");
				System.out.println("2. INSERT");
				System.out.println("3. UPDATE");
				System.out.println("4. DELETE");
				System.out.println("5. Quit");
				
				option = sc.nextInt();
				System.out.println();
				
				switch (option) {
			        case 1:
			        	showSelectMenu();
			            break;
			        case 2:
			        	showInsertMenu();
			            break;
			        case 3:
			        	showUpdateMenu();
			            break;
			        case 4:
			        	showDeleteMenu();
			        	break;
			        case 5:
			        	System.out.println("Quitting program...\n");
			        	break;
			        default:
			            System.out.println("Sorry, please enter valid option");
				}   
			}
			sc.close();
		}
		
		//allows user to select all employees or specifically by ID, name, salary, age
		static void showSelectMenu() {
			int option = 0;
			
			while(option != 5) {
				System.out.println("SELECT\n");
				System.out.println("1. Select all");
				System.out.println("2. Select by employee ID");
				System.out.println("3. Select by name");
				System.out.println("4. Filter");
				System.out.println("5. Main menu");
				
				option = sc.nextInt();
				System.out.println();
				
				switch (option) {
			        case 1:
			        	//retrieves and prints all employees in the database
			        	ManageEmployeeTable.selectAllEmployees()
			        		.forEach( (emp) -> { System.out.println(emp); } );
			        	System.out.println();
			            break;
			        case 2:
			        	//retrieves and prints employee with specific ID
			        	//*want to print message if no one was found*
			        	System.out.print("Please enter employee ID: ");
			        	ManageEmployeeTable.selectEmployeeID(sc.nextInt())
			        		.forEach( (emp) -> { System.out.println(emp); } );
			        	System.out.println();
			            break;
			        case 3:
			        	//retrieves and prints all employees that have a specific name
			        	System.out.print("Please enter employee name: ");
			        	ManageEmployeeTable.selectEmployeeName(sc.next())
			        		.forEach( (emp) -> { System.out.println(emp); } );
			        	System.out.println();
			        	sc.nextLine();
			            break;
			        case 4:
			        	// additional sub menu to filter employees above a certain salary or age
			        	showFilterMenu();
			        	option = 5;
			        	break;
			        case 5:
			        	System.out.println();
			        	break;
			        default:
			            System.out.println("Sorry, please enter valid option");
				}
			}
		}
		
		//allows user to filter through all employees based on a salary or age
		static void showFilterMenu(){
			int option = 0;
			
			while(option != 3) {
				System.out.println("FILTER\n");
				System.out.println("1. Filter by salary");
				System.out.println("2. Filter by age");
				System.out.println("3. Main menu");
				
				option = sc.nextInt();
				System.out.println();
				
				switch (option) {
			        case 1:
			        	//filters employees by user-provided salary and prints the resulting list
			        	System.out.print("Please enter salary to filter by: ");
			        	ManageEmployeeTable.filterAllBySalary(sc.nextFloat())
			        		.forEach( (emp) -> { System.out.println(emp); } );
			        	System.out.println();
			            break;
			        case 2:
			        	//filters employees by user-provided age and prints the resulting list
			        	System.out.print("Please enter age to filter by: ");
			        	ManageEmployeeTable.filterAllByAge(sc.nextInt())
			        		.forEach( (emp) -> { System.out.println(emp); } );
			        	System.out.println();
			            break;
			        case 3:
			            break;
			        default:
			            System.out.println("Sorry, please enter valid option");
				}
			}
		}
		
		//prompts user for name, dob, salary to insert a new employee
		static void showInsertMenu() {
			System.out.println("INSERT\n");
			System.out.println("Please enter employee information or 'quit' to quit:");
			System.out.println("Name: ");
			String name = sc.next();
			//exits insertion process and goes back to main menu if
			//the user entered 'quit', otherwise continues
			if(name.equals("quit")) {
				System.out.println();
			} else {
				sc.nextLine();
				System.out.println("Date of birth (yyyy-mm-dd): ");
				String dob = sc.next();
				sc.nextLine();
				System.out.println("Salary: ");
				float salary = sc.nextFloat();
				ManageEmployeeTable.insertEmployee(new Employee(name, dob, salary));
	        	System.out.println("New employee inserted");
	        	System.out.println();
			}
		}
		
		// displays and runs menu to update an existing employee
		static void showUpdateMenu() {
			int option = 0;
			
			while(option != 3) {
				System.out.println("UPDATE\n");
				System.out.println("1. Update emplyee name");
				System.out.println("2. Update emplyee salary");
				System.out.println("3. Main menu");
				
				option = sc.nextInt();
				System.out.println();
				
				switch (option) {
			        case 1:
			        	//updates employee's name specified by EmpID
			        	System.out.println("Update employee name");
			        	System.out.print("Employee ID: ");
			        	int IDn = sc.nextInt();
			        	System.out.print("New name: ");
			        	String newName = sc.next();
			        	sc.nextLine();
			        	System.out.println();
			        	ManageEmployeeTable.updateEmployeeName(IDn, newName);
			        	System.out.println("Updated employee " + IDn);
			        	System.out.println();
			            break;
			        case 2:
			        	//updates employee's name specified by EmpID
			        	System.out.println("Update employee salary");
			        	System.out.print("Employee ID: ");
			        	int IDs = sc.nextInt();
			        	System.out.print("New salary: ");
			        	Float newSalary = sc.nextFloat();
			        	System.out.println();
			        	ManageEmployeeTable.updateEmployeeSalary(IDs, newSalary);
			        	System.out.println("Updated employee " + IDs);
			        	System.out.println();
			            break;
			        case 3:
			            break;
			        default:
			            System.out.println("Sorry, please enter valid option");
				}
			}
		}
		
		//deletes a user based on the provided employee ID
		static void showDeleteMenu() {
			System.out.println("DELETE\n");
			System.out.println("Please enter employee ID to delete.");
			System.out.println("Please note that this action is irreversible.");	
			System.out.println("Employee ID: ");
			int ID = sc.nextInt();
			ManageEmployeeTable.deleteEmployee(ID);
			System.out.println("Deleted employee " + ID);
			System.out.println();
		}
		
}
