package com.hcl.employeeManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtilsl {

	private static String jdbcURL = "jdbc:mysql://localhost:3306/test?useSSL=false";
	private static String jdbcUsername = "root";
	private static String jdbcPassword = "d!aPxMQh4M5B";

	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
}
