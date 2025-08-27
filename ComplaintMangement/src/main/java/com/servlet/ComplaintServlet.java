package com.servlet;

import java.io.IOException;

import com.dao.ComplaintDao;
import com.model.Complaint;
import com.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/complaint")
public class ComplaintServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            resp.sendRedirect("index.html");
            return;
        }

        String title = req.getParameter("title");
        String description = req.getParameter("description");

        Complaint complaint = new Complaint(user.getEmail(), title, description);

        ComplaintDao dao = new ComplaintDao();
        dao.saveComplaint(complaint);

        resp.getWriter().println("Complaint submitted successfully!");
    }
}
