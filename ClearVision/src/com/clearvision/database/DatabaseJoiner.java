package com.clearvision.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseJoiner {
	int rowsChanged;

	DatabaseJoiner() {}

	public int joinUserAndBookmarkTables(String email) {

		String dropTableString = "Drop Table if exists UserBookmark";
		String statementString = "Create Table UserBookmark Select u.Email, b.BookmarkName, b.URL, b.Topic, b.BookmarkID From Users u Inner Join Bookmarks b On u.UserID = b.UserIDKey Where u.Email = '"+email+"'";

		try {
			DatabaseConnection connector = new DatabaseConnection();
			Connection con = connector.connectToDB();
			
			PreparedStatement dropTableIfExists = con.prepareStatement(dropTableString);
			rowsChanged += dropTableIfExists.executeUpdate();
			PreparedStatement joinTables = con.prepareStatement(statementString);
			rowsChanged += joinTables.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rowsChanged;
	}
	
	public int joinUserBookmarkAndTagTables() {
		String dropTableString = "Drop Table if exists UserBookmarkTag";
		String statementString = "Create Table UserBookmarkTag select ub.Email, ub.BookmarkName, ub.URL, ub.Topic, t.Tag from BookmarkTag bt inner join UserBookmark ub on bt.BookmarkID = b.BookmarkID inner join Tags t on bt.TagID = t.TagID";
		try {
			DatabaseConnection connector = new DatabaseConnection();
			Connection con = connector.connectToDB();
			
			PreparedStatement dropTableIfExists = con.prepareStatement(dropTableString);
			rowsChanged += dropTableIfExists.executeUpdate();
			PreparedStatement joinTables = con.prepareStatement(statementString);
			rowsChanged += joinTables.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowsChanged;
	}
}
