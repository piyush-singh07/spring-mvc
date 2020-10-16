package com.crs.service;

import java.util.List;

import com.crs.model.user.CreateRole;
import com.crs.model.user.GetRole;

public interface UserRoleService {
	
	public List<GetRole> getUserRoles();
	
	public void createRole(CreateRole createRole);
	
	public int deleteRole(int id);

}
