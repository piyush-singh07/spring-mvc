package com.crs.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.crs.models.ServiceResponseObject;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class CommonUtil {
	

	public ResponseEntity<ServiceResponseObject> buildCustomResponse(HttpStatus httpStatus, String Statusmessage, String data)
	{
		ObjectMapper mapper= new ObjectMapper();
		ServiceResponseObject sro= new ServiceResponseObject();
		JsonNode actualObj=null;
		sro.setStatus(Statusmessage);
		try {
			actualObj = mapper.readTree(data);
			sro.setData(actualObj);
		} catch (Exception e) {
			sro.setMessage(data);
		}
		return new ResponseEntity<ServiceResponseObject>(sro, httpStatus);
	}
	
}
