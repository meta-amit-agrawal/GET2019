package com.metacube.EADAssignment6.dao.implementation;


import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.EADAssignment6.dao.Admindao;
import com.metacube.EADAssignment6.dao.Query;
import com.metacube.EADAssignment6.mapper.LoginMapper;
import com.metacube.EADAssignment6.model.Login;

@Repository
public class AdminDaoImplementation implements Admindao 
{
	
	private JdbcTemplate jdbcTemplate;
	
	public AdminDaoImplementation(DataSource dataSource) 
	{
		jdbcTemplate = new JdbcTemplate(dataSource); 
	}

	//updates the password into the database
	@Override
	public boolean updatePassword(Login login) 
	{
		return jdbcTemplate.update(Query.updateAdmin, login.getPassword(), login.getUsername())>0;
	}

	//gets the login details from the database
	@Override
	public Login getLoginbyUserName(String username) 
	{
		return jdbcTemplate.queryForObject(Query.getAdmin+"'"+ username+"';", new LoginMapper() );
	}
	
	
	
}
