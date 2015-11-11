package com.clearvision.database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.clearvision.model.Bookmark;

public class BookmarkDB {
	int rowsChanged;
	
	public BookmarkDB() {}
	
	public int saveBookmarksToDB(List<Bookmark> bookmarks) {
		String statementString = "Insert into Bookmarks (Name, URL, UserIDLink) Values (?,?,?)";
		
		try {
			DatabaseConnection connector = new DatabaseConnection();
			Connection con = connector.connectToDB();
			
			PreparedStatement addBookmarksToBookmarkTable = con.prepareStatement(statementString);
			for (Bookmark bookmark : bookmarks) {
				addBookmarksToBookmarkTable.setString(1, bookmark.getName());
				addBookmarksToBookmarkTable.setString(2, bookmark.getUrl());
				addBookmarksToBookmarkTable.setString(3, "1");
			rowsChanged += addBookmarksToBookmarkTable.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowsChanged;
	}
	
	public int deleteBookmarkFromDB(Bookmark bookmark) {
		String statementString = "Delete from Bookmarks where URL = ?";
		
		try {
			DatabaseConnection connector = new DatabaseConnection();
			Connection con = connector.connectToDB();
			
			PreparedStatement deleteBookmarkFromBookmarkTable = con.prepareStatement(statementString);
			deleteBookmarkFromBookmarkTable.setString(1, bookmark.getUrl());
			rowsChanged = deleteBookmarkFromBookmarkTable.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowsChanged;
		
	}
}

