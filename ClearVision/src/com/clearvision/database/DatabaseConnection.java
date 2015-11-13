package com.clearvision.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	String driver = "com.mysql.jdbc.Driver";
	String connection = "jdbc:mysql://localhost:3306/BookmarkManager";
	String dbUser = "root";
	String password = "sesame";
	
	public DatabaseConnection () {}

	public Connection connectToDB() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(connection, dbUser, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
}
