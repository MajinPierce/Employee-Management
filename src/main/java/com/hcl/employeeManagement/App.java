package com.hcl.employeeManagement;

import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Hello world!
 *
 */
public class App 
{
	static Logger log = LogManager.getLogger(App.class);
    public static void main( String[] args )
    {
    	log.debug("Begin program execution");

		/*
		 * Employee e1 = new Employee("Pierce", "1996-05-07", 58000.00f); 
		 * Employee e2 = new Employee("Dan", "2001-09-11", 20000.00f);
		 * 
		 * ManageEmployeeTable.insertEmployee(e1);
		 * ManageEmployeeTable.insertEmployee(e2);
		 */
    	
    	//Employee e3 = new Employee("Paige", "1999-06-26", 37440.00f);
    	//ManageEmployeeTable.insertEmployee(e3);
		
    	//selectAll
    	ArrayList<Employee> list = ManageEmployeeTable.selectAllEmployees();
    	list.forEach( (emp) -> { System.out.println(emp); } );
    	
    	//select by employeeID
    	//ArrayList<Employee> list2 = ManageEmployeeTable.selectEmployeeID(3);
    	//list2.forEach( (emp) -> { System.out.println(emp); } );
        
    	//select by employee name
    	//ArrayList<Employee> list3 = ManageEmployeeTable.selectEmployeeName("dan");
    	//list3.forEach( (emp) -> { System.out.println(emp); } );
    	
    	//update by name
    	//ManageEmployeeTable.updateEmployeeName(3, "Gabrielle");
    	
    	//update by name
    	//ManageEmployeeTable.updateEmployeeSalary(8, 45000.00f);
    	
    	//delete by ID
    	//ManageEmployeeTable.deleteEmployee(4);
    	log.debug("End program execution");
    }
}
