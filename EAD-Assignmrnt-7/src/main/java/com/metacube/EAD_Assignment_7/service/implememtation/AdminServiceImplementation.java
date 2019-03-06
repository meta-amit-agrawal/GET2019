package com.metacube.EAD_Assignment_7.service.implememtation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.EAD_Assignment_7.dao.Admindao;
import com.metacube.EAD_Assignment_7.model.Login;
import com.metacube.EAD_Assignment_7.service.AdminService;

@Service
public class AdminServiceImplementation implements AdminService
{
	@Autowired
	private Admindao adminDao;

	//updates the password into database by calling admin dao class
	@Override
	public boolean updatePassword(Login login) {
		// TODO Auto-generated method stub
		return adminDao.updatePassword(login);
	}

	//gets the login details verified from database
	@Override
	public boolean getAdmin(Login login) {
		// TODO Auto-generated method stub
		Login admin = adminDao.getLoginbyUserName(login.getUsername());
		if(admin.getPassword().equals(login.getPassword()))
				return true;
		return false;
	}

}
