package com.metacube.shoppingcart.Controller;

import com.metacube.shoppingcart.Facade.ProductFacade;
import com.metacube.shoppingcart.Model.Product;
import com.metacube.shoppingcart.enums.status;


public class ProductController 
{
	
	
	ProductFacade productFacade = new ProductFacade();
	
	public boolean addProduct(Product product) throws Exception
	{
		if(productFacade.addProduct(product)==status.SUCCESSFULL)
		{
			return true;
		}
		throw new Exception("Duplicate Product");
	}
	
	public boolean deleteProduct(Product product) throws Exception
	{
		if(productFacade.deleteProduct(product)==status.SUCCESSFULL)
		{
			return true;
		}
		throw new Exception("Product Not Exists");
	}
	
}
