package com.studentapp.factory;

import com.studentapp.services.StudentService;
import com.studentapp.services.StudentServiceImpl;

public class StudentServiceFactory {
	
	private static StudentService studentService;
	static {
		studentService= new StudentServiceImpl();
		
	}
	
	public static StudentService getStudentService() {
		return studentService;
	}

}
