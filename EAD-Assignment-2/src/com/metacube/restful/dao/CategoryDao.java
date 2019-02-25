package com.metacube.restful.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.restful.enums.Status;
import com.metacube.restful.model.Category;

public class CategoryDao {
	
	private Connection connection = ConnectionToDB.getConnection();
	
	
	public Status updateName(int id, String name)
	{
		try 
		{
			PreparedStatement preparedStatement = connection.prepareStatement(Query.updateCategoryName);
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, id);
			if(preparedStatement.executeUpdate()>0)
			{
				return Status.UPDATED;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return Status.NOTUPDATED;
	}
	
	public List<Category> getAllCategory()
	{
		List<Category> categoryList=new ArrayList<Category>();
		try 
		{
			PreparedStatement preparedStatement = connection.prepareStatement(Query.getAllCategory);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				Category category = new Category(resultSet.getInt("id"), resultSet.getString("name"));
				categoryList.add(category);
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return categoryList;
	}

}
