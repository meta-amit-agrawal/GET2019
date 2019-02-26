package com.metacube.restful.facade;

import java.util.List;

import com.metacube.restful.dao.AdvertisementDao;
import com.metacube.restful.model.Advertisement;

public class AdvertisementFacade {
	
	AdvertisementDao advertisementDao = new AdvertisementDao();
	
	public List<Advertisement> getAllAdvertisements()
	{
		return advertisementDao.getAllAdvertisement();
	}
	
	public List<Advertisement> getAdvertisementByCategoryID(int category_id)
	{
		return advertisementDao.getAdvertisementBycategoryID(category_id);
	}

}
