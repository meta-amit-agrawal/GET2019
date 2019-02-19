package com.metacube.shoppingcart.Model;

public class User {
	
	int user_id;
	String user_name;
	
	public User(int user_id, String user_name){
		this.user_id = user_id;
		this.user_name = user_name;
	}

	public int getUser_id() {
		return user_id;
	}

	public String getUser_name() {
		return user_name;
	}

}
