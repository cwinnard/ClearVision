package com.clearvision.model;

public class Leaf {
	public String userEmail;
	public String bookmarkName;
	public String bookmarkURL;
	public String bookmarkTopic;
	public String tag;
	
	public Leaf () {}
	
	public Leaf (String userEmail, String bookmarkName, String bookmarkURL, String bookmarkTopic, String tag) {
		this.userEmail = userEmail;
		this.bookmarkName = bookmarkName;
		this.bookmarkURL = bookmarkURL;
		this.bookmarkTopic = bookmarkTopic;
		this.tag = tag;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getBookmarkName() {
		return bookmarkName;
	}

	public void setBookmarkName(String bookmarkName) {
		this.bookmarkName = bookmarkName;
	}

	public String getBookmarkURL() {
		return bookmarkURL;
	}

	public void setBookmarkURL(String bookmarkURL) {
		this.bookmarkURL = bookmarkURL;
	}

	public String getBookmarkTopic() {
		return bookmarkTopic;
	}

	public void setBookmarkTopic(String bookmarkTopic) {
		this.bookmarkTopic = bookmarkTopic;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	
	
}
