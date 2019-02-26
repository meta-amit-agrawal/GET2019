package com.metacube.restful.dao;

public class Query {
	
	
	public final static String insertAdvertisement = "INSERT INTO advertisement VALUES(?,?,?,?);";
	
	public final static String insertCategory = "INSERT INTO category VALUES(?,?);";
	
	public final static String getAllCategory = "SELECT * FROM category;";
	
	public final static String getAllAdvertisement = "SELECT * FROM advertisement;";
	
	public final static String getAdvertisementByCategoryID = "SELECT * FROM advertisement WHERE category_id = ?;";
	
	public final static String updateAdvertisementName = "UPDATE advertisement SET title = ? WHERE id = ?;";
	
	public final static String updateCategoryName = "UPDATE category SET name = ? WHERE id = ?;";
	
	public final static String deleteAdvertisement = "DELETE FROM advertisement where id = ?;";
	
}
