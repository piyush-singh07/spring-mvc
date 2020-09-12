<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page.....</title>
</head>
<body>

	<h2>${headermessage}</h2>
	<form:errors path="student.*" />

	<h3>Please Fill your Details..</h3>
	<form action="submit" method="POST">
	<table>
		<tr>
			<td>Student Id:</td>
			<td><input type="text" name="sid" /></td>
		</tr>
		<tr>
			<td>Student Name:</td>
			<td><input type="text" name="sname" /></td>
		</tr>
		<tr>
			<td>Student Mobile:</td>
			<td><input type="text" name="smobile" /></td>
		</tr>
		<tr>
			<td>Student DOB:</td>
			<td><input type="text" name="sdob" /></td>
		</tr>
			<tr>
			<td>Student Hobby:</td>
			<td><input type="text" name="shobby" /></td>
		</tr>
		<tr>
			<td>Student Skills:</td>
			<td><select name="sskills" multiple="multiple">
					<option value="Java">Java</option>
					<option value="Adv Java">Adv Java</option>
					<option value="Spring">Spring</option>
					<option value="Hibernate">Hibernate</option>
			</select></td>
		</tr>
	</table>
	<table>
		<tr>
			<td>Student Address</td>
		</tr>
		<tr>
		    <td>House No.</td>
			<td><input name="saddress.hno" type="text"></td>
		</tr>
		<tr>
			<td>Street</td>
			<td><input name="saddress.street" type="text"></td>
		</tr>
		<tr>
			<td>City</td>
			<td><input name="saddress.city" type="text"></td>
		</tr>
		<tr>
			<td>State</td>
			<td><input name="saddress.state" type="text"></td>
		</tr>
		<tr>
			<td>Pincode</td>
			<td><input name="saddress.pincode" type="text"></td>
		</tr>
	</table><br><br>
	<input type="submit" value="Register"/>
	</form>
</body>
</html>