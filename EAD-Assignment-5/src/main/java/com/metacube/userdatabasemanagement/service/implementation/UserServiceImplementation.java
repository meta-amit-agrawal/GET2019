package com.metacube.userdatabasemanagement.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.userdatabasemanagement.dao.UserDao;
import com.metacube.userdatabasemanagement.model.User;
import com.metacube.userdatabasemanagement.service.UserService;

@Service
public class UserServiceImplementation implements UserService 
{

	@Autowired
	private UserDao userDao;
	
	
	public boolean add(User user) 
	{
		return userDao.addUser(user);
	}

	public boolean update(User user)
	{
		return userDao.updateUser(user);
	}

	public List<User> getAll() 
	{
		return userDao.getAllUser();
	}

	public boolean delete(int id)
	{
		return userDao.deleteUser(id);
	}
	
	public User getUserByID(int id)
	{
		List<User> userList = getAll();
		for(User u : userList)
		{
			if(u.getId() == id)
			{
				return u;
			}
		}
		return null;
	}

	public List<User> serach(String type, String value) 
	{
		return userDao.search(type, value);
	}

	/*public List<User> getUserByFirstName(String first_name)
	{
		List<User> userList = getAll();
		List<User> result = new ArrayList<User>();
		for(User u : userList)
		{
			if(u.getFirst_name().equalsIgnoreCase(first_name))
			{
				result.add(u);
			}
		}
		return result;
	}

	public List<User> getUserByLastName(String last_name)
	{
		List<User> userList = getAll();
		List<User> result = new ArrayList<User>();
		for(User u : userList)
		{
			if(u.getLast_name().equalsIgnoreCase(last_name))
			{
				result.add(u);
			}
		}
		return result;
	}

	public List<User> getUserByEmail(String email)
	{
		List<User> userList = getAll();
		List<User> result = new ArrayList<User>();
		for(User u : userList)
		{
			if(u.getEmail().equalsIgnoreCase(email))
			{
				result.add(u);
			}
		}
		return result;
	}

	public List<User> getUserbyContact(String Contact)
	{
		List<User> userList = getAll();
		List<User> result = new ArrayList<User>();
		for(User u : userList)
		{
			if(u.getContact_number().equalsIgnoreCase(Contact))
			{
				result.add(u);
			}
		}
		return result;
	}*/
	
	

}
