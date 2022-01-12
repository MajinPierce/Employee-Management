package com.hcl.employeeManagement;
import java.time.*;

// want to change this to be serializable to remove any potential data loss
public class Employee {

		private int empID;
		private String empName;
		private LocalDate dob;
		private int age;
		private float salary;
		
		//initialize an emp that hasn't been given an ID in the database
		public Employee(String empName, String dob, float salary){
			this.empID = -1;
			this.empName = empName;
			this.dob = LocalDate.parse(dob);
			this.age = Period.between(this.dob, LocalDate.now()).getYears();
			this.salary = salary;
		}
		
		//initialize an emp that has been created in the database
		public Employee(int empID, String empName, String dob, float salary){
			this.empID = empID;
			this.empName = empName;
			this.dob = LocalDate.parse(dob);
			this.age = Period.between(this.dob, LocalDate.now()).getYears();
			this.salary = salary;
		}

		public int getEmpID() {
			return empID;
		}

		public void setEmpID(int empID) {
			this.empID = empID;
		}

		//calculate and return age based on DOB
		public int getAge() {
			int tempAge = Period.between(this.dob, LocalDate.now()).getYears();
			if(this.age < tempAge) {
				this.setAge(tempAge);
			}
			return this.age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public float getSalary() {
			return this.salary;
		}

		public void setSalary(float salary) {
			this.salary = salary;
		}

		public void setEmpName(String empName) {
			this.empName = empName;
		}

		public void setDob(LocalDate dob) {
			this.dob = dob;
		}

		public String getEmpName() {
			return this.empName;
		}

		public String getDob() {
			return this.dob.toString();
		}

		@Override
		public String toString() {
			return "Employee [ empID=" + this.empID +
					", empName=" + this.empName + 
					", dob=" + this.dob + 
					", age=" + this.getAge() + 
					", salary="	+ this.salary + " ]";
		}		
		
}
