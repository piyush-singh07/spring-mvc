package com.utc.dip.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@RequestMapping(value="/")
	public String hello()
	{
		return "Welcome to my Example";
		
	}
	
	
	
	
	@RequestMapping(value="/hi/{member}")
	public String message(@PathVariable String member)
	{
		return "Hello "+member;
		
	}

}
