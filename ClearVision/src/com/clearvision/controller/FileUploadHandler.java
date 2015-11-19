package com.clearvision.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.clearvision.database.BkmarkDaoImpl;
import com.clearvision.model.Bookmark;
import com.clearvision.model.Parser;
import com.clearvision.model.User;

/**
 * Servlet to handle File upload request from Client
 * 
 * @author Javin Paul
 */
@WebServlet("/FileUploadHandler")
@MultipartConfig
public class FileUploadHandler extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		BookmarkUploader uploader = new BookmarkUploader();
		uploader.convertUploadedFileToString(request, response);
		String fileContents = uploader.getUploadContents();
		
		Parser parser = new Parser();
		List<Bookmark> bookmarkList = parser.populateBookmarkList(fileContents);

		BkmarkDaoImpl db = new BkmarkDaoImpl();
		db.saveBookmarksToDB(bookmarkList, user);

		request.setAttribute("bookmarkList", bookmarkList);
		request.getRequestDispatcher("/assignment.jsp").forward(request, response);

	}

}