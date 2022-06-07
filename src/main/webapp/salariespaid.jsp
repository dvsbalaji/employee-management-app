<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.List"%>
<%@page import="com.ty.dto.SalaryDto"%>
<%@page import="com.ty.service.SalaryService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%@ include file="navbar.jsp"%>

	<% 
	SalaryService salaryService = new SalaryService() ;
		List<SalaryDto> salaries = salaryService.getAllSal() ;
		if(salaries.size() > 0){
	%>
	
	<table border="5px solid red" cellpadding=20px cellspacing=0px align="center" >
		<tr>
			<th>EMPID</th>
			<th>EMP NAME</th>
			<th>SALDATE</th>
			<th>TOTAL SAL</th>
			<th>NO OF LOP's</th>
			<th>AMOUNT CREDITED</th>
			<th>DEDUCTED AMOUNT</th>
			
			
		</tr>
		
		<tr>
		<%
			for (SalaryDto salary : salaries) {
		%>
			<td><%=salary.getEmployeeDto().getEmpid()%></td>
			<td><%=salary.getEmployeeDto().getFname()%></td>
			<td><%=salary.getDate()%></td>
			<td><%=salary.getEmployeeDto().getSal()%></td>
			<td><%=salary.getLop()%></td>
			<td><%=salary.getSalary()%></td>
			<td><%=salary.getEmployeeDto().getSal() - salary.getSalary() %></td>
			
			
		</tr>
		<%
			}
		}else {
			PrintWriter printWriter  = response.getWriter() ;
			printWriter.write("<html><body> <h1> No Pay Slips Found  </h1></body></head>");
		}
		%>

		</table>

</body>
</html>