package com.crs.exceptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.crs.util.CommonUtil;
import com.crs.util.Constants;
import com.crs.util.JsonConverter;
import com.fasterxml.jackson.core.JsonProcessingException;

@ControllerAdvice
public class GlobalEH  {
	
	@Autowired
	private JsonConverter converter;
	
	@Autowired
	private CommonUtil commonUtil;

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public Object processValidationError(MethodArgumentNotValidException ex) {
		BindingResult result = ex.getBindingResult();
		List<String> list = new ArrayList<>();
		for (ObjectError error : result.getAllErrors())
			list.add(error.getDefaultMessage());
		try {
			String data = converter.getJsonStringFromObject(list);
			return commonUtil.buildCustomResponse(HttpStatus.BAD_REQUEST, Constants.FAILURE, data);
		} catch (IOException e) {
			return commonUtil.buildCustomResponse(HttpStatus.INTERNAL_SERVER_ERROR, Constants.FAILURE, e.getMessage());
		}
	}
	

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	@ResponseBody
	public Object processMethodError(HttpRequestMethodNotSupportedException ex) {
		try {
			return commonUtil.buildCustomResponse(HttpStatus.METHOD_NOT_ALLOWED, Constants.FAILURE, converter.getJsonStringFromObject(ex.getMessage()));
		} catch (JsonProcessingException e) {
			return commonUtil.buildCustomResponse(HttpStatus.INTERNAL_SERVER_ERROR, Constants.FAILURE, e.getMessage());
		}
	}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

