package com.clearvision.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class BookmarkUploader {
public String uploadContents;
	
	BookmarkUploader() {}
	
	protected void convertUploadedFileToString(HttpServletRequest request,
	        HttpServletResponse response)
	        throws ServletException, IOException {
	    response.setContentType("text/html;charset=UTF-8");

	    final Part filePart = request.getPart("file");
	    InputStream filecontent = filePart.getInputStream();
	   
	        
	        BufferedReader inputReader = null;
			StringBuilder htmlContents = new StringBuilder();
			String line;
			
			try {

				inputReader = new BufferedReader(new InputStreamReader(filecontent));
				while ((line = inputReader.readLine()) != null) {
					htmlContents.append(line);
				}

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (inputReader != null) {
					try {
						inputReader.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
	        
	        
	       uploadContents = htmlContents.toString();
	}
	
	public String getUploadContents () {
		return uploadContents;
	}
}
