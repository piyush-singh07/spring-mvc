<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Details.....</title>
</head>
<body>
	<h2>${headermessage}</h2>
	<h1>Your Registration details are processed....</h1>
	<table>
		<tr>
			<td>Student Id:</td>
			<td>${student.sid}</td>
		</tr>
		<tr>
			<td>Student Name:</td>
			<td>${student.sname}</td>
		</tr>
		<tr>
			<td>Student Mobile:</td>
			<td>${student.smobile}</td>
		</tr>
		<tr>
			<td>Student DOB:</td>
			<td>${student.sdob}</td>
		</tr>
			<tr>
			<td>Student Hobby:</td>
			<td>${student.shobby}</td>
		</tr>
		<tr>
			<td>Student Skills:</td>
			<td>${student.sskills}</td>
		</tr>
	</table>
	<table>
	<tr><td>Student Address</td></tr>
	<tr>
			<td>House No.:</td>
			<td>${student.saddress.hno}</td>
		</tr>
		<tr>
			<td>Street:</td>
			<td>${student.saddress.street}</td>
		</tr>
		<tr>
			<td>City:</td>
			<td>${student.saddress.city}</td>
		</tr>
		<tr>
			<td>State:</td>
			<td>${student.saddress.state}</td>
		</tr>
			<tr>
			<td>Pincode:</td>
			<td>${student.saddress.pincode}</td>
		</tr>
	
	</table>
</body>
</html>