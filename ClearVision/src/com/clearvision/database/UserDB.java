package com.clearvision.database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.clearvision.model.User;

public class UserDB {
	int rowsChanged;
	
	public UserDB() {}
	
	public int addUserToDatabase(User user) {
		
		String statementString = "Insert into User (FirstName, LastName, Email, Pass) Values (?,?,?,?)";
		
		try {
			DatabaseConnection connector = new DatabaseConnection();
			Connection con = connector.connectToDB();
			
			PreparedStatement addUserToUserTable = con.prepareStatement(statementString);
			addUserToUserTable.setString(1, user.getFirstName());
			addUserToUserTable.setString(2, user.getLastName());
			addUserToUserTable.setString(3, user.getEmail());
			addUserToUserTable.setString(4, user.getPass());
			rowsChanged = addUserToUserTable.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowsChanged;
	}
	
	public int deleteUserFromDatabase(String email) {
		
		String statementString = "Delete from User where email = ?";
		try {
			DatabaseConnection connector = new DatabaseConnection();
			Connection con = connector.connectToDB();
			
			PreparedStatement deleteUserFromUserTable = con.prepareStatement(statementString);
			deleteUserFromUserTable.setString(1, email);
			rowsChanged = deleteUserFromUserTable.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowsChanged;
	}
}
