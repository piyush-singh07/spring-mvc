package com.utc.util;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.utc.dip.Employee;

public class JSONUtil {
	
	private static ObjectMapper mapper= null;
	
	static {
		
		mapper= new ObjectMapper();
	}
	
	public static String getJSonStringFromObject(Object object) throws IOException {
		return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
	}
	
	public static <T> T convertJSONToJava (String jsonString, Class<T> cls)
	{	T result= null;
		try {
			result= mapper.readValue(jsonString,cls);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}

}
