package com.hcl.employeeManagement;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		/*
		 * Employee e1 = new Employee("Pierce", "1996-05-07", 58000.00f); Employee e2 =
		 * new Employee("Dan", "2001-09-11", 20000.00f);
		 * 
		 * ManageEmployeeTable.insertEmployee(e1);
		 * ManageEmployeeTable.insertEmployee(e2);
		 */
		
    	ArrayList<Employee> list = ManageEmployeeTable.selectAllEmployees();
    	list.forEach( (emp) -> { System.out.println(emp); } );
        
    }
}
