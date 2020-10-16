package com.crs.dao;

import java.util.List;

import com.crs.model.creation.CreateDBUser;
import com.crs.model.creation.GetDBUser;
import com.crs.model.creation.UpdatePassword;

public interface LocalDBUserDAO {
	
	public List<GetDBUser> findAll();

	public GetDBUser getUserById(int id);
	
	public GetDBUser getUserByUserName(String username);
	
	public int deleteUserById(int id);
	
	public void addLocalDBUser(CreateDBUser user);
	
	public int updateUserPassword(UpdatePassword updatePassword);

	public String getUserPassword(String username);

}
