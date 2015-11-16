package com.clearvision.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clearvision.database.UserDaoImpl;
import com.clearvision.model.User;


/**
 * Servlet implementation class AddUserController
 */
@WebServlet("/AddUserController")
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
	

//		UserDB userDB = new UserDB();
//		
//		User user = new User();
//		user.setEmail(request.getParameter("Email"));
//		user.setPass(request.getParameter("Pass"));
//		userDB.getUserFromDb(user);
//
//	}
//	
//}
//}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		
//		switch (action) {
//		case "add": {

		System.out.println("Adding User / Controller");
		// response.getWriter().append(request.getParameter("FirstName"));
		User user = new User();
		user.setFirstName(request.getParameter("FirstName"));
		user.setLastName(request.getParameter("LastName"));
		user.setEmail(request.getParameter("Email"));
		user.setPass(request.getParameter("Pass"));
		userDaoImpl.addUserToDb(user);
		
	
		
//	}
//	
//	
//	case "delete" + "": {
//		String email = request.getParameter("Email");
//		UserDaoImpl.deleteUserFromDb(email);
//	
//		break;
//		
//
//	}

}  
	}
