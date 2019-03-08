package com.metacube.EAD_Assignment_8.service;

import java.util.List;

import com.metacube.EAD_Assignment_8.model.User;


public interface UserService 
{
	//add the user into database with the help of object of Dao
	public boolean add(User user);
	
	//updates the user into database with the help of object of Dao
	public boolean update(User user);
	
	//returns the list of user(s) from database with the help of object of Dao
	public List<User> getAll();
	
	//delete the user from database with the help of object of Dao
	public boolean delete(int id);
	
	//returns the user of given id from database with the help of object of Dao
	public User getUserByID(int id);
	
	//returns the list of  user from database on the basis of search criteria with the help of object of Dao
	public List<User> search(String type, String value);

	
}
