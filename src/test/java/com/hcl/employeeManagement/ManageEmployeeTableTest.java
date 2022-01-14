package com.hcl.employeeManagement;

import java.sql.Connection;
import java.sql.Statement;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ManageEmployeeTableTest {
	
	@InjectMocks private ManageEmployeeTable manage;
	@Mock private Connection mockConnection;
	@Mock private Statement mockStatement;
	
	@BeforeAll
	public void beforeTest() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void testSelectAllEmployees() {
		
	}
}
