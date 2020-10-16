package com.crs.controllers;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.crs.model.user.CreateRole;
import com.crs.model.user.GetRole;
import com.crs.models.ServiceResponseObject;
import com.crs.service.UserRoleService;
import com.crs.util.CommonUtil;
import com.crs.util.Constants;
import com.crs.util.JsonConverter;

@RestController
@RequestMapping(value= {"/api/roles"})
public class UserRoles {
	
	@Autowired
	private CommonUtil commonUtil;
	
	@Autowired
	private UserRoleService userRoleService;
	
	@Autowired
	private JsonConverter converter;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServiceResponseObject> getRoles()
	{
		try {
			List<GetRole> roles= userRoleService.getUserRoles();
			if (roles != null) {
				String data = converter.getJsonStringFromObject(roles);
				return commonUtil.buildCustomResponse(HttpStatus.OK, Constants.SUCCESS, data);
			}
			else
			{
				return commonUtil.buildCustomResponse(HttpStatus.OK, Constants.SUCCESS, Constants.ROLES_DOESNT_EXISTS);
			}
			
		} catch (Exception e) {
			return commonUtil.buildCustomResponse(HttpStatus.INTERNAL_SERVER_ERROR, Constants.FAILURE, e.getMessage());
		}
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServiceResponseObject> postRole(@Valid @RequestBody CreateRole createRolemodel)
	{
		try {
			userRoleService.createRole(createRolemodel);
		    return commonUtil.buildCustomResponse(HttpStatus.CREATED, Constants.SUCCESS,"Role Created Successfully");
		}
		catch(DuplicateKeyException e)
		{
			return commonUtil.buildCustomResponse(HttpStatus.CONFLICT, Constants.FAILURE, "Duplicate role is not allowed");
		}
		catch (Exception e) {
			return commonUtil.buildCustomResponse(HttpStatus.INTERNAL_SERVER_ERROR, Constants.FAILURE,e.getMessage());
		}
		
	}
	
	@DeleteMapping(value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServiceResponseObject> postRole(@PathVariable(value="id") int id){
		try {
			int i = userRoleService.deleteRole(id);
			if (i > 0) {
				return commonUtil.buildCustomResponse(HttpStatus.OK, Constants.SUCCESS, "Role Deleted Successfully");
			} else {
				return commonUtil.buildCustomResponse(HttpStatus.NOT_FOUND, Constants.FAILURE,
						Constants.ROLE_DOESNT_EXISTS);
			}
		} catch (Exception e) {
			return  commonUtil.buildCustomResponse(HttpStatus.INTERNAL_SERVER_ERROR, Constants.FAILURE, e.getMessage());
		}
		
	}
	
	

}
