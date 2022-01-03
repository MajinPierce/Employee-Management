package com.hcl.employeeManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ManageEmployeeTable {
	
	String tableSql = "CREATE TABLE IF NOT EXISTS employees" 
			  + "(EmpID int PRIMARY KEY AUTO_INCREMENT, EmpName varchar(30),"
			  + "DOB date, salary double)";

	public static void main(String[] args) {

	}
	
	public static int createTable() {
		
		return 0;
	}
	
	public static String selectEmployee() {
		return "0";
	}
	
	public static String selectAllEmployees() {
		return "0";
	}
	
	public static int updateEmployee() {
		return 0;
	}

	public static int deleteEmployee() {
		return 0;
	}
}
