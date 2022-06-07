<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.time.LocalDate"%>
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
		if (session.getAttribute("email") != null) {
	%>
	<%@ include file="navbar.jsp" %>

	<form action="addemployee" method="post">
		<h1>ENTER EMPLOYEE DETAILS</h1>

		Emp.Id : &nbsp <input type="text" name="empid"
			pattern="[1-9]{1}[0-9]{5}"
			title="1st number should not be '0' and digits should not exceed '6'"><br>
		<br> First Name : &nbsp <input type="text" name="fname"
			pattern="[a-zA-Z'-'\s]*"
			title="special characters and numbers are not allowed"><br>
		<br> Last Name : &nbsp <input type="text" name="lname"
			pattern="[a-zA-Z'-'\s]*"
			title="special characters and numbers are not allowed"><br>
		<br> <label for="doj"> Date Of Join : &nbsp </label><input
			type="date" id="doj" name="doj"> <br> <br> <label
			for="dob"> Date Of Bearth : &nbsp </label><input type="date" id="dob"
			name="dob" > <br> <br> <label for="deptname">Department
			Name : &nbsp</label> <select name="deptname" id="deptname">
			<option value="Developer">Developer</option>
			<option value="Testing">Testing</option>
			<option value="Maintainance">Maintainance</option>
			<option value="Admin">Admin</option>
			<option value="HouseKeeping">HouseKeeping</option>
		</select><br> <br> <label for="grade">Grade : &nbsp</label> <select
			name="grade" id="grade">
			<option value="M1">M1</option>
			<option value="M2">M2</option>
			<option value="M3">M3</option>
			<option value="M4">M4</option>
			<option value="M5">M5</option>
			<option value="M6">M6</option>
			<option value="M7">M7</option>
		</select><br> <br> <label for="PersonGender">Gender : &nbsp </label>
		Male<input type="radio" value="Male" name="gender"> Female<input
			type="radio" value="Female" name="gender"> <br> <br>
		<label for="designation">Designation : &nbsp</label> <select
			name="designation" id="designation">
			<option value="Manager">Manager</option>
			<option value="Lead">Lead</option>
			<option value="Associate">Associate</option>
			<option value="Coordinator">Coordinator</option>
		</select><br>
		<br> <label for="status">Status : &nbsp</label> <select
			name="status" id="status">
			<option value="single">Single</option>
			<option value="married">Married</option>
			<option value="divorced">Divorced</option>
			<option value="separated">Separated</option>
			<option value="widowed">Widowed</option>
		</select><br> <br> Address : &nbsp
		<textarea rows="10" cols="30" name="address"></textarea>
		<br> <br> Phone : &nbsp <input type="text" name="phone"
			pattern="[6-9]{1}[0-9]{9}" title="enter a valid phone number"><br>
		<br> <input type="submit" value="save">

	</form>

	<%
		} else {
			response.sendRedirect("adminlogin.jsp");
		}
	%>


</body>
</html>