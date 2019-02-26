package com.metacube.restful.facade;

import java.util.List;


import com.metacube.restful.dao.CategoryDao;
import com.metacube.restful.enums.StatusEnums;
import com.metacube.restful.model.Category;

public class CategoryFacade {
	
	CategoryDao categoryDao = new CategoryDao();
	
	public List<Category> getAllCategory()
	{
		return categoryDao.getAllCategory();
	}
	
	public StatusEnums addcategory(Category category)
	{
		return categoryDao.insertCategory(category);
	}
	
	public StatusEnums updateName(int id, String name)
	{
		return categoryDao.updateName(id, name);
	}

}
