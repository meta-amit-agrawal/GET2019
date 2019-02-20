package com.metacube.shoppingcart.Facade;

import java.util.List;

import com.metacube.shoppingcart.Dao.ProductDao;
import com.metacube.shoppingcart.Model.Product;

public class ProductFacade 
{
	
	ProductDao productDao = new ProductDao();
	
	public List<Product> getStoreProduct()
	{
		return productDao.getAllproducts();
	}
	
}
