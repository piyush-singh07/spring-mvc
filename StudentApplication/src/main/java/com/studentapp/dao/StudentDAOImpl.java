package com.studentapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.studentapp.dto.StudentTo;
import com.studentapp.factory.ConnectionFactory;

public class StudentDAOImpl implements StudentDAO {
	String status=null;

	@Override
	public String addStudent(StudentTo sdto) {
		try {
			Connection conn=ConnectionFactory.getConnection();
			status=searchStudent(sdto.getSid());
			if(!status.equals("existed"))
			{
				PreparedStatement pst=conn.prepareStatement("insert into student values(?,?,?)");
				pst.setString(1, sdto.getSid());
				pst.setString(2, sdto.getSname());
				pst.setString(3, sdto.getSaddr());
				pst.executeUpdate();
				status="success";
			}		
		} catch (SQLException e) {
			e.printStackTrace();
			status="failure";
		}
		return status;
		
		
	}

	@Override
	public List<StudentTo> getAllStudents() {
		List<StudentTo> stdto = new ArrayList<StudentTo>();
		try {
			Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pst= conn.prepareStatement("select * from student");
			ResultSet rs= pst.executeQuery();
			
		
			while(rs.next())
			{
				StudentTo stdnt = new StudentTo();
				stdnt.setSid(rs.getString("sid"));
				stdnt.setSname(rs.getString("sname"));
				stdnt.setSaddr(rs.getString("saddr"));
				stdto.add(stdnt);
			}
			
		} catch (Exception e) {
			e.getMessage();
		}
		
		return stdto;
	}

	@Override
	public StudentTo getStudentBySID(String sid) {
		StudentTo sto=null;
		try {
			Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement("select * from student where sid=?");
			pst.setString(1, sid);
			pst.executeQuery();
			ResultSet rs=pst.executeQuery();
			sto= new StudentTo();
			boolean b=rs.next();
			if(b==true)
			{
				sto.setSid(rs.getString("sid"));
				sto.setSname(rs.getString("sname"));
				sto.setSaddr(rs.getString("saddr"));
			}
			else
			{
				sto=null;
			}

		} catch (SQLException e) {
			e.getMessage();
		}
		return sto;
	}

	@Override
	public String updateStudent(StudentTo sdto) {
		try {
			Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pst= conn.prepareStatement("update  student set sname=?,saddr=? where sid=?");
			pst.setString(1,sdto.getSname());
			pst.setString(2,sdto.getSaddr());
			pst.setString(3,sdto.getSid());
			pst.executeUpdate();
			status="success";
			
		} catch (Exception e) {
			status="failure";
			e.getMessage();
		}
		return status;
	}

	@Override
	public String deleteStudent(String sid) {
		try {
			Connection conn = ConnectionFactory.getConnection();
			status=searchStudent(sid);
			if(status.equals("existed"))
			{
				PreparedStatement pst= conn.prepareStatement("delete from student where sid=?");
				pst.setString(1, sid);
				pst.executeUpdate();
				status="success";
				
			}		
		} catch (Exception e) {
			status="failure";
			e.getMessage();
		}
		return status;
	}

	@Override
	public String searchStudent(String sid) {
		try {
			Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement("select * from student where sid=?");
			System.out.println(pst);
			pst.setString(1, sid);
			pst.executeQuery();
			ResultSet rs=pst.executeQuery();
			boolean b= rs.next();
			if(b==true)
			{
				status="existed";
			}else
			{
				status="not existed";
			}

		} catch (SQLException e) {
			status="failure";
			e.getMessage();
		}
		return status;
	}



}
