package com.studentapp.services;

import java.util.List;

import com.studentapp.dto.StudentTo;

public interface StudentService {
	public String add(StudentTo sdto);
	public List<StudentTo> getAll();
	public StudentTo getStudent(String sid);
	public String update(StudentTo sdto);
	public String delete(String sid);
	
}
