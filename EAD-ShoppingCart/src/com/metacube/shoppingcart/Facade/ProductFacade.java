package com.metacube.shoppingcart.Facade;

import java.util.List;

import com.metacube.shoppingcart.Dao.ProductDao;
import com.metacube.shoppingcart.Model.Product;
import com.metacube.shoppingcart.enums.status;

public class ProductFacade 
{
	
	ProductDao productDao = new ProductDao();
	List<Product> storeProducts = productDao.getAllproducts();
	
	public status addProduct(Product product)
	{
		
		for(Product pro : storeProducts)
		{
			if(pro.getProduct_code() == product.getProduct_code())
			{
				return status.DUPLICATE;
			}
		}
		productDao.add(product);
		return status.SUCCESSFULL;
		
	}
	
	
	public status deleteProduct(Product product)
	{
		for(Product pro : storeProducts)
		{
			if(pro.getProduct_code() == product.getProduct_code())
			{
				productDao.delete(product);
				return status.SUCCESSFULL;
			}
		}
		return status.NOTEXISTS;
	}
	
	
}
