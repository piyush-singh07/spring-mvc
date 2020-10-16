package com.crs.dao;

import java.util.List;

import com.crs.model.user.CreateRole;
import com.crs.model.user.GetRole;

public interface UserRoleDAO {
	
	public List<GetRole> getUserRole();
	
	public void createUserRole(CreateRole createRole);
	
	public int deleteUserRole(int id);

}
