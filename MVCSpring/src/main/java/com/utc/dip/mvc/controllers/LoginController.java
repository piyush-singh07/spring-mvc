package com.utc.dip.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView model = new ModelAndView("login");
		model.addObject("msg", "Please login ");
		return model;
	}

	 

	
	

}


