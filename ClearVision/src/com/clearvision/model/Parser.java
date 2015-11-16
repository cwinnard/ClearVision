package com.clearvision.model;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Parser {
	
	public List<Bookmark> populateBookmarkList(String uploadContents) throws IOException {
		ArrayList<Bookmark> bookmarkList = new ArrayList<Bookmark>();
		
		String[] individualHTMLs = uploadContents.split("<DT>");
		
		for (String eachHTML : individualHTMLs) {
			
			if (eachHTML.startsWith("<A HREF")) {
				Document doc = Jsoup.parse(eachHTML);
				Element link = doc.select("a").first();
			
				String linkHref = link.attr("href");
				String linkText = link.text();
			
				Bookmark bookmark = new Bookmark();
				bookmark.setName(linkText);
				bookmark.setUrl(linkHref);
				bookmark.setTopic("General");
				
				bookmarkList.add(bookmark);
			}
		}
		return bookmarkList;
	}
}
