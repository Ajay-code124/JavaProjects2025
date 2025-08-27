package com.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jsp.model.User;
import com.jsp.utility.Constants;
import com.jsp.utility.DbConnection;

public class UserDao {

	public void saveUser(User user)  {
		
		Connection connection;
		try{
			connection=DbConnection.getConnection();
		
		
		PreparedStatement statement = connection.prepareStatement(Constants.query);
		statement.setString(1,user.getEmail());
		statement.setString(2, user.getPassword());
		
		statement.executeUpdate();
	}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

}
	public boolean validateUser(User user) throws ClassNotFoundException, SQLException {
	
	Connection connection =	DbConnection.getConnection();
	PreparedStatement statement = connection.prepareStatement(Constants.GET_USER);
	statement.setString(1, user.getEmail());
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