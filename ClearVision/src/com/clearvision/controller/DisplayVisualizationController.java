package com.clearvision.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

import com.clearvision.database.DatabaseJoiner;
import com.clearvision.database.JsonParser;
import com.clearvision.database.LeafDB;
import com.clearvision.model.Leaf;

/**
 * Servlet implementation class DisplayVisualizationController
 */
@WebServlet("/DisplayVisualizationController")
public class DisplayVisualizationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DisplayVisualizationController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DatabaseJoiner joiner = new DatabaseJoiner();
		joiner.joinUserAndBookmarkTables("ctwinnard@gmail.com");
		joiner.joinUserBookmarkAndTagTables();

		LeafDB leafDB = new LeafDB();
		ArrayList<Leaf> leaves = new ArrayList<Leaf>();
		leaves = leafDB.pullLeavesFromDatabase();

		JsonParser jsonParser = new JsonParser();
		try {
			jsonParser.generateJSON(leaves);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/sunBurst.jsp").forward(request, response);
	}

}
