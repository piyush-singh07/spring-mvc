<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users Page</title>


<style>

table {
    width:80%;border-radius: 12px;
   
}
table, th, td {
    border: white;
    border-collapse: collapse;
}
th, td {
    padding: 15px;
     text-align: center;
}
table#t01 tr:nth-child(even) {
    background-color: #eee;
}
table#t01 tr:nth-child(odd) {
   background-color: #fff;
}
table#t01 th {
    background-color:black;
    color: white;
}
* {
    box-sizing: border-box;
}


.column {
    float:left;
    width: 33%;
    padding: 10px;
    height: 200px; 
    spacing:20px;
    margin-right:4px;border-radius: 12px;
  
}


.row:after {
    content: "";
    display: table;
    clear: both;
}
.button {
    background-color: #ff944d;
    border: none;
    color: white;
    padding: 20px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
}
.button4 {border-radius: 12px;}
</style>
</head>
<body>
	<h1 align=center>------Users Details------</h1>
	<table  id="t01" border="1" align=center width=100%>
		<tr>
		    
			<th>EMPLOYEE ID</th>
			<th>EMPLOYEE NAME</th>
			<th>DESIGNATION</th>
			<th>PASSWORD</th>
		</tr>
		<c:forEach items="${userList}" var="element">
			
				<td>${element.emp_id}</td>
				<td>${element.emp_name}</td>
				<td>${element.emp_designation}</td>
				<td>${element.emp_password}</td>
			</tr>
		</c:forEach>
	</table>
	<br><br><br><br>
	<div class="row">
  <div class="column" style="background-color:#b3ffff;">
	<fieldset><legend style="text-align: center;">DELETE RECORD</legend>
	<form action="user.htm" method="post">
	
	
	
		<input name="action" value="delete" type="hidden"> <br> 
		<table align=center>
		<tr><td>ID:</td><td><input type="text" name="delete_id"></td></tr>
		</table><br>
		<button class="button button4" style="margin:auto;display:block;" type="submit">DELETE</button>
		</form>
		</fieldset>
	
	</div>
	
	<div class="row">
  <div class="column" style="background-color:#ffccb3;">
	<fieldset><legend style="text-align: center;" >GET THE RECORD BY ID</legend>
	<form action="user/id.htm" method="post">
		<br>
		<table align=center>
		<tr><td>ENTER ID:</td><td><input type="text" name="get_id"></td></tr>
		</table><br>
		<button class="button button4" style="margin:auto;display:block;" type="submit">SHOW </button>
		
	</form></fieldset></div>
	<div class="row">
  <div class="column" style="background-color:#b3ffff;">
  <fieldset><legend style="text-align: center;" >GET THE RECORD BY NAME</legend>
	<form action="user/name.htm" method="post">
		<br>
		<table align=center>
		<tr><td>ENTER NAME:</td><td><input type="text" name="get_name"></td></tr>
		</table><br>
		<button class="button button4" style="margin:auto;display:block;" type="submit">SHOW </button>
		
	</form></fieldset>
	</div></div></div></div>
	<br><br><br><br>
	<div class="row">
	<div class="column" style="background-color:white;"></div>
  <div class="column" style="background-color:#ccffe6;">
	<fieldset><legend style="text-align: center;" >ADD A RECORD</legend>
	<form action="user/add.htm" method="post">
	<br><br>
		<table align=center>
		<tr><td>EMP ID</td><td><input type="text" name="emp_id"></td></tr>
		<tr><td>EMP NAME</td><td><input type="text" name="emp_name"> </td></tr>
		<tr><td>EMP DESIGNATION</td><td><input type="text" name="emp_designation"> </td></tr>
		<tr><td>EMP PASSWORD</td><td><input type="text" name="emp_password"> </td></tr>
		</table>
		<br><br>
		<button class="button button4" style="margin:auto;display:block;" type="submit" name="add_id">ADD</button>
		
	</form>
	</fieldset></div>
	<div class="column" style="background-color:white;"></div>
	<div class="row">
	<div class="column" style="background-color:white;"></div>
	<div class="column" style="background-color:#ccffe6;"></div>
</body>
</html>