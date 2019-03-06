package com.metacube.EAD_Assignment_7.service.implememtation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.EAD_Assignment_7.dao.UserDao;
import com.metacube.EAD_Assignment_7.model.User;
import com.metacube.EAD_Assignment_7.service.UserService;

/**
 * UserServiceImplementation provides service to the controller layer of the application which uses the object of UserDao
 * @author admin
 *
 */

@Service
public class UserServiceImplementation implements UserService{

	//object of UserDao layer to perform the operations
	@Autowired
	private UserDao userDao;
	
	//add the user passed in the parameter to the database
	@Override
	public boolean add(User user) {
		// TODO Auto-generated method stub
		return userDao.addUser(user);
	}

	//update the user passed in the parameter in the database
	@Override
	public boolean update(User user) {
		// TODO Auto-generated method stub
		return userDao.updateUser(user);
	}

	//returns the list of the users from the database
	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userDao.getAllUser();
	}

	//deletes the user of given user id from the database
	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		User user = getUserByID(id);
		return userDao.deleteUser(user);
	}

	//returns the reference of the user of given user id from the database
	@Override
	public User getUserByID(int id) {
		// TODO Auto-generated method stub
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

	//performs the search operation with reference to type given and searches for the value given
	@Override
	public List<User> search(String type, String value) {
		// TODO Auto-generated method stub
		return userDao.search(type, value);
	}

}
