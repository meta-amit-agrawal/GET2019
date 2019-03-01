package com.metacube.userdatabasemanagement.service;

import java.util.List;

import com.metacube.userdatabasemanagement.model.User;

public interface UserService {
	
	public boolean add(User employee);
	
	public boolean update(User employee);
	
	public List<User> getAll();
	
	public boolean delete(int id);
	
	public User getUserByID(int id);
	
	/*public List<User> getUserByFirstName(String first_name);
	
	public List<User> getUserByLastName(String last_name);
	
	public List<User> getUserByEmail(String email);
	
	public List<User> getUserbyContact(String Contact);*/
	
	public List<User> serach(String type, String value);

}
