package com.metacube.EADAssignment6.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.EADAssignment6.dao.Admindao;
import com.metacube.EADAssignment6.model.Login;
import com.metacube.EADAssignment6.service.AdminService;

@Service
public class AdminServiceImplementation implements AdminService 
{
	
	@Autowired
	private Admindao adminDao;

	//updates the password into database by calling admin dao class
	@Override
	public boolean updatePassword(Login login) 
	{
		return adminDao.updatePassword(login);
	}

	//gets the login details verified from database
	@Override
	public boolean getAdmin(Login login) 
	{
		Login admin = adminDao.getLoginbyUserName(login.getUsername());
		if(admin.getPassword().equals(login.getPassword()))
				return true;
		return false;
	}
	
	
}
