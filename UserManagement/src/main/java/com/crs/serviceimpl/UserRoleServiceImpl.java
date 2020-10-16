package com.crs.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crs.dao.UserRoleDAO;
import com.crs.model.user.CreateRole;
import com.crs.model.user.GetRole;
import com.crs.service.UserRoleService;

@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	private UserRoleDAO userRoleDao;

	@Override
	public List<GetRole> getUserRoles() {
		return userRoleDao.getUserRole();
	}

	@Override
	public void createRole(CreateRole createRole) {
		userRoleDao.createUserRole(createRole);
	}

	@Override
	public int deleteRole(int id) {
		return userRoleDao.deleteUserRole(id);
	}

}
