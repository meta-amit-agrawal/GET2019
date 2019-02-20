package com.metacube.shoppingcart.Controller;

import java.util.List;

import com.metacube.shoppingcart.Facade.ProductFacade;
import com.metacube.shoppingcart.Model.Product;

public class ProductController 
{
	
	
	ProductFacade productFacade = new ProductFacade();
	
	public List<Product> getStoreProduct()
	{
		return productFacade.getStoreProduct();
	}
	
}
