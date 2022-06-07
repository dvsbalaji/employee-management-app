package com.ty.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dto.EmployeeDto;
import com.ty.service.EmployeeService;

@WebServlet(value = "/addemployee")
public class AddEmployee extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int empid = Integer.parseInt(req.getParameter("empid") ) ;
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String doj = req.getParameter("doj");
		String dob = req.getParameter("dob");
		String deptname = req.getParameter("deptname");
		String grade = req.getParameter("grade");
		String designation = req.getParameter("designation");
		String gender = req.getParameter("gender");
		String status = req.getParameter("status");
		String address = req.getParameter("address");
		String phone = req.getParameter("phone");
		
		EmployeeDto employeeDto = new EmployeeDto() ;
		employeeDto.setEmpid(empid);
		employeeDto.setFname(fname);
		employeeDto.setLname(lname);
		employeeDto.setDoj(doj);
		employeeDto.setDob(dob);
		employeeDto.setDeptname(deptname);
		employeeDto.setGrade(grade);
		employeeDto.setDesignation(designation);
		employeeDto.setGender(gender);
		employeeDto.setStatus(status);
		employeeDto.setAddress(address);
		employeeDto.setPhone(phone);
		
		EmployeeService employeeService = new EmployeeService() ;
		boolean res = employeeService.saveEmployee(employeeDto) ;
		if(res) {
		RequestDispatcher dispatcher = req.getRequestDispatcher("displayemployees.jsp") ;
		dispatcher.forward(req, resp);
		}else {
			PrintWriter printWriter  = resp.getWriter() ;
			printWriter.write("<html><body> <h1> Invalid Age  </h1></body></head>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("addnewemployee.jsp") ;
			dispatcher.include(req, resp);
		}
	}
	
}
