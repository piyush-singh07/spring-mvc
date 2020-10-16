package com.crs.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crs.dao.LocalDBUserDAO;
import com.crs.model.creation.CreateDBUser;
import com.crs.model.creation.GetDBUser;
import com.crs.model.creation.UpdatePassword;
import com.crs.util.Constants;
import com.crs.util.DateUtil;

@Repository("localDBUserDao")
public class LocalDBUserDAOImpl implements LocalDBUserDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private DateUtil dateUtil;

	@Override
	public List<GetDBUser> findAll() {
		String sql = "SELECT * from " + Constants.DB_USER_TABLE;
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		List<GetDBUser> list = new ArrayList<>();
		try {
			for (Map<String, Object> rs : rows) {
				GetDBUser user = new GetDBUser();
				user.setId((Integer) rs.get(Constants.ID));
				user.setUsername(rs.get(Constants.USERNAME).toString());
				user.setEmailId(rs.get(Constants.EMAIL_ID).toString());
				user.setFirstname((String) rs.get(Constants.FIRST_NAME));
				user.setLastname((String) rs.get(Constants.LAST_NAME));
				user.setCreatedOn((rs.get(Constants.CREATED_ON)).toString());
				user.setModifiedOn(rs.get(Constants.MODIFIED_ON).toString());
				user.setEnabled((Boolean) rs.get(Constants.IS_ENABLED));
				user.setDeleted((Boolean) rs.get(Constants.IS_DELETED));
				user.setTempPass((Boolean) rs.get(Constants.IS_TEMP_PASS));
				list.add(user);
			}
			return list;
		} catch (EmptyResultDataAccessException e) {
			return list;
		}
	}

	@Override
	public GetDBUser getUserById(int id) {
		String sql = "SELECT * FROM " + Constants.DB_USER_TABLE + " WHERE id=?";

		try {
			return jdbcTemplate.queryForObject(sql, new Object[] { id }, new int[] { Types.INTEGER },
					new RowMapper<GetDBUser>() {

						@Override
						public GetDBUser mapRow(ResultSet row, int rowNum) throws SQLException {
							GetDBUser user = new GetDBUser();
							user.setId(row.getInt(Constants.ID));
							user.setUsername(row.getString(Constants.USERNAME));
							user.setEmailId(row.getString(Constants.EMAIL_ID));
							user.setFirstname(row.getString(Constants.FIRST_NAME));
							user.setLastname(row.getString(Constants.LAST_NAME));
							user.setCreatedOn(row.getString(Constants.CREATED_ON));
							user.setModifiedOn(row.getString(Constants.MODIFIED_ON));
							user.setEnabled(row.getBoolean(Constants.IS_ENABLED));
							user.setDeleted(row.getBoolean(Constants.IS_DELETED));
							user.setTempPass(row.getBoolean(Constants.IS_TEMP_PASS));
							return user;
						}
					});
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

	}

	@Override
	public GetDBUser getUserByUserName(String username) {
		String sql = "SELECT * FROM " + Constants.DB_USER_TABLE + " WHERE username=?";
		try {
			return jdbcTemplate.queryForObject(sql, new Object[] { username }, new int[] { Types.VARCHAR },
					new RowMapper<GetDBUser>() {

						@Override
						public GetDBUser mapRow(ResultSet row, int rowNum) throws SQLException {
							GetDBUser user = new GetDBUser();
							user.setId(row.getInt(Constants.ID));
							user.setUsername(row.getString(Constants.USERNAME));
							user.setEmailId(row.getString(Constants.EMAIL_ID));
							user.setFirstname(row.getString(Constants.FIRST_NAME));
							user.setLastname(row.getString(Constants.LAST_NAME));
							user.setCreatedOn(row.getString(Constants.CREATED_ON));
							user.setModifiedOn(row.getString(Constants.MODIFIED_ON));
							user.setEnabled(row.getBoolean(Constants.IS_ENABLED));
							user.setDeleted(row.getBoolean(Constants.IS_DELETED));
							user.setTempPass(row.getBoolean(Constants.IS_TEMP_PASS));
							return user;
						}
					});

		} catch (EmptyResultDataAccessException e) {
			return null;
		}

	}

	@Transactional
	@Override
	public int deleteUserById(int id) {
		String sql="DELETE FROM "+Constants.DB_USER_TABLE+" WHERE id=?";
		return jdbcTemplate.update(sql, new Object[] {id}, new int[] {Types.INTEGER});
	
	}

	@Override
	public void addLocalDBUser(CreateDBUser user) {
		
		String sql="INSERT INTO "+Constants.DB_USER_TABLE+" (first_name,last_name,email_id,username,password,created_on,modified_on,"
				+ "is_enabled,is_deleted,is_temp_password,temp_password) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, new Object[] {user.getFirstname(),user.getLastname(),user.getEmailId(),user.getUsername(),user.getPassword(),
				dateUtil.getMySqlDate(new Date()),dateUtil.getMySqlDate(new Date()),true,false,false,null}, 
				new int[] {Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.TIMESTAMP,Types.TIMESTAMP,Types.BOOLEAN,Types.BOOLEAN,Types.BOOLEAN,Types.VARCHAR});
		
	}

	@Override
	public int updateUserPassword(UpdatePassword updatePassword) {
		String sql= "UPDATE "+Constants.DB_USER_TABLE+" SET password=?,modified_on=? WHERE username=?";
		return jdbcTemplate.update(sql,new Object[] {updatePassword.getNewPassword(),
				dateUtil.getMySqlDate(new Date()),updatePassword.getUsername() },
				new int[] {Types.VARCHAR,Types.TIMESTAMP,Types.VARCHAR});
	}

	@Override
	public String getUserPassword(String username) {
		
		String sql= "SELECT password from "+Constants.DB_USER_TABLE+" where username=?";
		try {
			String pass= jdbcTemplate.queryForObject(sql, new Object[] {username}, new int[] {Types.VARCHAR}, new RowMapper<String>() {

				@Override
				public String mapRow(ResultSet rs, int rowNum) throws SQLException {
					return rs.getString("password");
				}
			});
			return pass;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
}
