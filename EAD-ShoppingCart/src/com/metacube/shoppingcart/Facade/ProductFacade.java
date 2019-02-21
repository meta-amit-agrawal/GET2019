package com.metacube.shoppingcart.Facade;

import java.util.List;

import com.metacube.shoppingcart.Dao.ProductDao;
import com.metacube.shoppingcart.Model.Product;
import com.metacube.shoppingcart.enums.status;

public class ProductFacade 
{
	
	ProductDao productDao = ProductDao.getInstance();
	
	public List<Product> getStoreProduct()
	{
		return productDao.getAllproducts();
	}
	
	public Product getProductById(int productID)
	{
		List<Product> storeProducts = productDao.getAllproducts();
		
		for(Product p : storeProducts)
		{
			if(p.getProduct_code() == productID)
			{
				return p;
			}
		}
		return null;
		
	}
	
	public status updateProduct(int pro_id, int pro_qty)
	{
		List<Product> productList = productDao.getAllproducts();
		for(Product p: productList)
		{
			if(p.getProduct_code() == pro_id)
			{
				if(p.getProduct_qty() > pro_qty)
				{
					p.setProduct_qty(p.getProduct_qty()-pro_qty);
					return status.SUCCESSFULL;
				}
				else
				{
					return status.NOTSUCCESSFULL;
				}
			}
			else
			{
				return status.NOTEXISTS;
			}
		}
		return null;
	}
	
	public status addProduct(int pro_id,int pro_qty)
	{
		
	}
	
	
	
}
