package com.crs.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crs.dao.LocalDBUserDAO;
import com.crs.exceptions.DuplicatePasswordException;
import com.crs.exceptions.NoSuchUserException;
import com.crs.exceptions.PasswordMismatchException;
import com.crs.model.creation.CreateDBUser;
import com.crs.model.creation.GetDBUser;
import com.crs.model.creation.UpdatePassword;
import com.crs.service.LocalDBUserService;
import com.crs.util.Constants;

@Service("localDBUserService")
public class LocalDBUserServiceImpl implements LocalDBUserService{
	
	@Autowired
	private LocalDBUserDAO localDBUserDAO;

	@Override
	public List<GetDBUser> getAll() {
		return localDBUserDAO.findAll();
	}

	@Override
	public GetDBUser getById(int id) {
		return localDBUserDAO.getUserById(id);
	}

	@Override
	public GetDBUser getByUserName(String username) {
		return localDBUserDAO.getUserByUserName(username);
	}

	@Override
	public int deleteById(int id) {
		return localDBUserDAO.deleteUserById(id);
	}

	@Override
	public void addUser(CreateDBUser user) {
		localDBUserDAO.addLocalDBUser(user);
		
	}

	@Override
	public int updatePassword(UpdatePassword updatePwd) {
		String oldpassword = getPassword(updatePwd.getUsername());
		if (oldpassword == null) {
			throw new NoSuchUserException(Constants.USER_DOESNT_EXISTS);
		}
		if (!oldpassword.equals(updatePwd.getOldPassword())) {
			throw new PasswordMismatchException("User Provided Old Password is not Correct");
		}
		if (oldpassword.equals(updatePwd.getNewPassword())) {
			throw new DuplicatePasswordException("Old password and New Password Should be Different");
		}
		return localDBUserDAO.updateUserPassword(updatePwd);
	}

	@Override
	public String getPassword(String username) {
		return localDBUserDAO.getUserPassword(username);
	}

}
