package com.clearvision.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.clearvision.model.Bookmark;

public class BkmarkDaoImpl implements BookmarkDao {
	int rowsChanged;
	private String statementString;
	
	public BkmarkDaoImpl() {
	}
	
	@Override
	public void saveBookmarksToDB(List<Bookmark> bookmarks) {
		 statementString = "Insert into Bookmarks (BookmarkName, URL, Topic, UserIDLink) Values (?,?,?,?)";
		 
		try {
			DatabaseConnection connector = new DatabaseConnection();
			Connection con = connector.connectToDB();
			
			PreparedStatement addBookmarksToBookmarkTable = con.prepareStatement(statementString);
			for (Bookmark bookmark : bookmarks) {
				addBookmarksToBookmarkTable.setString(1, bookmark.getName());
				addBookmarksToBookmarkTable.setString(2, bookmark.getUrl());
				addBookmarksToBookmarkTable.setString(3, "General");
				addBookmarksToBookmarkTable.setString(4, "1");
				rowsChanged = addBookmarksToBookmarkTable.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void addBkMarkToDb(Bookmark bookmark) {
		 statementString = "Insert into Bookmarks (BookmarkName, URL, Topic, UserIDLink) Values (?,?,?,?)";
		
		try {
			DatabaseConnection connector = new DatabaseConnection();
			Connection con = connector.connectToDB();

			PreparedStatement addBookmarkToBookmarkTable = con.prepareStatement(statementString);
			addBookmarkToBookmarkTable.setString(1, bookmark.getName());
			addBookmarkToBookmarkTable.setString(2, bookmark.getUrl());
			addBookmarkToBookmarkTable.setString(3, "General");
			addBookmarkToBookmarkTable.setString(4, "1");
			rowsChanged = addBookmarkToBookmarkTable.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void deleteBkMarkFromDb(Bookmark bookmark) {
		 statementString = "Delete from Bookmarks where URL = ?";
		
		try {
			DatabaseConnection connector = new DatabaseConnection();
			Connection con = connector.connectToDB();
			
			PreparedStatement deleteBookmarkFromBookmarkTable = con.prepareStatement(statementString);
			deleteBookmarkFromBookmarkTable.setString(1, bookmark.getUrl());
			rowsChanged = deleteBookmarkFromBookmarkTable.executeUpdate();		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Bookmark getBkMarkFromDb(String name) {
	
			Bookmark bookmarkInfo = new Bookmark();

			statementString = "SELECT * FROM Bookmarks Where BookmarkName = ?";
			
			try {
				DatabaseConnection connector = new DatabaseConnection();
				Connection con = connector.connectToDB();

				PreparedStatement getBkmkFromBkmkTable = con.prepareStatement(statementString);
				ResultSet bkmResults = getBkmkFromBkmkTable.executeQuery();
				
				String bkmkUrl = bkmResults.getString(1);
				String bkmkName = bkmResults.getString(2);
				String bkmkTopic = bkmResults.getString(3);
				 		
				rowsChanged = getBkmkFromBkmkTable.executeUpdate();
				bookmarkInfo.setName(bkmkName);
				bookmarkInfo.setUrl(bkmkUrl);
				bookmarkInfo.setTopic(bkmkTopic);
			
			}catch (SQLException e) {
				e.printStackTrace();
			} return bookmarkInfo;
		}
	@Override
	public void updateBkMarkInDb(String bookmarkName, String newTopic) {
		statementString = "Update Bookmarks set Topic = ? where BookmarkName = ?";
		
		try {
			DatabaseConnection connector = new DatabaseConnection();
			Connection con = connector.connectToDB();

			PreparedStatement updateBookmarkTopic = con.prepareStatement(statementString);
			updateBookmarkTopic.setString(1, newTopic);
			updateBookmarkTopic.setString(2, bookmarkName);
			rowsChanged = updateBookmarkTopic.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		} 
	}	
}

