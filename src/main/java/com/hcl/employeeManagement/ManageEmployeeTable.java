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
import java.util.List;
import java.util.stream.Collectors;

public class ManageEmployeeTable {
	
	private static final String selectAllSQL = "SELECT * FROM employees;";
	private static final String insertEmployeeSQL = "INSERT INTO employees (EmpName, DOB, age, salary) VALUES (?, ?, ?, ?)";
	private static final String selectIDSQL = "SELECT * FROM employees WHERE EmpID = ?";
	private static final String selectNameSQL = "SELECT * FROM employees WHERE EmpName = ?";
	private static final String updateEmployeeNameSQL = "update employees set EmpName = ? where EmpID = ?;";
	private static final String updateEmployeeSalarySQL = "update employees set salary = ? where EmpID = ?;";
	private static final String deleteEmployeeSQL = "DELETE FROM employees WHERE EmpID = ?";
	
	public static ArrayList<Employee> selectAllEmployees(){
		ArrayList<Employee> list = new ArrayList<>();
		try (Connection connection = JDBCUtils.getConnection();
			Statement statement = connection.createStatement(); 
			ResultSet rs = statement.executeQuery(selectAllSQL); ) {
				while(rs.next()) {
					int id = rs.getInt("EmpID");
					String name = rs.getString("EmpName");
					String dob = rs.getDate("dob").toString();
					float salary = rs.getFloat("salary");
					list.add(new Employee(id, name, dob, salary));
				}
				
	        } catch (SQLException e) {
	        	JDBCUtils.printSQLException(e);
	        }
		App.log.debug("All Employees Selected");
		return list;
	}
	
	public static int insertEmployee(Employee emp){
		try(Connection connection = JDBCUtils.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(insertEmployeeSQL); ){
				preparedStatement.setString(1, emp.getEmpName());
				preparedStatement.setDate(2, Date.valueOf(emp.getDob()));
				preparedStatement.setInt(3, emp.getAge());
				preparedStatement.setDouble(4, emp.getSalary());
				preparedStatement.executeUpdate();
		} catch(SQLException e) {
			JDBCUtils.printSQLException(e);
			return -1;
		}
		return 0;
	}
	
	public static ArrayList<Employee> selectEmployeeID(int empID){
		ArrayList<Employee> list = new ArrayList<>();
		try (Connection connection = JDBCUtils.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(selectIDSQL); ){
				preparedStatement.setInt(1, empID);
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next()) {
					int id = rs.getInt("EmpID");
					String empName = rs.getString("EmpName");
					String dob = rs.getDate("dob").toString();
					float salary = rs.getFloat("salary");
					list.add(new Employee(id, empName, dob, salary));
				}
		} catch(SQLException e) {
			JDBCUtils.printSQLException(e);
		}
		return list;
	}
	
	public static ArrayList<Employee> selectEmployeeName(String empName){
		ArrayList<Employee> list = new ArrayList<>();
		try (Connection connection = JDBCUtils.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(selectNameSQL); ){
				preparedStatement.setString(1, empName);
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next()) {
					int id = rs.getInt("EmpID");
					String name = rs.getString("EmpName");
					String dob = rs.getDate("dob").toString();
					float salary = rs.getFloat("salary");
					list.add(new Employee(id, name, dob, salary));
				}
		} catch(SQLException e) {
			JDBCUtils.printSQLException(e);
		}
		return list;
	}
	
	public static int updateEmployeeName(int empID, String newName){
		try (Connection connection = JDBCUtils.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(updateEmployeeNameSQL); ){
				preparedStatement.setString(1, newName);
				preparedStatement.setInt(2, empID);
				preparedStatement.executeUpdate();
		} catch(SQLException e) {
			JDBCUtils.printSQLException(e);
			return -1;
		}
		return 0;
	}
	
	public static int updateEmployeeSalary(int empID, float newSalary){
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(updateEmployeeSalarySQL); ){
					preparedStatement.setFloat(1, newSalary);
					preparedStatement.setInt(2, empID);
					preparedStatement.executeUpdate();
			} catch(SQLException e) {
				JDBCUtils.printSQLException(e);
				return -1;
			}
			return 0;
	}

	public static int deleteEmployee(int empID){
		try (Connection connection = JDBCUtils.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(deleteEmployeeSQL); ){
				preparedStatement.setInt(1, empID);
				preparedStatement.executeUpdate();
			} catch(SQLException e) {
				JDBCUtils.printSQLException(e);
				return -1;
			}
			return 0;
	}
	
	public static ArrayList<Employee> filterAllBySalary(float salary){
		ArrayList<Employee> list = selectAllEmployees();
		ArrayList<Employee> filteredList = list.stream()
				.filter(emp -> emp.getSalary() >= salary)
				.collect(Collectors.toCollection(ArrayList::new));
		return filteredList;
	}
	
	public static ArrayList<Employee> filterListBySalary(ArrayList<Employee> list, float salary){
		ArrayList<Employee> filteredList = list.stream()
				.filter(emp -> emp.getSalary() >= salary)
				.collect(Collectors.toCollection(ArrayList::new));
		return filteredList;
	}
}
