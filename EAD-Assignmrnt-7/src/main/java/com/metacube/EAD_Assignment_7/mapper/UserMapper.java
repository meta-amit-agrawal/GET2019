package com.metacube.EAD_Assignment_7.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.EAD_Assignment_7.model.User;


public class UserMapper  implements RowMapper<User> 
{

	@Override
	public User mapRow(ResultSet rs, int arg1) throws SQLException {
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
