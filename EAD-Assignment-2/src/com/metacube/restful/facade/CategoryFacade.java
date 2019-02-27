package com.metacube.restful.facade;

import java.util.List;


import com.metacube.restful.dao.CategoryDao;
import com.metacube.restful.enums.StatusEnums;
import com.metacube.restful.model.Category;


/**
 * Category Facade class uses the object of Category Dao to performs the operations on category database
 * @author admin
 *
 */
public class CategoryFacade {
	
	CategoryDao categoryDao = new CategoryDao();
	
	//returns the list of category available in the database
	public List<Category> getAllCategory()
	{
		return categoryDao.getAllCategory();
	}
	
	//add the category in the database
	public StatusEnums addcategory(Category category)
	{
		return categoryDao.insertCategory(category);
	}

	//updates the name of the category with given name of given category id
	public StatusEnums updateName(int id, String name)
	{
		return categoryDao.updateName(id, name);
	}

}
