package com.metacube.restful.facade;

import java.sql.SQLException;
import java.util.List;

import com.metacube.restful.dao.AdvertisementDao;
import com.metacube.restful.enums.StatusEnums;
import com.metacube.restful.model.Advertisement;
import com.metacube.restful.model.CategoryAdvertsiement;


/**
 * Advertisement Facade class uses the object of Advertisement Dao to performs the operations 
 * @author admin
 *
 */
public class AdvertisementFacade {
	
	AdvertisementDao advertisementDao = new AdvertisementDao();
	
	
	// returns the list of all advertisement available in the database
	public List<Advertisement> getAllAdvertisements()
	{
		return advertisementDao.getAllAdvertisement();
	}
	
	// returns the list of advertisement of given category id
	public CategoryAdvertsiement getAdvertisementByCategoryID(int category_id)
	{
		return advertisementDao.getAdvertisementBycategoryID(category_id);
	}
	
	//inserts the advertisement into database 
	public StatusEnums insertAdvertisement(Advertisement advertisement) throws SQLException
	{
		try
		{
			return advertisementDao.addAvertisement(advertisement);
		}
		catch (SQLException e) 
		{
			throw e;
		}
	}
	
	//updates the name of the advertisement with given name of given advertisement id
	public StatusEnums updateAdvertsement(int id, String name)
	{
		return advertisementDao.updateName(id, name);
	}
	
	//deletes the advertisement of given advertisement id
	public StatusEnums deleteAdvertisement(int id)
	{
		return advertisementDao.deleteAdvertisement(id);
	}
	
	

}
