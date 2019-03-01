package com.metacube.userdatabasemanagement.dao;

import java.util.List;

import com.metacube.userdatabasemanagement.model.User;

public interface UserDao {
	
	public boolean addUser(User user);
	
	public boolean deleteUser(int id);
	
	public boolean updateUser(User user);
	
	public List<User> getAllUser();
	
	public List<User> search(String type , String value);
	

}
