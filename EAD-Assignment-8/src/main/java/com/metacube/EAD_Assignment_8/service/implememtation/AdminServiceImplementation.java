package com.metacube.EAD_Assignment_8.service.implememtation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.EAD_Assignment_8.model.Login;
import com.metacube.EAD_Assignment_8.repository.AdminRepo;
import com.metacube.EAD_Assignment_8.service.AdminService;



@Service
public class AdminServiceImplementation implements AdminService
{
	//object of Admin repo class
	@Autowired
	AdminRepo adminRepo;

	//updates the admin password into the database
	@Override
	@Transactional
	public boolean updatePassword(Login login) 
	{
		adminRepo.save(login);
		return true;
	}

	//returns true of admin with username and password matches or false if not
	@Override
	@Transactional
	public boolean getAdmin(Login login) 
	{
		Login l = null;
		l = adminRepo.findOne(login.getUsername());
		if(l!=null)
		{
			if(login.getPassword().equals(l.getPassword()))
				return true;
		}
		return false;
		
	}
	

}
