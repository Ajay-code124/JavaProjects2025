package com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import com.dao.AdminDao;
import com.model.Admin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/adminsignup")
public class AdminRegister extends HttpServlet {


	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		Admin admin = new Admin(email, password);
		
		AdminDao aDao = new AdminDao();
		try {
			aDao.saveAdmin(admin);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/AdminLogin.jsp");
			requestDispatcher.forward(req, resp);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
