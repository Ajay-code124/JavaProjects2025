package com.Utility;

public class Constant {

	public static final String URL= "jdbc:mysql://localhost:3306/complaint";
	public static final String username="root";
	public static final String password="Ajay@1234";
	public static final String insert ="INSERT INTO users(email, password) VALUES (?, ?)";
	public static final String query1="SELECT * FROM users WHERE email=? AND password=?";
	public static final String InsertComp = "INSERT INTO complaints(user_email, title, description, status) VALUES (?, ?, ?, ?)";
	public static final String getComplaint="SELECT user_email, title, description, status FROM complaints WHERE user_email = ?";
	public static final String adminInsert="INSERT INTO ADMINS(email, password) VALUES (?,?);";
	public static final String getAdmin= "SELECT * FROM ADMINS WHERE email=? AND password=?";
	public static final String getAllComplaint="SELECT * FROM  COMPLAINTS";
	public static final String updateComplaints="UPDATE COMPLAINTS SET status=? WHERE id=?";
			
	public static final String deleteComplaints="DELETE FROM COMPLAINTS WHERE id=?";
}
