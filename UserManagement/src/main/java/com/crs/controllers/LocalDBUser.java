package com.crs.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.crs.exceptions.DuplicatePasswordException;
import com.crs.exceptions.NoSuchUserException;
import com.crs.exceptions.PasswordMismatchException;
import com.crs.model.creation.CreateDBUser;
import com.crs.model.creation.GetDBUser;
import com.crs.model.creation.UpdatePassword;
import com.crs.models.ServiceResponseObject;
import com.crs.service.LocalDBUserService;
import com.crs.util.CommonUtil;
import com.crs.util.Constants;
import com.crs.util.JsonConverter;

@RestController
@RequestMapping(value = "/api/db/users")
public class LocalDBUser {
	
	@Autowired
	private CommonUtil commonUtil;
	
	@Autowired
	private LocalDBUserService localDBUserService;
	
	@Autowired
	private JsonConverter converter;	
	
	
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
 	
	/**
	 * API for Getting All Users
	 * endpoint: /api/user
	 */

	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServiceResponseObject> getAllUsers()
	{
		try {
			List<GetDBUser> list = localDBUserService.getAll();
			if (list != null && !list.isEmpty()) {
				String data = converter.getJsonStringFromObject(list);
				return commonUtil.buildCustomResponse(HttpStatus.OK, Constants.SUCCESS, data);
			} else {
				return commonUtil.buildCustomResponse(HttpStatus.NOT_FOUND, Constants.FAILURE,
						Constants.USERS_DOESNT_EXISTS);
			}
		} catch (Exception e) {
			return commonUtil.buildCustomResponse(HttpStatus.INTERNAL_SERVER_ERROR, Constants.FAILURE, e.getMessage());
		}

	}
	
	/**
	 * API for Creating/Posting User 
	 * endpoint: /api/users
	 */
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServiceResponseObject> addUser(@Valid @RequestBody CreateDBUser user)
	{
		try {
			localDBUserService.addUser(user);
			return	commonUtil.buildCustomResponse(HttpStatus.CREATED,Constants.SUCCESS,"User Created Successfully");		
		}
		catch(DuplicateKeyException e)
		{
			return commonUtil.buildCustomResponse(HttpStatus.CONFLICT, Constants.FAILURE, "Duplicate username or emailid");
		}
		catch (Exception e) {
			return	commonUtil.buildCustomResponse(HttpStatus.INTERNAL_SERVER_ERROR, Constants.FAILURE, e.getMessage());
		
		}
		
	}
	
	/**
	 * API for Getting User based on id
	 * endpoint: /api/users/id/{id}
	 */
	
	@GetMapping(value="/id/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServiceResponseObject> getUserById(@PathVariable(value="id") int id)
	{
		try {
			GetDBUser user= localDBUserService.getById(id);
			if(user!=null)
			{
				String data= converter.getJsonStringFromObject(user);
				return commonUtil.buildCustomResponse(HttpStatus.OK, Constants.SUCCESS, data);
			}
			else
			{
				return commonUtil.buildCustomResponse(HttpStatus.NOT_FOUND, Constants.FAILURE, Constants.USER_DOESNT_EXISTS);
			}
		} catch (Exception e) {
			return commonUtil.buildCustomResponse(HttpStatus.INTERNAL_SERVER_ERROR, Constants.FAILURE, e.getMessage());
		}
		
	}
	
	/**
	 * API for Getting User based on username 
	 * endpoint: /api/users/username/{username}
	 */
	
	@GetMapping(value="/username/{username}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServiceResponseObject> getUserByUserName(@PathVariable(value="username") String username)
	{
		try {
			GetDBUser user= localDBUserService.getByUserName(username);
			if(user!=null)
			{
				String data= converter.getJsonStringFromObject(user);
				return commonUtil.buildCustomResponse(HttpStatus.OK, Constants.SUCCESS, data);
			}
			else
			{
				return commonUtil.buildCustomResponse(HttpStatus.NOT_FOUND, Constants.FAILURE, Constants.USER_DOESNT_EXISTS);
			}
		} catch (Exception e) {
			return commonUtil.buildCustomResponse(HttpStatus.INTERNAL_SERVER_ERROR, Constants.FAILURE, e.getMessage());
		}
		
	}
	
	/**
	 * API for Deleting User based on id
	 * endpoint: /api/users/{id}
	 */

	
	@DeleteMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServiceResponseObject> deleteUser(@PathVariable int id)
	{
		try {
			int i= localDBUserService.deleteById(id);
			if(i>0)
			{
				return commonUtil.buildCustomResponse(HttpStatus.OK, Constants.SUCCESS, "User Deleted Successfully");
			}
			else
			{
				return commonUtil.buildCustomResponse(HttpStatus.NOT_FOUND, Constants.FAILURE, Constants.USER_DOESNT_EXISTS);
			}
		} catch (Exception e) {
			return  commonUtil.buildCustomResponse(HttpStatus.INTERNAL_SERVER_ERROR, Constants.FAILURE, e.getMessage());
		}
		
	}
	
	/**
	 * API for Updating User's Password 
	 * endpoint: /api/users/password
	 */
	
	@PutMapping(value="/password",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServiceResponseObject> updateUserPassword(
			@Valid @RequestBody UpdatePassword updatePassword)
	{
		try {
			int i = localDBUserService.updatePassword(updatePassword);
			if (i > 0) {
				return commonUtil.buildCustomResponse(HttpStatus.CREATED, Constants.SUCCESS,
						"Password Updated Successfully");
			}
			else
			{
				return commonUtil.buildCustomResponse(HttpStatus.INTERNAL_SERVER_ERROR, Constants.FAILURE,
						"Failed to Update Password");
			}
		} catch (NoSuchUserException e) {
			return commonUtil.buildCustomResponse(HttpStatus.NOT_FOUND, Constants.FAILURE,e.getMessage());
		}
		catch(DuplicatePasswordException | PasswordMismatchException e)
		{
			return commonUtil.buildCustomResponse(HttpStatus.BAD_REQUEST, Constants.FAILURE,e.getMessage());
		}
		catch (Exception e) {
			return commonUtil.buildCustomResponse(HttpStatus.INTERNAL_SERVER_ERROR,
					Constants.FAILURE, e.getMessage());
		}
		
		
		
		
	}
	

}