package com.utc.dip.mvc.controllers;

import java.io.IOException;import java.util.*;
//import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.utc.dip.mvc.model.User;

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView login() throws JsonParseException, JsonMappingException, IOException {
		ModelAndView model = new ModelAndView("user");
		/**
		 * By default get all the users from RS Service and populate in a Table, Use
		 * RestTemplate
		 */
		
		RestTemplate rest = new RestTemplate();
		String s = rest.getForObject("http://localhost:8080/RestJdbc/", String.class);
		ObjectMapper mapper = new ObjectMapper();
		List<User> userList = mapper.readValue(s, new TypeReference<List<User>>() {
		});
		model.addObject("userList", userList);
		return model;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView delete(@RequestParam("delete_id") String id)
			throws JsonParseException, JsonMappingException, IOException {
		ModelAndView model = new ModelAndView("user");
		System.out.println("DELETE CALLED");

		/**
		 * First delete the User by Id using REstTemp
		 */
		RestTemplate rest = new RestTemplate();
		rest.getForObject("http://localhost:8080/RestJdbc//delete/" + id, String.class);

		/**
		 * By default get all the users from RS Service and populate in a Table, Use
		 * RestTemplate
		 */
		String s = rest.getForObject("http://localhost:8080/RestJdbc/", String.class);
		ObjectMapper mapper = new ObjectMapper();
		List<User> userList = mapper.readValue(s, new TypeReference<List<User>>() {
		});
		model.addObject("userList", userList);

		return model;
	}
	
	@RequestMapping(value = "/id", method = RequestMethod.POST)
	public ModelAndView getById(@RequestParam("get_id") String id)
			throws JsonParseException, JsonMappingException, IOException {
		ModelAndView model = new ModelAndView("user");
		System.out.println("GET CALLED");
		System.out.println(id);
		/**
		 * First delete the User by Id using REstTemp
		 */
		RestTemplate rest = new RestTemplate();

		/**;
		 * By default get all the users from RS Service and populate in a Table, Use
		 * RestTemplate;
		 */
		String s = rest.getForObject("http://localhost:8080/RestJdbc/id/" + id, String.class);
		ObjectMapper mapper = new ObjectMapper();
		List<User> userList = mapper.readValue(s, new TypeReference<List<User>>() {
		});
		model.addObject("userList", userList);

		return model;
	}

	@RequestMapping(value = "/name", method = RequestMethod.POST)
	public ModelAndView getByName(@RequestParam("get_name") String id)
			throws JsonParseException, JsonMappingException, IOException {
		ModelAndView model = new ModelAndView("user");
		System.out.println("GET NAME CALLED");
		System.out.println(id);
		
	
		RestTemplate rest = new RestTemplate();

		/**
		 * By default get all the users from RS Service and populate in a Table, Use
		 * RestTemplate
		 taking service from API*/
		String s = rest.getForObject("http://localhost:8080/RestJdbc/name/" + id, String.class);
		ObjectMapper mapper = new ObjectMapper();
		List<User> userList = mapper.readValue(s, new TypeReference<List<User>>() {
		});
		model.addObject("userList", userList);

		return model;
	}


	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView add(@RequestParam("emp_id") Integer emp_id, @RequestParam("emp_name") String emp_name,
			@RequestParam("emp_designation") String emp_designation, @RequestParam("emp_password") String emp_password)
			throws JsonParseException, JsonMappingException, IOException {
		ModelAndView model = new ModelAndView("user");
		System.out.println("ADD CALLED");
		System.out.println(emp_id);
		System.out.println(emp_name);
		System.out.println(emp_designation);
		System.out.println(emp_password);
		/**
		 * First Add the user Model 
		 */
		User userObj = new User();
		userObj.setEmp_id(emp_id);
		userObj.setEmp_name(emp_name);
		userObj.setEmp_designation(emp_designation);
		System.out.println("");
		userObj.setEmp_password(emp_password);

		ObjectMapper mapper = new ObjectMapper();
		String requestJson = mapper.writeValueAsString(userObj);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);
		RestTemplate rest = new RestTemplate();
		String se = rest.postForObject("http://localhost:8080/RestJdbc/add", entity, String.class);
		System.out.println(se);
        

		/**
		 * By default get all the users from RS Service and populate in a Table, Use
		 * RestTemplate
		 */
		String s = rest.getForObject("http://localhost:8080/RestJdbc/", String.class);
		List<User> userList = mapper.readValue(s, new TypeReference<List<User>>() {});
		model.addObject("userList", userList);
		return model;

	}
	

}
