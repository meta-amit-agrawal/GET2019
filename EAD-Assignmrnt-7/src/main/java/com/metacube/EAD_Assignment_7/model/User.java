package com.metacube.EAD_Assignment_7.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="user")
public class User 
{
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "first_name")
	private String first_name;
	
	@Column(name = "last_name")
	private String last_name;
	
	@Column(name = "contact_number")
	private String contact_number;
	
	@Column(name = "email")
	private String email;
	
	//returns the id of the user
	public int getId() 
	{
		return id;
	}
	
	//sets the id of the user
	public void setId(int id) 
	{
		this.id = id;
	}
	
	//returns the first name of the user
	public String getFirst_name() 
	{
		return first_name;
	}
	
	//sets the first name of the user
	public void setFirst_name(String first_name) 
	{
		this.first_name = first_name;
	}
	
	//returns the last name of the user
	public String getLast_name() 
	{
		return last_name;
	}
	
	//sets the last name of the user
	public void setLast_name(String last_name) 
	{
		this.last_name = last_name;
	}
	
	//returns the contact number of the user
	public String getContact_number() 
	{
		return contact_number;
	}
	
	//sets the contact number of the user
	public void setContact_number(String contact_number) 
	{
		this.contact_number = contact_number;
	}
	
	//returns the email of the user
	public String getEmail() 
	{
		return email;
	}
	
	//sets the email of the user
	public void setEmail(String email) 
	{
		this.email = email;
	}
	
}
