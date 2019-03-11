package com.metacube.restful.model;

/**
 * Advertisement class used as a model class with defined properties
 * @author admin
 *
 */
public class Advertisement {

	int id;
	String name;
	String description;
	int category_id;
	
	//parameterized constructor to initialize the  properties
	public Advertisement(int id, String name, String description, int category_id) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.category_id = category_id;
	}

	//returns the id of the advertisement
	public int getId() {
		return id;
	}

	//returns the name of the advertisement
	public String getName() {
		return name;
	}

	//returns the description of the advertisement 
	public String getDescription() {
		return description;
	}

	//returns the category id of the advertisement
	public int getCategory_id() {
		return category_id;
	}
	
	
	
	

}
