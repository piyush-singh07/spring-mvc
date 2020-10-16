package com.crs.dao;

import java.io.IOException;

import com.crs.model.user.CreateUser;

public interface UserDetailDao {

	public void addUser(CreateUser user) throws IOException;
	
}
