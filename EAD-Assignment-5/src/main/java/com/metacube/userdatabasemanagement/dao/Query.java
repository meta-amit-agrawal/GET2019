package com.metacube.userdatabasemanagement.dao;

public class Query {
	
	
	public static final String getUserByFirstName = "select * from user where first_name = ?;";
	
	public static final String getUserByLastName = "select * from user where email = ?;";
	
	public static final String getUserByContact = "select * from user where contact_no = ?;";
	
	public static final String getUserByEmail = "select * from user where email = ?;";
	
	public static final String getAllUser = "select * from user;";
	
	public static final String updateUser = "update user set first_name = ?, last_name = ?, contact_no  = ?, email  = ? where id = ?;";
	
	public static final String deleteUser = "delete from user where id = ?;";
	
	public static final String insertUser = "insert into user (first_name, last_name, contact_no, email) values(?,?,?,?);";
	
	
}
