package com.crs.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crs.dao.UserDetailDao;
import com.crs.dao.UserRegisterDAO;
import com.crs.model.user.CreateUser;
import com.crs.service.UserDetailService;

@Service("userDetailService")
public class UserDetailServiceImpl implements UserDetailService {
	
	@Autowired
	private UserRegisterDAO userRegisterDao;
	
	@Autowired
	private UserDetailDao userDetailDao;

	@Override
	public void addUser(CreateUser user) {
		userRegisterDao.registerUser(user);
	}
	
	

	
	
	

}
