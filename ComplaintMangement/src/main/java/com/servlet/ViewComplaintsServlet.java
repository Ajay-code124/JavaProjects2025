package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.dao.ComplaintDao;
import com.model.Complaint;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/myComplaints")
public class ViewComplaintsServlet extends HttpServlet {

	  @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        HttpSession session = req.getSession();
	        String userEmail = (String) session.getAttribute("email"); // set at login

	        ComplaintDao dao = new ComplaintDao();
	        List<Complaint> complaints;
			try {
				complaints = dao.getComplaintsByUser(userEmail);
				  System.out.println("Session email = " + userEmail);
			        System.out.println("Fetched complaints = " + complaints.size());

			        req.setAttribute("complaints", complaints);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	      

	        RequestDispatcher rd = req.getRequestDispatcher("/viewComplaints.jsp");
	        rd.forward(req, resp);
	    }
	
}
