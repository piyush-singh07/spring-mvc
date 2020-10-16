package com.crs.util;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JsonConverter {
	
	public String getJsonStringFromObject(Object object) throws JsonProcessingException
	{
		return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(object);
	}

}
