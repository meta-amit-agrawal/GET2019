package com.metacube.EAD_Assignment_7.dao;

import com.metacube.EAD_Assignment_7.model.Login;


public interface Admindao 
{
		//updates the password into database
		public boolean updatePassword(Login login);
		
		//gets the login details from the database
		public Login getLoginbyUserName(String username);
	
	
}
