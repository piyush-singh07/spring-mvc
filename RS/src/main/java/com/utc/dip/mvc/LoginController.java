package com.utc.dip.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login.htm")
public class LoginController {

	@RequestMapping(method = RequestMethod.GET)
	public String login(ModelMap model) {
		System.out.println("Asked for login page");
		return "login";
	}
}
