package com.servlet;

import java.io.IOException;

import com.dao.UserDao;
import com.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class UserRegister extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
	     String password = req.getParameter("password");
	  String confirmPassword = req.getParameter("confirm-password");
	  
	  User user = new User(email, password);
	  UserDao udao = new UserDao();
	  
	  udao.saveUser(user);
	  
	  RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.html");
	  requestDispatcher.forward(req, resp);
	}

}
