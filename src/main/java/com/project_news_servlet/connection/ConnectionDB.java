package com.project_news_servlet.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	public static Connection getConnection(String jdbcDriver, String hostName, String dbName, String username, String password) {
		
		String connectionURL = hostName + dbName;
		try {
			Class.forName(jdbcDriver);
			
			return DriverManager.getConnection(connectionURL, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			
			return null;
		}
	}
}
