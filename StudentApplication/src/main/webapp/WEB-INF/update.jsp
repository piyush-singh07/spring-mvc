<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.studentapp.dto.StudentTo"%>
    <%StudentTo stdto=(StudentTo)request.getAttribute("stdto"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body bgcolor="lightblue">
<form method="POST" action="./controller">
<center>
<br>
<br>
<br>
<br>
<br>
<br>
	<table border="1">
		<tr>
			<td>Student Id :</td>
			<td><input type="text" name="sid" value=<%=stdto.getSid()%> readonly="readonly"></td>
		</tr>
		<tr>
			<td>Student Name</td>
			<td><input type="text" name="sname" value=<%=stdto.getSname()%>></td>
		</tr>
		<tr>
			<td>Student Address</td>
			<td><input type="text" name="saddr" value=<%=stdto.getSaddr()%>></td>
		</tr>
			</table>
		<input type="submit" name="BUTTON" value="UPDATE">

	</center>
	</form>
</body>
</html>