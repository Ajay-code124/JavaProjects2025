package com.servlet;

import java.io.IOException;

import com.dao.ComplaintDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updateStatus")
public class UpdateComplaint extends  HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		int id = Integer.parseInt(req.getParameter("id"));
        String status = req.getParameter("status");

        try {
            ComplaintDao dao = new ComplaintDao();
            dao.updateStatus(id, status);
            resp.sendRedirect("allcomplaints");
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(500);
        }
	}
}
