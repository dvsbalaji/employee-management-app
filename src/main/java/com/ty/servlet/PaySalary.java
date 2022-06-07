package com.ty.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dto.EmployeeDto;
import com.ty.dto.SalaryDto;
import com.ty.service.EmployeeService;
import com.ty.service.SalaryService;

import Helper.ValidateDate;

@WebServlet(value = "/pay")
public class PaySalary extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id")) ;
		double lop = Double.parseDouble(req.getParameter("lop")) ;
		LocalDate date = LocalDate.parse(req.getParameter("date")) ;
		
		
		EmployeeService employeeService = new EmployeeService() ;
		EmployeeDto dto = employeeService.findEmployeeById(id) ; 
		double sal = (dto.getSal()/30 )*(30-lop) ;
		
		
		
			
		SalaryDto salary = new SalaryDto() ;
		salary.setDate(date);
		salary.setLop(lop);
		salary.setEmployeeDto(dto);
		salary.setSalary(sal);
		SalaryService salaryService =  new SalaryService() ;
		boolean res = salaryService.paySalary(salary) ;
		
		if(res) {
			PrintWriter printWriter  = resp.getWriter() ;
			printWriter.write("<html><body> <h1> salary paid succeessfully to "+dto.getFname()+"  </h1></body></head>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("displayemployees.jsp") ;
			dispatcher.include(req, resp);
			}else {
				PrintWriter printWriter  = resp.getWriter() ;
				printWriter.write("<html><body> <h1> Sorry unable to pay salary please try again  </h1></body></head>");
				RequestDispatcher dispatcher = req.getRequestDispatcher("displayemployees.jsp") ;
				dispatcher.include(req, resp);
			}
		
	}
}
