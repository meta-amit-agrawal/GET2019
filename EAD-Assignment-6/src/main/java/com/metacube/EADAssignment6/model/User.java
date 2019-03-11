package com.metacube.EADAssignment6.model;

public class User 
{
	
	private int id;
	private String first_name;
	private String last_name;
	private String contact_number;
	private String email;

	//returns the id of the user
	public int getId() {
		return id;
	}

	//returns the first name of the user
	public String getFirst_name() {
		return first_name;
	}

	//returns the last name of the user
	public String getLast_name() {
		return last_name;
	}

	//returns the contact number of the user
	public String getContact_number() {
		return contact_number;
	}

	//returns the email of the user
	public String getEmail() {
		return email;
	}

	//sets the id of the user
	public void setId(int id) {
		this.id = id;
	}

	//sets the first_name of the user
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	//sets the last_name of the user
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	//sets the contact_number of the user
	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}

	//sets the email of the user
	public void setEmail(String email) {
		this.email = email;
	}
	
}
