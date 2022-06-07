<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% 
		if(session.getAttribute("email") != null){ 
	%>
	
	<h1>Welcome to Admin Menu</h1>
	<h2>
	<a href="addnewemployee.jsp">ADD NEW EMPLOYEE DETAILS</a><br><br>
	<a href="displayemployees.jsp">VIEW EMPLOYEE DETAILS</a><br><br>
	<a href="salariespaid.jsp">VIEW SALARIES PAID</a><br><br>
	<a href="logout">LOGOUT</a>
	</h2>
	
	<% 
		} else{
		response.sendRedirect("adminlogin.jsp");
		}
	%>
	
</body>
</html>