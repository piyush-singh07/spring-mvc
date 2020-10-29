package com.utc.dip.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRestController {
	
	
	@RequestMapping(value="/")
    public String welcome() {
        return "Welcome to RestTemplate Example.";
    }
 
    @RequestMapping(value="/hello/{player}")
    public String message(@PathVariable String player) {
    	return "Welcome "+player;
    }

}
    		      				