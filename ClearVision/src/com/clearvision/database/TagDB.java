  package com.clearvision.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TagDB {
	int rowsChanged;
	String statementString;
	
	public void addTagsToDB(String[] tags) {
		statementString = "Insert Ignore into Tags (Tag) Values (?)";
		
		try {
			DatabaseConnection connector = new DatabaseConnection();
			Connection con = connector.connectToDB();
			
			for (String tag : tags) {
				PreparedStatement addTagToDB = con.prepareStatement(statementString);
				addTagToDB.setString(1, tag);
				rowsChanged += addTagToDB.executeUpdate();	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int returnTagIDWhenGivenTagName(String tagName) {
		int tagID = 0;
		statementString = "select * from Tags where Tag = ?";
		
		try {
			DatabaseConnection connector = new DatabaseConnection();
			Connection con = connector.connectToDB();

			PreparedStatement getBookmardID = con.prepareStatement(statementString);
			getBookmardID.setString(1, tagName);
			ResultSet tagIDResults = getBookmardID.executeQuery();
			
			while (tagIDResults.next()){
				tagID = tagIDResults.getInt(1);
			}
			 		
		}catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return tagID;
	}	
}
