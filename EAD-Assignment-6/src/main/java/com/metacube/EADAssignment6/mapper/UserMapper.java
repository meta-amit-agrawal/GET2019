package com.metacube.EADAssignment6.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.EADAssignment6.model.User;


/**
 * Maps the data extracted from database to user object
 * @author admin
 *
 */
public class UserMapper implements RowMapper<User> {

	public User mapRow(ResultSet rs, int i) throws SQLException {
		// TODO Auto-generated method stub
		User user =new User();
		user.setId(rs.getInt(1));
		user.setFirst_name(rs.getString(2));
		user.setLast_name(rs.getString(3));
		user.setContact_number(rs.getString(4));
		user.setEmail(rs.getString(5));
		return user;	
	}
}
