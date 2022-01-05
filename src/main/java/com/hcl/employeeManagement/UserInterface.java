package com.hcl.employeeManagement;

import java.util.Scanner;

public class UserInterface {

		public static void startApp() {
			Scanner sc = new Scanner(System.in);
			System.out.println("1. Select all employees");
			System.out.println("2. Select employee by ID");
			System.out.println("3. Search employee by Name");
			System.out.println("4. Insert new employee");
			System.out.println("5. Update existing employee name");
			System.out.println("6. Update existing employee salary");
			System.out.println("7. Delete employee");
			System.out.println("8. Filter employees by salary");
			System.out.println("9. Quit");
			int choice = sc.nextInt();
			
			sc.close();
		}
}
