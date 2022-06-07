package com.ty.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.service.EmployeeService;

@WebServlet(value = "/delete")
public class DeleteEmployee extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id")) ;
		
		HttpSession httpSession = req.getSession() ;
		if(httpSession.getAttribute("email") != null) {
		EmployeeService employeeService = new EmployeeService() ;
		employeeService.deleteEmployeeByid(id);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("displayemployees.jsp") ;
		dispatcher.forward(req, resp);
		}else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("adminlogin.jsp") ;
			dispatcher.forward(req, resp);
		}
	}
	
}
