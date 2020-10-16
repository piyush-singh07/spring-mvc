package com.crs.daoimpl;

import java.sql.Types;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crs.dao.UserRegisterDAO;
import com.crs.model.user.CreateUser;
import com.crs.util.Constants;
import com.crs.util.DateUtil;

@Repository("userRegisterDao")
public class UserRegisterDaoImpl implements UserRegisterDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private DateUtil dateUtil;

	@Transactional
	@Override
	public void registerUser(CreateUser user) {
		String sql= "INSERT INTO "+Constants.USERS_TABLE+"(username,created_on,modified_on,last_login_date,is_enabled,is_deleted"
				+ ",roles,email_id) VALUES (?,?,?,?,?,?,?,?) ";	
		jdbcTemplate.update(sql,new Object[] {user.getUsername(),dateUtil.getMySqlDate(new Date()),
				dateUtil.getMySqlDate(new Date()),dateUtil.getMySqlDate(new Date()),true,false,user.getRoles(),user.getEmailId()		
		}, new int[] {Types.VARCHAR,Types.TIMESTAMP,Types.TIMESTAMP,Types.TIMESTAMP,Types.BOOLEAN,Types.BOOLEAN,Types.VARCHAR,Types.VARCHAR});
		

	}

}
