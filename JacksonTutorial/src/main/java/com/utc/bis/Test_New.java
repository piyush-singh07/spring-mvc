package com.utc.bis;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.utc.dip.Address;
import com.utc.dip.Employee;
import com.utc.dip.Student;
import com.utc.util.JSONUtil;

public class Test_New {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
	
		Employee emp= new Employee();
		emp.setEmp_id("ENO111");
		emp.setEmp_name("Jack");
		emp.setEmp_salary(100000.0F);
		emp.setEmp_hobbies(new String[] {"hockey","football"});
		emp.setEmp_contact(99119922);
		Address addr= new Address();
		addr.setHouse_no("hno1");
		addr.setStreet("Wall Street");
		addr.setCity("NYC");
		addr.setState(null);
		emp.setEmp_address(addr);
		emp.setIsEmployee(true);
		Test_New test= new Test_New();
		String hello=JSONUtil.getJSonStringFromObject(emp);
		System.out.println(hello);
/*		
		System.out.println("=======================");
		System.out.println("=======================");
		System.out.println("=======================");
		
		Employee emp1= JSONUtil.convertJSONToJava(hello,Employee.class);
		System.out.println(emp.getEmp_id());
		System.out.println(emp.getEmp_name());
		System.out.println(emp.getEmp_contact());
		System.out.println(Arrays.asList(emp.getEmp_hobbies()));
		Address address= emp.getEmp_address();
		System.out.println(address.getHouse_no());
		System.out.println(address.getStreet());
		System.out.println(address.getCity());
		System.out.println(address.getState());*/
		

	}
	
/*	private void writeJSON(Employee emp) throws JsonGenerationException, JsonMappingException, IOException
	{
		ObjectMapper mapper= new ObjectMapper();
		mapper.writeValue(new File("Employee.json"),emp);
		
	}*/
	

}
