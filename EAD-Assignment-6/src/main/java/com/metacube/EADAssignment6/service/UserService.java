package com.metacube.EADAssignment6.service;

import java.util.List;

import com.metacube.EADAssignment6.model.User;


//interface UserService which contains some methods to perform some operation 
public interface UserService {
	
	public boolean add(User employee);
	
	public boolean update(User employee);
	
	public List<User> getAll();
	
	public boolean delete(int id);
	
	public User getUserByID(int id);
	
	public List<User> search(String type, String value);

}
