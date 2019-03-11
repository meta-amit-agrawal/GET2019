package com.metacube.EAD_Assignment_7.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Login 
{
	@Id
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	//returns the user name 
	public String getUsername() 
	{
		return username;
	}
	
	//sets the user name
	public void setUsername(String username) 
	{
		this.username = username;
	}
	
	//returns the password
	public String getPassword() 
	{
		return password;
	}
	
	//sets the password
	public void setPassword(String password) 
	{
		this.password = password;
	}
	
}
