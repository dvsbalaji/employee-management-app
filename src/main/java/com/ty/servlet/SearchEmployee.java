package com.ty.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dto.EmployeeDto;
import com.ty.service.EmployeeService;

@WebServlet(value = "/search")
public class SearchEmployee extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fname = req.getParameter("search") ;
		
		EmployeeService employeeService =  new EmployeeService() ;
		List<EmployeeDto> employees = employeeService.searchEmployeeByName(fname) ;
		
		if(employees.size() > 0 ) {
			req.setAttribute("employees", employees);
			RequestDispatcher dispatcher =  req.getRequestDispatcher("searchedemployee.jsp") ;
			dispatcher.forward(req, resp);
		}else {
			PrintWriter printWriter  = resp.getWriter() ;
			printWriter.write("<html><body> <h1> no employee found with specified name   </h1></body></head>");
			RequestDispatcher dispatcher =  req.getRequestDispatcher("displayemployees.jsp") ;
			dispatcher.include(req, resp);
		}
	}
	
}
