package com.jsp.utility;

public class Constants {

	public static final String URL="jdbc:mysql://localhost:3306/webprojects";
	public final static String username="root";
	public final static String password="Ajay@1234";
	public final static String query = "INSERT INTO USERS VALUES(?,?)";
	public static final String GET_USER = "SELECT * FROM USERS WHERE email=?";
	public static final String GET_ALL_EMPLOYEES = "SELECT * FROM EMPLOYEES";
	public static final String INSERT_EMPLOYEES = "INSERT INTO EMPLOYEES(name, age,email,phone_number,salary) VALUES(?,?,?,?,?)";
	public static final String DELETE_QUERY = "DELETE FROM EMPLOYEES WHERE empId=?";
	public static final String GET_EMPLOYEE = "SELECT * FROM EMPLOYEES WHERE empId=?";
	public static final String UPDATE_EMPLOYEE = "UPDATE EMPLOYEES SET name=?, age=?, email=?, phone_number=?,salary=? WHERE empid=?";
}