package com.jsp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.jsp.dao.EmployeeDao;
import com.jsp.model.Employee;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empId=Integer.parseInt(request.getParameter("id"));
		 String name = request.getParameter("name");
	      int age  = Integer.parseInt(request.getParameter("age"));
	      String email = request.getParameter("email");
	      String PhoneNumber = request.getParameter("PhoneNumber");
	     double salary= Double.parseDouble( request.getParameter("salary"));
	
	 Employee emp = new Employee(empId,name, age, email, PhoneNumber, salary);
	 EmployeeDao dao = new EmployeeDao();
	 try {
		dao.updateEmployee(emp);
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 response.sendRedirect("employees");
	}

}
