package com.metacube.restful.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.restful.enums.Status;
import com.metacube.restful.model.Advertisement;

public class AdvertisementDao {
	
	Connection connection=ConnectionToDB.getConnection();
	
	public Status addAvertisement(Advertisement advertisement) throws SQLException
	{
		try 
		{
			PreparedStatement preparedStatement = connection.prepareStatement(Query.insertAdvertisement);
			preparedStatement.setInt(1, advertisement.getId());
			preparedStatement.setString(2, advertisement.getName());
			preparedStatement.setString(3, advertisement.getDescription());
			preparedStatement.setInt(4, advertisement.getCategory_id());
			if(preparedStatement.executeUpdate()>0)
			{
				return Status.INSERTED;
			}
		}
		catch (SQLException e) 
		{
			throw e;
		}
		return Status.NOTINSERTED;
	}
	
	public Status deleteAdvertisement(int advertisementID)
	{
		try 
		{
			PreparedStatement preparedStatement = connection.prepareStatement(Query.deleteAdvertisement);
			preparedStatement.setInt(1, advertisementID);
			if(preparedStatement.executeUpdate()>0)
			{
				return Status.DELETED;
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return Status.NOTDELETED;
		
	}
	
	public List<Advertisement> getAllAdvertisement()
	{
		List<Advertisement> advertisementist = new ArrayList<Advertisement>();
		try 
		{
			PreparedStatement preparedStatement = connection.prepareStatement(Query.getAllAdvertisement);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				Advertisement advertisement = new Advertisement(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getString("description"), resultSet.getInt("category_id"));
				advertisementist.add(advertisement);
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return advertisementist;
	}
	
	public Advertisement getAdvertisementBycategoryID(int categoryID)
	{
		Advertisement advertisement = null;
		try 
		{
			PreparedStatement preparedStatement = connection.prepareStatement(Query.getAdvertisementByCategoryID);
			preparedStatement.setInt(1, categoryID);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				advertisement = new Advertisement(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getString("description"), resultSet.getInt("category_id"));
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return advertisement;
	}
	
	public Status updateName(int id, String name)
	{
		try 
		{
			PreparedStatement preparedStatement = connection.prepareStatement(Query.updateAdvertisementName);
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

	
	public static void main(String args[])
	{
		AdvertisementDao advertisementDao = new AdvertisementDao();
		try {
			advertisementDao.addAvertisement(new Advertisement(2, "home", "home on sale", 1));
			System.out.println("Inserted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
