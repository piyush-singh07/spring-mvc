package com.utc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class JdbcController {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@RequestMapping(value="/",produces="application/json",method = RequestMethod.GET)
	public String getAllUSers() throws JsonProcessingException {
		
		String sql ="select * from emp_details";
		List<Map<String,Object>> list =jdbcTemplate.queryForList(sql);
		return objectMapper.writeValueAsString(list);
	}
	

	@RequestMapping(value="/id/{id}",produces="application/json",method = RequestMethod.GET)
	public String getUserById(@PathVariable("id")int id) throws JsonProcessingException {
		
		String sql1 ="select * from emp_details where emp_id=?";
		List<Map<String, Object>> list =jdbcTemplate.queryForList(sql1,id); 
		return objectMapper.writeValueAsString(list);
		
	}
	
	
	@RequestMapping(value="/name/{name}",produces="application/json",method = RequestMethod.GET)
	public String getUserByName(@PathVariable("name")String name) throws JsonProcessingException {
		
		String sql1 ="select * from emp_details where emp_name=?";
		List<Map<String, Object>> list =jdbcTemplate.queryForList(sql1,name); 
		return objectMapper.writeValueAsString(list);
		
	
	}
	
	@RequestMapping(value="/delete/{id}",produces="application/json",method = RequestMethod.GET)
	public void  deleteUser(@PathVariable("id") int id) throws JsonProcessingException {
		
		String sql ="delete from emp_details where emp_id=?";
	jdbcTemplate.update(sql,id);
		   
	}					

	
	@RequestMapping(value="/add",produces="application/json",method = RequestMethod.POST,consumes="application/json")
	public int getUserByUsername(@RequestBody User user) throws JsonProcessingException {
		System.out.println("User:"+user);		
		String sql1 ="insert into emp_details values(?,?,?,?)";
		int rec_added= jdbcTemplate.update(sql1,user.getEmp_id(),user.getEmp_name(),user.getEmp_designation(),user.getEmp_password()); 
		return rec_added;
		
	}

}
