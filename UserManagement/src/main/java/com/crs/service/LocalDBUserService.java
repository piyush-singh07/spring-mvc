package com.crs.service;

import java.util.List;

import com.crs.model.creation.CreateDBUser;
import com.crs.model.creation.GetDBUser;
import com.crs.model.creation.UpdatePassword;

public interface LocalDBUserService {
	
	public List<GetDBUser> getAll();
	public GetDBUser getById(int id);
	public GetDBUser getByUserName(String username);
	public int deleteById(int id);
	public void addUser(CreateDBUser user);
	public int updatePassword(UpdatePassword updatePwd);
	public String getPassword(String username);
	

}
