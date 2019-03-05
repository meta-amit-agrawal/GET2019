package com.metacube.EAD_Assignment_7.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.EAD_Assignment_7.model.Login;

public class LoginMapper implements RowMapper<Login> 
{

	@Override
	public Login mapRow(ResultSet arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		Login login = new Login();
		login.setUsername(arg0.getString(1));
		login.setPassword(arg0.getString(2));
		return login;
	}
	
	
	
}
