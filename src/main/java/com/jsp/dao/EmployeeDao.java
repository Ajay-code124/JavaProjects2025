package com.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jsp.model.Employee;
import com.jsp.utility.Constants;
import com.jsp.utility.DbConnection;

public class EmployeeDao {

	public List<Employee> getAllEmployees()  {
		 List<Employee> employees = new ArrayList<Employee>();
		 
	 Connection connection;
	try {
		connection = DbConnection.getConnection();
		 PreparedStatement statement = connection.prepareStatement(Constants.GET_ALL_EMPLOYEES);
		 ResultSet resultset = statement.executeQuery();
		
		 while(resultset.next()) {
			  int empId = resultset.getInt(1);
			  String name=resultset.getString(2);
			 int age = resultset.getInt(3);
			String email= resultset.getString(4);
			String phone_number=resultset.getString(5);
			double salary= resultset.getDouble(6);
			
			Employee emp = new Employee(empId,name, age, email, phone_number, salary);
			employees.add(emp);
	} 
	}
		 catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();

	
		  }
	 return  employees;
	}

	public void addEmployee(Employee employee) {
		
		try {
			Connection connection = DbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(Constants.INSERT_EMPLOYEES);
			statement.setString(1, employee.getName());
			statement.setInt(2, employee.getAge());
			statement.setString(3, employee.getEmail());
			statement.setString(4, employee.getPhone_number());
			statement.setDouble(5, employee.getSalary());
			statement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public void deleteEmployee(int id) {
		
		try {
			Connection connection = DbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(Constants.DELETE_QUERY);
		    statement.setInt(1,id);
			statement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public Employee getEmployee(int empId) throws ClassNotFoundException, SQLException {
		
		Connection connection = DbConnection.getConnection();
		
		PreparedStatement statement = connection.prepareStatement(Constants.GET_EMPLOYEE);
	   statement.setInt(1, empId);
		ResultSet resultset = statement.executeQuery();
	  Employee emp = null;
	   while(resultset.next()) {
			  
			  String name=resultset.getString(2);
			 int age = resultset.getInt(3);
			String email= resultset.getString(4);
			String phone_number=resultset.getString(5);
			double salary= resultset.getDouble(6);
			
			 emp = new Employee(empId,name, age, email, phone_number, salary);
	   
	}
	   return emp;
}
	
	public void updateEmployee(Employee employee) throws ClassNotFoundException, SQLException {
		
		Connection connection = DbConnection.getConnection();
	 
	     PreparedStatement statement = connection.prepareStatement(Constants.UPDATE_EMPLOYEE);
	     statement.setString(1, employee.getName());
			statement.setInt(2, employee.getAge());
			statement.setString(3, employee.getEmail());
			statement.setString(4, employee.getPhone_number());
			statement.setDouble(5, employee.getSalary());
			statement.setInt(6, employee.getEmpid());
			statement.executeUpdate();
	    
	 }
}
