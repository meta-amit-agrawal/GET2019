package com.metacube.restful.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.restful.enums.StatusEnums;
import com.metacube.restful.model.Category;
/**
 * CategoryDao class gets the connection with database and performs the operations on database(add, put, post, delete)
 * @author admin
 *
 */
public class CategoryDao {
	
	private Connection connection = ConnectionToDB.getConnection();
	
	/**
	 * inserts the category into the database in which the id of category ie primary key
	 * @param category
	 * @return status inserted if category is inserted
	 */
	public StatusEnums insertCategory(Category category)
	{
		PreparedStatement preparedStatement;
		try 
		{
			//executes the query
			preparedStatement = connection.prepareStatement(Query.insertCategory);
			preparedStatement.setInt(1, category.getId());
			preparedStatement.setString(2, category.getName());
			if(preparedStatement.executeUpdate()>0)
			{
				return StatusEnums.INSERTED;
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return StatusEnums.NOTINSERTED;
	}
	
	/**
	 * updates the name of the category of given id
	 * @param id
	 * @param name
	 * @return status updated if name of category is updated
	 */
	public StatusEnums updateName(int id, String name)
	{
		try 
		{
			//executes the query
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
	
	/**
	 * to get the list of all the category available in the database
	 * @return the list of category
	 */
	public List<Category> getAllCategory()
	{
		List<Category> categoryList=new ArrayList<Category>();
		try 
		{
			//executes the query
			PreparedStatement preparedStatement = connection.prepareStatement(Query.getAllCategory);
			ResultSet resultSet = preparedStatement.executeQuery();
			//stores the result into list
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
