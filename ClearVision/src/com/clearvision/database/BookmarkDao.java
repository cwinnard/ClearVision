package com.clearvision.database;

import java.util.List;

import com.clearvision.model.Bookmark;

interface BookmarkDao {
	public Bookmark getBkMarkFromDb(String name);
	public void updateBkMarkInDb(int userId);
	public void deleteBkMarkFromDb(Bookmark bookmark);
	public void addBkMarkToDb(Bookmark bookmark);
	public void saveBookmarksToDB(List<Bookmark> bookmarks); 
}
