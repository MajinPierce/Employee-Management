package com.hcl.employeeManagement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

public class ManageEmployeeTable {
	
	private static String selectAll = "SELECT * FROM employees;";
	private static String insertEmployee = "INSERT INTO employees (EmpName, DOB, age, salary) VALUES (?, ?, ?, ?)";
	
	public static ArrayList<Employee> selectAllEmployees(){
		ArrayList<Employee> list = new ArrayList<>();
		try (Connection connection = JDBCUtils.getConnection();
			Statement statement = connection.createStatement(); 
			ResultSet rs = statement.executeQuery(selectAll); ) {
				while(rs.next()) {
					int empID = rs.getInt("EmpID");
					String empName = rs.getString("EmpName");
					String dob = rs.getDate("dob").toString();
					float salary = rs.getFloat("salary");
					list.add(new Employee(empID, empName, dob, salary));
				}
				
	        } catch (SQLException e) {
	        	JDBCUtils.printSQLException(e);
	        }
		return list;
	}
	
	public static int insertEmployee(Employee emp){
		try(Connection connection = JDBCUtils.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(insertEmployee); ){
				preparedStatement.setString(1, emp.getEmpName());
				preparedStatement.setDate(2, Date.valueOf(emp.getDob()));
				preparedStatement.setInt(3, emp.getAge());
				preparedStatement.setDouble(4, emp.getSalary());
				int row = preparedStatement.executeUpdate();
	            System.out.println(row); //1
		} catch(SQLException e) {
			JDBCUtils.printSQLException(e);
			return -1;
		}
		return 0;
	}
	
	public String selectEmployee(){
		return "0";
	}
	
	public int updateEmployee(){
		return 0;
	}

	public int deleteEmployee(){
		return 0;
	}
	
	public int filterBySalary(){
		return 0;
	}
}
