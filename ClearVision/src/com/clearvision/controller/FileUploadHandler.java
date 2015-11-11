package com.clearvision.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clearvision.database.BookmarkDB;
import com.clearvision.model.Bookmark;
import com.clearvision.model.Parser;

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

		BookmarkUploader uploader = new BookmarkUploader();
		uploader.convertUploadedFileToString(request, response);
		String fileContents = uploader.getUploadContents();
		
		Parser parser = new Parser();
		List<Bookmark> bookmarkList = parser.populateBookmarkList(fileContents);

		BookmarkDB db = new BookmarkDB();
		db.saveBookmarksToDB(bookmarkList);

		request.setAttribute("bookmarkList", bookmarkList);
		request.getRequestDispatcher("/result.jsp").forward(request, response);

	}

}