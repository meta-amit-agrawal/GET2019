package com.metacube.shoppingcart.Dao;

import java.util.ArrayList;
import java.util.List;

import com.metacube.shoppingcart.Model.User;

public class UserDao implements BaseDao<User> {
	
	
	private List<User> userList = new ArrayList<User>();
	
	private static UserDao userDao_Object = null;
	private UserDao(){	}
	
	public static UserDao getInstance()
	{
		if(userDao_Object == null)
		{
			userDao_Object = new UserDao();
		}
		return userDao_Object;
	}
	
	public List<User> getAllUser()
	{
		return userList;
	}


	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		userList.add(user);
	}


	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		userList.remove(user);
	}


	@Override
	public void update(User user, User updated) {
		// TODO Auto-generated method stub
		int index;
		index=userList.indexOf(user);
		userList.add(index,updated);
	}
	
	
	

}
