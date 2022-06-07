<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<% String idd = request.getParameter("id") ;
		int id = Integer.parseInt(idd) ; %>

	<form action="pay" method="post">
		Employee Id : &nbsp<input type="text" value="<%= id %>" readonly="readonly" name="id"><br><br>
		no of lop : &nbsp<input type="text" name="lop" ><br><br>
		sal month : &nbsp<input type="date" name="date" ><br><br>
		<input type="submit" value="pay">
	</form>

</body>
</html>