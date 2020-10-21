package com.studentapp.factory;

import com.studentapp.dao.StudentDAO;
import com.studentapp.dao.StudentDAOImpl;

public class StudentDAOFactory {
	private static StudentDAO studentdao;
	
	static {
		studentdao= new StudentDAOImpl();
		
	}
	
	public static StudentDAO getStudentDAO()
	{
		return studentdao;
	}

}
