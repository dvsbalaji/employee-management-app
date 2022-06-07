package com.ty.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.service.AdminService;

@WebServlet(value = "/adminlogin")
public class AdminLogin extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email") ;
		String password = req.getParameter("password") ;
		
		AdminService adminService = new AdminService() ;
		boolean res = adminService.validateAdmin(email, password) ;
		
		if(res) {
			
			HttpSession httpSession = req.getSession() ;
			httpSession.setAttribute("email", email);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("adminmenu.jsp") ;
			dispatcher.forward(req, resp);
		}else {
			
			PrintWriter printWriter = resp.getWriter() ;
			printWriter.write("<html><body><h1> Login failed Please try again </h1></body></html><br><br>");
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("adminlogin.jsp") ;
			dispatcher.forward(req, resp);
		}
	}
}
