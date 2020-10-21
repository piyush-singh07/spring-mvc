<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.studentapp.dto.StudentTo ,java.util.*"%>
   <%
   List<StudentTo> al= new ArrayList<StudentTo>();
   al=(ArrayList<StudentTo>)request.getAttribute("liststdto");
   
   
   %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="lightblue">
 <h1>Displaying Student List</h1> 
      <table border ="1" width="500" align="center"> 
         <tr> 
          <th><b>Student Id</b></th> 
          <th><b>Student Name</b></th> 
          <th><b>Student Adress</b></th> 
         </tr> 
        <%
        for(StudentTo std:al){%> 
            <tr> 
                <td><%=std.getSid()%></td> 
                <td><%=std.getSname()%></td> 
                <td><%=std.getSaddr()%></td> 
            </tr> 
            <%}%> 
        </table>  
       
</body>
</html>