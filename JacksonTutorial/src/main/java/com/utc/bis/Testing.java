package com.utc.bis;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.utc.dip.Student;

public class Testing {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		Student student = new Student();
		student.setName("Aakash");
		student.setAge(20);
		Testing test= new Testing();
		test.writeJSON(student);
		System.out.println(test.readJSON());
	}
	
	private void writeJSON(Student student) throws JsonGenerationException, JsonMappingException, IOException
	{
		ObjectMapper mapper= new ObjectMapper();
		mapper.writeValue(new File("Student.json"),student);
	}
	
	private Student readJSON() throws JsonGenerationException, JsonMappingException, IOException
	{
		ObjectMapper mapper= new ObjectMapper();
		
		Student student = mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).readValue(new File("Student.json"), Student.class);
		return student;
	}

}
