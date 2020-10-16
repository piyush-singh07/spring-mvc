package com.crs.daoimpl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crs.dao.UserDetailDao;
import com.crs.dao.UserProfileDao;
import com.crs.dao.UserRegisterDAO;
import com.crs.model.user.CreateUser;
import com.crs.model.user.CreateUserProfile;

@Repository("userDetailDao")
public class UserDetailDaoImpl implements UserDetailDao {
	
	@Autowired
	private UserRegisterDAO userRegisterDao;
	
	@Autowired
	private UserProfileDao userProfileDao;
	
	
	@Autowired
	private ApplicationContext context;
	
	@Transactional
	@Override
	public void addUser(CreateUser user) throws IOException {
		InputStream is=null;
		try {
		userRegisterDao.registerUser(user);
		org.springframework.core.io.Resource resource=context.getResource("classpath:default_user.png");
		CreateUserProfile userProfile= new CreateUserProfile();
		userProfile.setUsername(user.getUsername());
		userProfile.setFirstName(user.getFirstname());
		userProfile.setLastName(user.getLastname());
		userProfile.setEmailId(user.getEmailId());
		is=resource.getInputStream();
		userProfile.setImage(getBytesFromStream(is));
		}
		finally {
			if(is!=null)
				is.close();
		}
		
	}
	
	private byte[] getBytesFromStream(InputStream is) throws IOException {
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		int nRead;
		byte[] bytes = new byte[16384];
		while ((nRead = is.read(bytes, 0, bytes.length)) != -1) {
			buffer.write(bytes, 0, nRead);
		}
		buffer.flush();
		buffer.close();
		is.close();
		return bytes;
	} 
	
	

}
