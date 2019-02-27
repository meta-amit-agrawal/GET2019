package com.metacube.restful.model;

import java.util.ArrayList;
import java.util.List;
/**
 * CategoryAdvertisement class used as a model class with defined properties
 * @author admin
 *
 */
public class CategoryAdvertsiement {
	
	
	int category_id;
	List<Advertisement> advertisementList = new ArrayList<Advertisement>();
	
	//parameterized constructor
	public CategoryAdvertsiement(int category_id, List<Advertisement> advertisementList) {
		super();
		this.category_id = category_id;
		this.advertisementList = advertisementList;
	}

	//returns the category id
	public int getCategory_id() {
		return category_id;
	}
	
	//returns the list of advertisement
	public List<Advertisement> getAdvertisementList() {
		return advertisementList;
	}

}
