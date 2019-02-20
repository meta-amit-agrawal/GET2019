package com.metacube.shoppingcart.Facade;

import java.util.List;

import com.metacube.shoppingcart.Dao.UserDao;
import com.metacube.shoppingcart.Model.User;
import com.metacube.shoppingcart.enums.status;

public class UserFacade {
	
	UserDao userDao = UserDao.getInstance();
	List<User> existingUser = userDao.getAllUser();
	
	
	public status addUser(User user)
	{
		for(User u : existingUser)
		{
			if(u.getUser_id()==user.getUser_id())
			{
				return status.DUPLICATE;
			}
		}
		userDao.add(user);
		return status.SUCCESSFULL;
	}
	
	public status deleteUser(User user)
	{
		for(User u : existingUser)
		{
			if(u.getUser_id()==user.getUser_id())
			{
				userDao.delete(user);
				return status.SUCCESSFULL;
			}
		}
		return status.NOTEXISTS;
	}
	
	public List<User> getAllUser()
	{
		return userDao.getAllUser();
	}
	
	public User getUserByID(int id)
	{
		for(User u : existingUser)
		{
			if(u.getUser_id() == id)
			{
				return u;
			}
		}
		return null;
	}
	

}
