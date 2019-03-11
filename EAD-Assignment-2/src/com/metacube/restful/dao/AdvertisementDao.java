package com.metacube.restful.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.restful.enums.StatusEnums;
import com.metacube.restful.model.Advertisement;
import com.metacube.restful.model.CategoryAdvertsiement;

/**
 * AdvertisementDao class gets the connection with database and performs the operations on database(add, put, post, delete)
 * @author admin
 *
 */
public class AdvertisementDao {
	
	private Connection connection=ConnectionToDB.getConnection();
	
	/**
	 * addAdvertisement method add the advertisement in the database (id is primary key and category_id is foreign key)
	 * @param advertisement
	 * @return status inserted if advertisement is inserted 
	 * @throws SQLException if category id doesn't exists
	 */
	public StatusEnums addAvertisement(Advertisement advertisement) throws SQLException
	{
		try 
		{
			//execute the query
			PreparedStatement preparedStatement = connection.prepareStatement(Query.insertAdvertisement);
			preparedStatement.setInt(1, advertisement.getId());
			preparedStatement.setString(2, advertisement.getName());
			preparedStatement.setString(3, advertisement.getDescription());
			preparedStatement.setInt(4, advertisement.getCategory_id());
			if(preparedStatement.executeUpdate()>0)
			{
				return StatusEnums.INSERTED;
			}
		}
		catch (SQLException e) 
		{
			throw e;
		}
		return StatusEnums.NOTINSERTED;
	}
	
	
	/**
	 * deleteAdvertisement method deletes the advertisement of the given id
	 * @param advertisementID
	 * @return status DELETED if advertisement is deleted
	 */
	public StatusEnums deleteAdvertisement(int advertisementID)
	{
		try 
		{
			//executes the query
			PreparedStatement preparedStatement = connection.prepareStatement(Query.deleteAdvertisement);
			preparedStatement.setInt(1, advertisementID);
			if(preparedStatement.executeUpdate()>0)
			{
				return StatusEnums.DELETED;
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return StatusEnums.NOTDELETED;
		
	}
	
	/**
	 * getAllAdvertisement method returns the list of advertisement available in the database
	 * @return the list of advertisement
	 */
	public List<Advertisement> getAllAdvertisement()
	{
		List<Advertisement> advertisementList = new ArrayList<Advertisement>();
		try 
		{
			//executes the query
			PreparedStatement preparedStatement = connection.prepareStatement(Query.getAllAdvertisement);
			ResultSet resultSet = preparedStatement.executeQuery();
			//stores the result into list
			while(resultSet.next())
			{
				Advertisement advertisement = new Advertisement(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getString("description"), resultSet.getInt("category_id"));
				advertisementList.add(advertisement);
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return advertisementList;
	}
	
	/**
	 * getAdvertisementBycategoryID method finds the list of advertisement related to given category id
	 * @param categoryID
	 * @return the object CategoryAdvertisement which contains the category and list if advertsiement
	 */
	public CategoryAdvertsiement getAdvertisementBycategoryID(int categoryID)
	{
		List<Advertisement> advertisementList = new ArrayList<Advertisement>();
		Advertisement advertisement = null;
		CategoryAdvertsiement categoryAdvertisement = null;
		try 
		{
			//executes the query
			PreparedStatement preparedStatement = connection.prepareStatement(Query.getAdvertisementByCategoryID);
			preparedStatement.setInt(1, categoryID);
			ResultSet resultSet = preparedStatement.executeQuery();
			//stores the result into list
			while(resultSet.next())
			{
				advertisement = new Advertisement(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getString("description"), resultSet.getInt("category_id"));
				advertisementList.add(advertisement);
			}
			categoryAdvertisement = new CategoryAdvertsiement(categoryID,advertisementList);
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return categoryAdvertisement;
	}
	
	
	/**
	 * updateName update the name of the advertisement of given id of the advertisement
	 * @param id
	 * @param name
	 * @return status updated if name is updated
	 */
	public StatusEnums updateName(int id, String name)
	{
		try 
		{
			//executes the query
			PreparedStatement preparedStatement = connection.prepareStatement(Query.updateAdvertisementName);
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

}
