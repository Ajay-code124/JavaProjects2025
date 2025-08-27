package com.jsp.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import com.jsp.dao.UserDao;
import com.jsp.model.User;


 
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
	     String password = request.getParameter("password");
	     
	     User user = new User(email,password);
		  
		  UserDao userDao = new UserDao();
		
		  boolean isValid = false;
		
		try {
			isValid = userDao.validateUser(user);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		
		
		  if(isValid) {
			  HttpSession session = request.getSession();
			  String[] split = user.getEmail().split("@");
			  String name = split[0];
			  session.setAttribute("email", name);
			  RequestDispatcher requestDispatcher = request.getRequestDispatcher("employees");
			  requestDispatcher.forward(request, response);
		  }
		  else {
			  RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.html");
			  requestDispatcher.forward(request, response);
		  }
		  
		
	}

}
