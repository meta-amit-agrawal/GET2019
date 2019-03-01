package com.metacube.userdatabasemanagement.dao.implementation;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.userdatabasemanagement.dao.Query;
import com.metacube.userdatabasemanagement.dao.UserDao;
import com.metacube.userdatabasemanagement.mapper.UserMapper;
import com.metacube.userdatabasemanagement.model.User;



@Repository
public class UserDaoImplementation implements UserDao 
{
	
	private JdbcTemplate jdbcTemplate;
	
	public UserDaoImplementation(DataSource dataSource)
	{
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public boolean addUser(User user)
	{
		return jdbcTemplate.update(Query.insertUser, user.getFirst_name(), user.getLast_name(), user.getContact_number(), user.getEmail()) > 0;
	}

	public boolean deleteUser(int id) 
	{
		return jdbcTemplate.update(Query.deleteUser, id) > 0;
	}

	public boolean updateUser(User user) 
	{
		return jdbcTemplate.update(Query.updateUser, user.getFirst_name(), user.getLast_name(), user.getContact_number(), user.getEmail() , user.getId()) > 0;
	}

	public List<User> getAllUser()
	{
		return jdbcTemplate.query(Query.getAllUser, new UserMapper());
	}
	
	
	/*public User getUserByID(int id)
	{
		List<User> userList = getAllUser();
		for(User u : userList)
		{
			if(u.getId() == id)
			{
				return u;
			}
		}
		return null;
	}*/

	public List<User> search(String type, String value) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(Query.search+type+" = '"+value+"'", new UserMapper());
	}

}
