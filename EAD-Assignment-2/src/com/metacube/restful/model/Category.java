package com.metacube.restful.model;

/**
 * Category class used a model class with defined properties
 * @author admin
 *
 */
public class Category {
	
	int id;
	String name;
	
	//parameterized constructor
	public Category(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	//returns the id of the category
	public int getId() {
		return id;
	}

	//returns the name of the category
	public String getName() {
		return name;
	}

}
