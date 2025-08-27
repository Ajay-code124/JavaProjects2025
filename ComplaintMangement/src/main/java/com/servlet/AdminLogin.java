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
import jakarta.servlet.http.HttpSession;

@WebServlet("/adminlogin")
public class AdminLogin extends HttpServlet{

      @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	  String email = req.getParameter("email");
          String password = req.getParameter("password");
   Admin admin = new Admin(email, password);
   
   AdminDao dao = new AdminDao();
   
   
  boolean valid;
try {
	valid = dao.adminValid(admin);
	if(valid) {
		  HttpSession session = req.getSession();
	      
			 
	      session.setAttribute("email", admin.getEmail());
	      System.out.println("Login successful for: " + admin.getEmail());
	      // redirect to complaint.jsp
	      RequestDispatcher rd = req.getRequestDispatcher("detailcomps.jsp");
	      System.out.println("Login successful, forwarding to details.jsp");
	      rd.forward(req, resp);
	  }
	  else {
	      req.setAttribute("error", "Invalid email or password");
	      RequestDispatcher rd = req.getRequestDispatcher("AdminLogin.jsp");
	      rd.forward(req, resp);
	  }
} catch (ClassNotFoundException | SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
  

   
      }
}
