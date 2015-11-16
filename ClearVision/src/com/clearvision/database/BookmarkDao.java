package com.clearvision.database;

import java.util.ArrayList;
import java.util.List;

import com.clearvision.model.Bookmark;

interface BookmarkDao {
	public Bookmark getBkMarkFromDb(String name);
	public ArrayList<Bookmark> getBkMarkListFromDB();
	public void updateBkMarkInDb(String bookmarkName, String newTopic);
	public void deleteBkMarkFromDb(Bookmark bookmark);
	public void addBkMarkToDb(Bookmark bookmark);
	public void saveBookmarksToDB(List<Bookmark> bookmarks); 
	public int returnBoomarkIDWhenGivenBookmarkName(String bookmarkName);
}
