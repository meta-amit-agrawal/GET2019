package com.metacube.EADAssignment6.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.EADAssignment6.model.Login;


//maps the result set data into the login class model
public class LoginMapper implements RowMapper<Login> 
{

	@Override
	public Login mapRow(ResultSet arg0, int arg1) throws SQLException 
	{
		Login login = new Login();
		login.setUsername(arg0.getString(1));
		login.setPassword(arg0.getString(2));
		return login;
	}

}
