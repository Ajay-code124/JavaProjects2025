package com.jsp.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.jsp.dao.EmployeeDao;
import com.jsp.model.Employee;

/**
 * Servlet implementation class AddEmployeeSer
 */
@WebServlet("/addEmployee")
public class AddEmployeeSer extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       String name = request.getParameter("name");
	      int age  = Integer.parseInt(request.getParameter("age"));
	      String email = request.getParameter("email");
	      String PhoneNumber = request.getParameter("PhoneNumber");
	     double salary= Double.parseDouble( request.getParameter("salary"));
		
	     Employee emp = new Employee(name, age, email, PhoneNumber, salary);
	     EmployeeDao employeeDao = new EmployeeDao();
	     employeeDao.addEmployee(emp);
	     
	     RequestDispatcher requestDispatcher = request.getRequestDispatcher("employees");
	     requestDispatcher.forward(request, response);
	}

}
