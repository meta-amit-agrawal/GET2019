package com.metacube.shoppingcart.Controller;

import java.util.List;

import com.metacube.shoppingcart.Facade.ProductFacade;
import com.metacube.shoppingcart.Model.Product;

public class ProductController 
{
	
	ProductFacade productFacade = new ProductFacade();
	
	/*
	 * getStoreProduct method return the list of store product by calling the ProductFacade class
	 * @returns the list of product available in the store
	 */
	public List<Product> getStoreProduct()
	{
		return productFacade.getStoreProduct();
	}
	
	/*
	 * getProductById method returns the list of product by calling the object of ProductFacade class
	 * @returns the object of type product of given product id
	 */
	public Product getProductById(int productID)
	{
		return productFacade.getProductById(productID);
	}
	
}
