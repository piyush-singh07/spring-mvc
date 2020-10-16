package com.crs.daoimpl;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.crs.dao.UserRoleDAO;
import com.crs.model.user.CreateRole;
import com.crs.model.user.GetRole;
import com.crs.util.Constants;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@Repository("userRoleDAO")
public class UserRoleDAOImpl implements UserRoleDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<GetRole> getUserRole() {
		String sql="SELECT * FROM "+Constants.ROLES_TABLE;
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		List<GetRole> list = new ArrayList<>();
		try {
			for (Map<String, Object> rs : rows) {
				GetRole role= new GetRole();
				role.setId((Integer)rs.get(Constants.ID));
				role.setRole(rs.get(Constants.ROLE).toString());
				role.setDescription(rs.get(Constants.DESCRIPTION).toString());
				list.add(role);
			}
			return list;
			
		} catch (EmptyResultDataAccessException e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public void createUserRole(CreateRole createRole) {
		String sql="INSERT INTO "+Constants.ROLES_TABLE+" (role,description) VALUES (?,?) ";
		 jdbcTemplate.update(sql, new Object[] {createRole.getRole(), createRole.getDescription()},
				new int[] {Types.VARCHAR,Types.VARCHAR});
	}

	@Override
	public int deleteUserRole(int id) {
		String sql="DELETE FROM "+Constants.ROLES_TABLE+" WHERE id=?";
		return jdbcTemplate.update(sql, new Object[] {id}, new int[] {Types.INTEGER});
	}

}
