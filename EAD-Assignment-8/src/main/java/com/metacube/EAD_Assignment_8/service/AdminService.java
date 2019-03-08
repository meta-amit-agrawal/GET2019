package com.metacube.EAD_Assignment_8.service;

import com.metacube.EAD_Assignment_8.model.Login;


public interface AdminService 
{
	
		//updates password to admin database
		public boolean updatePassword(Login login);
		
		//gets the login details from the database
		public boolean getAdmin(Login login);

	
}
