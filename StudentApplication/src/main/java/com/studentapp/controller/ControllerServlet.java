package com.studentapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studentapp.dto.StudentTo;
import com.studentapp.factory.StudentServiceFactory;
import com.studentapp.services.StudentService;



/**
 * Servlet implementation class ControllerServlet
 */
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String button_label= request.getParameter("BUTTON");
		String status = null;
		RequestDispatcher rd = null;
		if(button_label.equals("ADD"))
		{	
			StudentService stdservice=StudentServiceFactory.getStudentService();
			StudentTo stdto = new StudentTo();
			stdto.setSid(request.getParameter("sid"));
			stdto.setSname(request.getParameter("sname"));
			stdto.setSaddr(request.getParameter("saddr"));
			status= stdservice.add(stdto);
			if(status.equals("success"))
			{
				rd=request.getRequestDispatcher("success.html");
				rd.forward(request, response);
			}
			if(status.equals("failure"))
			{
				rd=request.getRequestDispatcher("failure.html");
				rd.forward(request, response);
			}
			if(status.equals("existed"))
			{
				rd=request.getRequestDispatcher("existed.html");
				rd.forward(request, response);
			}
			
		}
		if(button_label.equals("SEARCH"))
		{	
			StudentService stdservice=StudentServiceFactory.getStudentService();
			StudentTo stdto = new StudentTo();
			stdto=stdservice.getStudent(request.getParameter("sid"));
			if(stdto==null)
			{
				rd=request.getRequestDispatcher("notexisted.html");
				rd.forward(request, response);
			}
			else
			{
				request.setAttribute("stdto",stdto);
				rd=request.getRequestDispatcher("./WEB-INF/display.jsp");
				rd.forward(request, response);
			}
			
		}
		if(button_label.equals("DELETE"))
		{	
			StudentService stdservice=StudentServiceFactory.getStudentService();
			status=stdservice.delete(request.getParameter("sid"));
			if(status.equals("success"))
			{
				rd=request.getRequestDispatcher("success.html");
				rd.forward(request, response);
			}
			if(status.equals("failure"))
			{
				rd=request.getRequestDispatcher("failure.html");
				rd.forward(request, response);
			}
			if(status.equals("not existed"))
			{
				rd=request.getRequestDispatcher("notexisted.html");
				rd.forward(request, response);
			}
			
			
		}
		if(button_label.equals("NO"))
		{	
			
			rd=request.getRequestDispatcher("welcome.html");
			rd.forward(request, response);
		}
		if(button_label.equals("YES"))
		{	
			StudentService stdservice=StudentServiceFactory.getStudentService();
			List<StudentTo> liststdto= stdservice.getAll();
			request.setAttribute("liststdto", liststdto);
			rd= request.getRequestDispatcher("./WEB-INF/allstudents.jsp");
			rd.forward(request, response);
		}
		if(button_label.equals("GET FORM"))
		{	
			StudentService stdservice=StudentServiceFactory.getStudentService();
			StudentTo stdto = new StudentTo();
			stdto=stdservice.getStudent(request.getParameter("sid"));
			if(stdto!=null)
			{
				request.setAttribute("stdto",stdto);
				rd=request.getRequestDispatcher("./WEB-INF/update.jsp");
				rd.forward(request, response);
			}
			if(stdto==null)
			{
				rd=request.getRequestDispatcher("notexisted.html");
				rd.forward(request, response);
			}
			
		}
		if(button_label.equals("UPDATE"))
		{	
			StudentService stdservice=StudentServiceFactory.getStudentService();
			StudentTo stdto = new StudentTo();
			stdto.setSid(request.getParameter("sid"));
			stdto.setSname(request.getParameter("sname"));
			stdto.setSaddr(request.getParameter("saddr"));
			status=stdservice.update(stdto);
			if(status.equals("success"))
			{
				rd=request.getRequestDispatcher("success.html");
				rd.forward(request, response);
			}
			if(status.equals("failure"))
			{
				rd=request.getRequestDispatcher("failure.html");
				rd.forward(request, response);
			}
			
		}
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
       
   
}
