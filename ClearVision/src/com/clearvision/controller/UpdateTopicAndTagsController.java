package com.clearvision.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clearvision.database.BkmarkDaoImpl;
import com.clearvision.database.BookmarkTagDB;
import com.clearvision.database.TagDB;
import com.clearvision.model.Bookmark;

@WebServlet("/UpdateTopicAndTagsController")
public class UpdateTopicAndTagsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateTopicAndTagsController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bookmarkToBeUpdated = request.getParameter("BookmarkName");
		String topicToBeAssigned = request.getParameter("Topic");
		String[] tagsToBeAssigned = request.getParameterValues("Tag");
		
		BkmarkDaoImpl bookmarkDB = new BkmarkDaoImpl();
		bookmarkDB.updateBkMarkInDb(bookmarkToBeUpdated, topicToBeAssigned);
		
		TagDB tagDB = new TagDB();
		tagDB.addTagsToDB(tagsToBeAssigned);
		
		BookmarkTagDB btDB = new BookmarkTagDB();
		
		int bookmarkID = bookmarkDB.returnBoomarkIDWhenGivenBookmarkName(bookmarkToBeUpdated);
		for (String tag : tagsToBeAssigned) {
			int tagID = tagDB.returnTagIDWhenGivenTagName(tag);
			btDB.linkBookmarkAndTag(bookmarkID, tagID);
		}
		
		List<Bookmark> bookmarkList = bookmarkDB.getBkMarkListFromDB();
		
		request.setAttribute("bookmarkList", bookmarkList);
		request.getRequestDispatcher("/assignment.jsp").forward(request, response);
	}

}
