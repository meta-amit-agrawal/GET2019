package com.metacube.restful.model;

public class Advertisement {
	
	int id;
	String name;
	String description;
	int category_id;
	
	public Advertisement(int id, String name, String description, int category_id) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.category_id = category_id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getCategory_id() {
		return category_id;
	}
	
	
	
	

}
