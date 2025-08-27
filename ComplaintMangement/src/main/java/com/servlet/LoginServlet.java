package com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import com.dao.UserDao;
import com.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user = new User(email,password);
        
        
        UserDao dao = new UserDao();
       
       
	boolean isValid =false;
	try {

		isValid = dao.validateUser(user);
        
		 if (isValid) {
	            // create session
	            HttpSession session = req.getSession();
	            
				 
	            session.setAttribute("email", user.getEmail());
	            System.out.println("Login successful for: " + user.getEmail());
	            // redirect to complaint.jsp
	            RequestDispatcher rd = req.getRequestDispatcher("/home.jsp");
	            System.out.println("Login successful, forwarding to Complaint.jsp");
                rd.forward(req, resp);

	        } else {
	            req.setAttribute("error", "Invalid email or password");
	            RequestDispatcher rd = req.getRequestDispatcher("index.html");
	            rd.forward(req, resp);
	        }
	    
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
       
}
}