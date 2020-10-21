package com.studentapp.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static Connection conn;
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/practice_db","root","Password@123");
		} catch (SQLException | ClassNotFoundException e) {
			e.getMessage();
		} 
	}

	public static Connection getConnection()
	{
		return conn;
	}
}
