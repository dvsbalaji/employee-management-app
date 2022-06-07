<%@page import="com.ty.dto.EmployeeDto"%>
<%@page import="java.util.List"%>
<%@page import="com.ty.service.EmployeeService"%>
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

	<%@ include file="navbar.jsp"%>
	<br>
	<br>
	<%@include file="search.jsp"%><br>
	<br>
	<br>

	<%
		EmployeeService employeeService = new EmployeeService();
			List<EmployeeDto> employees = employeeService.getAllEmployees();
	%>

	<table border="5px solid red" cellpadding=20px cellspacing=0px
		align="center">
		<tr>
			<th>ID</th>
			<th>FIRST NAME</th>
			<th>LAST NAME</th>
			<th>DOB</th>
			<th>DOJ</th>
			<th>DEPT NAME</th>
			<th>GRADE</th>
			<th>DESIGNATION</th>
			<th>GENDER</th>
			<th>STSTUS</th>
			<th>ADDRESS</th>
			<th>PHONE</th>
			<th>SALARY</th>
			<th>EDIT</th>
			<th>DELET</th>
			<th>PAY</th>
		</tr>

		<tr>
			<%
				for (EmployeeDto employee : employees) {
			%>
			<td><%=employee.getEmpid()%></td>
			<td><a href="salpaidtoemp.jsp?id=<%=employee.getEmpid() %>"> <%=employee.getFname()%></a></td>
			<td><%=employee.getLname()%></td>
			<td><%=employee.getDob()%></td>
			<td><%=employee.getDoj()%></td>
			<td><%=employee.getDeptname()%></td>
			<td><%=employee.getGrade()%></td>
			<td><%=employee.getDesignation()%></td>
			<td><%=employee.getGender()%></td>
			<td><%=employee.getStatus()%></td>
			<td><%=employee.getAddress()%></td>
			<td><%=employee.getPhone()%></td>
			<td><%=employee.getSal()%></td>

			<td><a href="edit?id=<%=employee.getEmpid()%>">Edit</a></td>
			<td><a href="delete?id=<%=employee.getEmpid()%>">Delete</a></td>
			<td><a href="paysalary.jsp?id=<%=employee.getEmpid()%>">PAY
					SALARY</a></td>
		</tr>
		<%
			}
		%>

	</table>

	<%
		} else {
			response.sendRedirect("adminlogin.jsp");
		}
	%>

</body>
</html>