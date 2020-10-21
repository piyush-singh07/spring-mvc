package com.studentapp.services;

import java.util.ArrayList;
import java.util.List;

import com.studentapp.dao.StudentDAO;
import com.studentapp.dto.StudentTo;
import com.studentapp.factory.StudentDAOFactory;

public class StudentServiceImpl implements StudentService{
	
	String status="";

	@Override
	public String add(StudentTo sdto) {
		
		StudentDAO studentDao=StudentDAOFactory.getStudentDAO();
		status=studentDao.addStudent(sdto);
		
		return status;
	}

	@Override
	public List<StudentTo> getAll() {
		StudentDAO studentDao=StudentDAOFactory.getStudentDAO();
		List<StudentTo> liststdto= studentDao.getAllStudents();
		return liststdto;
	}

	@Override
	public StudentTo getStudent(String sid) {
		StudentDAO studentDao=StudentDAOFactory.getStudentDAO();
		StudentTo sto=studentDao.getStudentBySID(sid);
		return sto;
	}

	@Override
	public String update(StudentTo sdto) {
		StudentDAO studentDao=StudentDAOFactory.getStudentDAO();
	status=studentDao.updateStudent(sdto);
		
		return status;
	}

	@Override
	public String delete(String sid) {
		StudentDAO studentDao= StudentDAOFactory.getStudentDAO();
		status=studentDao.deleteStudent(sid);
		return status;
	}



}
