package com.clearvision.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.clearvision.model.User;

public class UserDaoImpl implements UserDao {
	public int rowsChanged;
	private String statementString;

	public UserDaoImpl() {
	}

	@Override
	public void addUserToDb(User user) {
		statementString = "Insert into Users (FirstName, LastName, Email, Pass) Values (?,?,?,?)";
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
	}

	@Override
	public void deleteUserFromDb(String email) {
		statementString = "Delete from Users where email = ?";
		try {
			DatabaseConnection connector = new DatabaseConnection();
			Connection con = connector.connectToDB();

			PreparedStatement deleteUserFromUserTable = con.prepareStatement(statementString);
			deleteUserFromUserTable.setString(1, email);
			rowsChanged = deleteUserFromUserTable.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public boolean checkIfUserExistsInDb(String email) {
		User userInfo = new User();

		statementString = "SELECT * FROM Users Where email = ?";

		try {
			DatabaseConnection connector = new DatabaseConnection();
			Connection con = connector.connectToDB();

			PreparedStatement getUserFromUserTable = con.prepareStatement(statementString);
			getUserFromUserTable.setString(1, email);
			ResultSet userResults = getUserFromUserTable.executeQuery();
            return userResults.next();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User getUserFromDb(String email) {
		User userInfo = new User();

		statementString = "SELECT * FROM Users Where email = ?";

		try {
			DatabaseConnection connector = new DatabaseConnection();
			Connection con = connector.connectToDB();

			PreparedStatement getUserFromUserTable = con.prepareStatement(statementString);
			getUserFromUserTable.setString(1, email);
			ResultSet userResults = getUserFromUserTable.executeQuery();

			while (userResults.next()) {
				int userId = userResults.getInt(1);
				email = userResults.getString(2);
				String pass = userResults.getString(3);
				String firstName = userResults.getString(4);
				String lastName = userResults.getString(5);

				userInfo.setUserID(userId);
				userInfo.setEmail(email);
				userInfo.setPass(pass);
				userInfo.setFirstName(firstName);
				userInfo.setLastName(lastName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userInfo;
	}

	@Override
	public void updateUserInDb(String userData) {
		try{
			DatabaseConnection connector = new DatabaseConnection();
			Connection con = connector.connectToDB();
			statementString = "Update User set = " + userData +"  where where userId = ?";
			PreparedStatement updateUserInUserTable = con.prepareStatement(statementString);
			switch (userData) {
				case "firstName" : {
					updateUserInUserTable.setString(1, "firstName");
					break;
				}
				case "lastName" : {
					updateUserInUserTable.setString(1, "lastName");
					break;
				}
				case "email" : {
					updateUserInUserTable.setString(1, "email");
					break;
				}
				case "pass" : {
					updateUserInUserTable.setString(1, "pass");
					break;
				}
			}		
			rowsChanged = updateUserInUserTable.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
