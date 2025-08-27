package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Utility.Constant;
import com.Utility.DbConnection;
import com.model.Admin;

public class AdminDao {

	  public void saveAdmin(Admin admin) throws ClassNotFoundException, SQLException{
		
		
		Connection connection;
		
		      connection= DbConnection.getConnection();
		    		  
		   PreparedStatement statement = connection.prepareStatement(Constant.adminInsert);
		   statement.setString(1, admin.getEmail());
		   statement.setString(2, admin.getPassword());
		   
		  statement.execute();
		   
	}

	public boolean adminValid(Admin admin) throws ClassNotFoundException, SQLException {
		
		
		Connection connection;
		
	      connection= DbConnection.getConnection();
	    		  
	   PreparedStatement ps = connection.prepareStatement(Constant.getAdmin);
	 ps.setString(1,admin.getEmail());
		ps.setString(2,admin.getPassword());
		ResultSet executeQuery =ps.executeQuery();
		
		String email= null;
		String password=null;
		while(executeQuery.next()) {
			
			email= executeQuery.getString(1);
			password= executeQuery.getString(2);
			
		}
	
		return (admin.getEmail().equals(email) && admin.getPassword().equals(password));
		}
	   
	}

