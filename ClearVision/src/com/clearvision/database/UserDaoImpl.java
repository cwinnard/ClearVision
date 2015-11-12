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
		statementString = "Insert into User (FirstName, LastName, Email, Pass) Values (?,?,?,?)";
		try {
			ConnectToDb connector = new ConnectToDb();
			Connection con = connector.connectDb();

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
		statementString = "Delete from User where email = ?";
		try {
			ConnectToDb connector = new ConnectToDb();
			Connection con = connector.connectDb();

			PreparedStatement deleteUserFromUserTable = con.prepareStatement(statementString);
			deleteUserFromUserTable.setString(1, email);
			rowsChanged = deleteUserFromUserTable.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User getUserFromDb(String email) {
		User userInfo = new User();

		statementString = "SELECT * FROM User Where email And pass = (?,?)";
		
		try {
			ConnectToDb connector = new ConnectToDb();
			Connection con = connector.connectDb();
			PreparedStatement getUserFromUserTable = con.prepareStatement(statementString);
			ResultSet userResults = getUserFromUserTable.executeQuery();
			
			int userId = userResults.getInt(1);
			String firstName = userResults.getString(2);
			String lastName = userResults.getString(3);
				   email = userResults.getString(4);
			String pass = userResults.getString(5);
			rowsChanged = getUserFromUserTable.executeUpdate();
			userInfo.setFirstName(firstName);
			userInfo.setLastName(lastName);
			userInfo.setEmail(email);
			userInfo.setPass(pass);
			userInfo.setUserID(userId);
			
		}catch (SQLException e) {
			e.printStackTrace();
		} return userInfo;
	}

	@Override
	public void updateUserInDb(int userId) {
//		try{
//			ConnectToDb connector = new ConnectToDb();
//			Connection con = connector.connectDb();
//			statementString = "update User set firstName where userId = ?";
//			PreparedStatement updateUserFromUserTable = con.prepareStatement(statementString);
//			List userInfo = getUserFromDb(userId);
//			if(firstName !=""){
//				statementString = "update User set firstName where userId = ?";
//				
//				}
//
//			 if(lastName !=""){
//
//				
//				}
//			 if(email !=""){
//
//					
//				}
//			 if(pass !=""){
//
//					
//				}
//
//				
//			
//			rowsChanged = updateUserFromUserTable.executeUpdate();
//
//		}catch (SQLException e) {
//			e.printStackTrace();
//		}

	}

}
