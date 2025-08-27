package com.Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	public static Connection connection = null;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		if (connection==null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(Constant.URL, Constant.username, Constant.password);
		}
		return connection ;
	}

}
