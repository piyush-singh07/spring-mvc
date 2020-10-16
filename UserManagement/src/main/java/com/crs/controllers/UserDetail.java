package com.crs.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crs.model.user.CreateUser;
import com.crs.models.ServiceResponseObject;
import com.crs.service.UserDetailService;

@RequestMapping(value="/api/users")
@RestController 
public class UserDetail {
	
	@Autowired
	private UserDetailService userDetailService;
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServiceResponseObject> registerUser(@Valid @RequestBody CreateUser user)
	{
		
		return null;
	}

}
