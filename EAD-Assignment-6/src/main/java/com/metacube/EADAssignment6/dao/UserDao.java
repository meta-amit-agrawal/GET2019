package com.metacube.EADAssignment6.dao;

import java.util.List;

import com.metacube.EADAssignment6.model.User;


public interface UserDao 
{
	
		//to add user in database
		public boolean addUser(User user);
		
		//to delete user from database
		public boolean deleteUser(int id);
		
		//to update user in database
		public boolean updateUser(User user);
		
		//to get all the available user
		public List<User> getAllUser();
		
		//to search the user from database
		public List<User> search(String type , String value);
	
}
