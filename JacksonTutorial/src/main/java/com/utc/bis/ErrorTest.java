package com.utc.bis;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ErrorTest {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {

		String error="{\"Error\":\"true\",\"ErrorMessage\":\"WebCTRL add-on allow occupancy override false, No action taken\"}";
		
		ObjectMapper objectMapper=new ObjectMapper();
		ErrorResponseDTO dto= objectMapper.readValue(error,ErrorResponseDTO.class);
		System.out.println(dto.getError());
		System.out.println(dto.getErrorMessage());
		
		
		
	}

}
