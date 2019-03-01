package com.metacube.userdatabasemanagement.dao.implementation;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.userdatabasemanagement.dao.Query;
import com.metacube.userdatabasemanagement.dao.UserDao;
import com.metacube.userdatabasemanagement.mapper.UserMapper;
import com.metacube.userdatabasemanagement.model.User;


/**
 * UserDaoImplementation class implements the interface Userdao which contains some common method to perfrom some operations
 * @author admin
 *
 */

@Repository
public class UserDaoImplementation implements UserDao 
{
	//object of jdbcTemplate
	private JdbcTemplate jdbcTemplate;
	
	public UserDaoImplementation(DataSource dataSource)
	{
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	//add user to database
	public boolean addUser(User user)
	{
		return jdbcTemplate.update(Query.insertUser, user.getFirst_name(), user.getLast_name(), user.getContact_number(), user.getEmail()) > 0;
	}

	//delete user from database
	public boolean deleteUser(int id) 
	{
		return jdbcTemplate.update(Query.deleteUser, id) > 0;
	}

	//update user in database
	public boolean updateUser(User user) 
	{
		return jdbcTemplate.update(Query.updateUser, user.getFirst_name(), user.getLast_name(), user.getContact_number(), user.getEmail() , user.getId()) > 0;
	}

	//returns the list of users available in database
	public List<User> getAllUser()
	{
		return jdbcTemplate.query(Query.getAllUser, new UserMapper());
	}
	
	//searches the data from user with respect to given type
	public List<User> search(String type, String value) 
	{
		return jdbcTemplate.query(Query.search+type+" = '"+value+"'", new UserMapper());
	}

}
