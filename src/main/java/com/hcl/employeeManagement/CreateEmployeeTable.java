package com.hcl.employeeManagement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.hcl.employeeManagement.JDBCUtils;

public class CreateEmployeeTable {
	
	String createTableSql = "CREATE TABLE IF NOT EXISTS employees" 
			  + "(EmpID int PRIMARY KEY AUTO_INCREMENT, EmpName varchar(255),"
			  + "DOB date, age smallint, salary double)";

	public static void main(String[] argv) throws SQLException {
		CreateEmployeeTable createTableExample = new CreateEmployeeTable();
        createTableExample.createTable();
    }

    public void createTable() throws SQLException {

        System.out.println(createTableSql);
        // Step 1: Establishing a Connection
        try (Connection connection = JDBCUtils.getConnection();
            // Step 2:Create a statement using connection object
            Statement statement = connection.createStatement();) {

            // Step 3: Execute the query or update query
            statement.execute(createTableSql);
        } catch (SQLException e) {

            // print SQL exception information
        	JDBCUtils.printSQLException(e);
        }

        // Step 4: try-with-resource statement will auto close the connection.
    }

}
