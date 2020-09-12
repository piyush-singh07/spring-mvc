package com.utc.dip;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {

	public static void main(String[] args) {
		
		String json= "{\"name\":\"Mahesh\", \"age\":21}";
		ObjectMapper obj= new ObjectMapper();
		try {
			Student std= obj.readValue(json, Student.class);
			System.out.println(std);
			String new_json=obj.writerWithDefaultPrettyPrinter().writeValueAsString(std);
			System.out.println(new_json);
					
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
