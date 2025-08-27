package com.servlet;

import java.io.IOException;
import java.util.List;

import com.dao.ComplaintDao;
import com.model.Complaint;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/allcomplaints")
public class AdminViewComplaintServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        try {
            ComplaintDao dao = new ComplaintDao();
            List<Complaint> complaints = dao.getAllComplaints();
            System.out.println("Get all complaints "+complaints);
            req.setAttribute("complaints", complaints);
            RequestDispatcher rd = req.getRequestDispatcher("getallcomplaints.jsp");
            rd.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(500);
        }
    }
}
