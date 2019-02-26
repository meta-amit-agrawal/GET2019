package com.metacube.restful.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.restful.enums.StatusEnums;
import com.metacube.restful.model.Category;

public class CategoryDao {
	
	private Connection connection = ConnectionToDB.getConnection();
	
	
	public StatusEnums insertCategory(Category category)
	{
		PreparedStatement preparedStatement;
		try 
		{
			preparedStatement = connection.prepareStatement(Query.insertCategory);
			preparedStatement.setInt(1, category.getId());
			preparedStatement.setString(2, category.getName());
			if(preparedStatement.executeUpdate()>0)
			{
				System.out.println("Inserted");
				return StatusEnums.INSERTED;
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return StatusEnums.NOTINSERTED;
	}
	
	
	public StatusEnums updateName(int id, String name)
	{
		try 
		{
			PreparedStatement preparedStatement = connection.prepareStatement(Query.updateCategoryName);
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, id);
			if(preparedStatement.executeUpdate()>0)
			{
				return StatusEnums.UPDATED;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return StatusEnums.NOTUPDATED;
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
		System.out.println("category list returned "+categoryList.size());
		return categoryList;
	}
	
}
