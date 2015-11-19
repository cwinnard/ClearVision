package com.clearvision.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.clearvision.database.UserDaoImpl;
import com.clearvision.model.User;

/**
 * Servlet implementation class AddUserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDaoImpl userDB = new UserDaoImpl();
		User user = new User();
		HttpSession session = request.getSession();

		String decision = request.getParameter("decision");
		String email;
		String password;

		switch (decision) {
		case "login":
			email = request.getParameter("email");
			password = request.getParameter("password");

			user = userDB.userLogin(email, password);

			session.setAttribute("user", user);
			request.getRequestDispatcher("/accountPage.jsp").forward(request, response);
			break;
		case "register":
			email = request.getParameter("email");
			password = request.getParameter("password");
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");

			user.setEmail(email);
			user.setPass(password);
			user.setFirstName(firstName);
			user.setLastName(lastName);

			userDB.addUserToDb(user);

			session.setAttribute("user", user);
			request.getRequestDispatcher("/accountPage.jsp").forward(request, response);
			break;
		}

	}
}
