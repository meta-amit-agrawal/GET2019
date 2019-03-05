package com.metacube.EAD_Assignment_7.service.implememtation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.EAD_Assignment_7.dao.UserDao;
import com.metacube.EAD_Assignment_7.model.User;
import com.metacube.EAD_Assignment_7.service.UserService;

@Service
public class UserServiceImplementation implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public boolean add(User user) {
		// TODO Auto-generated method stub
		return userDao.addUser(user);
	}

	@Override
	public boolean update(User user) {
		// TODO Auto-generated method stub
		return userDao.updateUser(user);
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userDao.getAllUser();
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return userDao.deleteUser(id);
	}

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

	@Override
	public List<User> search(String type, String value) {
		// TODO Auto-generated method stub
		return userDao.search(type, value);
	}

}
