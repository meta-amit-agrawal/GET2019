package com.metacube.EAD_Assignment_8.service.implememtation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.EAD_Assignment_8.model.User;
import com.metacube.EAD_Assignment_8.repository.UserRepo;
import com.metacube.EAD_Assignment_8.service.UserService;

/**
 * UserServiceImplementation provides service to the controller layer of the application which uses the object of User Repo
 * @author admin
 *
 */

@Service
public class UserServiceImplementation implements UserService
{
	//object of user repo class
	@Autowired
	UserRepo userRepo;

	//add the user into the database
	@Override
	@Transactional
	public boolean add(User user)
	{
		userRepo.save(user);
		return true;
	}

	//updates the user details into the database
	@Override
	@Transactional
	public boolean update(User user) 
	{
		userRepo.save(user);
		return true;
	}

	//returns the list of the users available into the database
	@Override
	@Transactional
	public List<User> getAll() 
	{
		return userRepo.findAll();
	}

	//deletes the user of given user id from the database
	@Override
	@Transactional
	public boolean delete(int id) 
	{
		userRepo.delete(id);
		return true;
	}

	//returns the user of given user id from the database
	@Override
	@Transactional
	public User getUserByID(int id) 
	{
		return userRepo.findOne(id);
	}

	//searches for the users according to the given type and the value to be searched for
	@Override
	@Transactional
	public List<User> search(String type, String value) 
	{
		if("first_name".equals(type))
		{
			return userRepo.findByfirst_name(value);
		}
		if("last_name".equals(type))
		{
			return userRepo.findBylast_name(value);
		}
		if("contact_number".equals(type))
		{
			return userRepo.findBycontact_number(value);
		}
		if("email".equals(type))
		{
			return userRepo.findByemail(value);
		}
		return null;
	}
}
