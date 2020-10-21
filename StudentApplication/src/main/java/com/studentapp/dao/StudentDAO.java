package com.studentapp.dao;

import java.util.List;

import com.studentapp.dto.StudentTo;

public interface StudentDAO {
	
	public String addStudent(StudentTo sdto);
	public List<StudentTo> getAllStudents();
	public StudentTo getStudentBySID(String sid);
	public String updateStudent(StudentTo sdto);
	public String deleteStudent(String sid);
	public String searchStudent(String sid);

}
