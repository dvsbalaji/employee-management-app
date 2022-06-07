package com.ty.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dto.EmployeeDto;
import com.ty.service.EmployeeService;

@WebServlet(value = "/edit")
public class EditEmployee extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id  = Integer.parseInt(req.getParameter("id")) ;
		
		
		
		EmployeeService employeeService = new EmployeeService() ;
		EmployeeDto dto = employeeService.findEmployeeById(id) ;
		
		req.setAttribute("employee", dto);
		
		RequestDispatcher dispatcher =  req.getRequestDispatcher("edit.jsp") ;
		dispatcher.forward(req, resp);
	}
	
}
