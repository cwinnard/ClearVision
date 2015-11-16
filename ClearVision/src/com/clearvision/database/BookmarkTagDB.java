package com.clearvision.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookmarkTagDB {
	int rowsChanged;
	String statementString;
	
	public void linkBookmarkAndTag(int bookmarkID, int tagID) {
		statementString = "Insert into BookmarkTag (BookmarkID, TagID) Values (?,?)";
		
		try {
			DatabaseConnection connector = new DatabaseConnection();
			Connection con = connector.connectToDB();
			
			PreparedStatement connectBookmarkAndTag = con.prepareStatement(statementString);
			connectBookmarkAndTag.setLong(1, bookmarkID);
			connectBookmarkAndTag.setLong(2, tagID);
			rowsChanged = connectBookmarkAndTag.executeUpdate();	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
