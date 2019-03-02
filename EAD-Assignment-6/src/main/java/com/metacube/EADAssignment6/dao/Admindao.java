package com.metacube.EADAssignment6.dao;


import com.metacube.EADAssignment6.model.Login;

public interface Admindao 
{
	//updates the password into database
	public boolean updatePassword(Login login);
	
	//gets the login details from tha database
	public Login getLoginbyUserName(String username);
	
}
