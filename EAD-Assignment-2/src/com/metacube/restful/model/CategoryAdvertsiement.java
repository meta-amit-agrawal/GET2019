package com.metacube.restful.model;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdvertsiement {
	
	
	int category_id;
	List<Advertisement> advertisementList = new ArrayList<Advertisement>();
	
	
	
	public CategoryAdvertsiement(int category_id, List<Advertisement> advertisementList) {
		super();
		this.category_id = category_id;
		this.advertisementList = advertisementList;
	}


	public int getCategory_id() {
		return category_id;
	}
	
	
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	
	
	public List<Advertisement> getAdvertisementList() {
		return advertisementList;
	}
	
	
	public void setAdvertisementList(List<Advertisement> advertisementList) {
		this.advertisementList = advertisementList;
	}
	
	
	

}
