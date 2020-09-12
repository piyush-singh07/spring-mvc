package com.utc.bis;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.utc.dip.Student;

public class TestMap {
	
	
	public static void main(String[] args) {
		Student stud= new Student();
		stud.setName("Jack");
		stud.setAge(10);
		Map<String,Object> studMap= new HashMap<String,Object>();
		studMap.put("student", stud);
		Map<String,Object> addrMap= new HashMap<String,Object>();
		addrMap.put("hno","132k");
		addrMap.put("street","Wall Street");
		addrMap.put("city","NYC");
		addrMap.put("state","USA");
		studMap.put("Address", addrMap);


		ObjectMapper mapper= new ObjectMapper();
		try {
			mapper.writeValue(new File("Student1.json"),studMap);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	


}
