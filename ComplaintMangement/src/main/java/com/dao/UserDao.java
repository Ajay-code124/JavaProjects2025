package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Utility.Constant;
import com.Utility.DbConnection;
import com.model.User;

public class UserDao {

	public void saveUser(User user) {
		
		Connection connection;
		
		 try {
			connection=DbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(Constant.insert);
			statement.setString(1, user.getEmail());
			statement.setString(2, user.getPassword());
			
			statement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}

	public boolean validateUser(User user) throws SQLException, ClassNotFoundException {
		
		
		Connection connection;
		
		
			connection= DbConnection.getConnection();
		
		PreparedStatement statement = connection.prepareStatement(Constant.query1);
		statement.setString(1, user.getEmail());
		statement.setString(2, user.getPassword());
		ResultSet executeQuery = statement.executeQuery();
		String email=null;
		String password=null;
		
		while(executeQuery.next()) {
			
			 email = executeQuery.getString(1);
			 password = executeQuery.getString(2);
		}
		
		return (user.getEmail().equals(email) && user.getPassword().equals(password));
	}

	
}
