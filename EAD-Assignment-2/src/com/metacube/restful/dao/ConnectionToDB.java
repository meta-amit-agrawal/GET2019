package com.metacube.restful.dao;
import java.sql.*;

import com.metacube.restful.dao.UtilityDB;

public class ConnectionToDB {
	
	
	public static Connection getConnection()
	{	
		Connection connection = null;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(UtilityDB.dbURL+UtilityDB.dbName, UtilityDB.dbUser, UtilityDB.dbPassword);
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return connection;
	}
}
