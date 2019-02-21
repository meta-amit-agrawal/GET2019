package com.metacube.shoppingcart.Dao;

import java.util.ArrayList;
import java.util.List;

import com.metacube.shoppingcart.Model.Product;

public class ProductDao {
	
	
	List<Product> productList = new ArrayList<Product>();
	
	private ProductDao() {
		// TODO Auto-generated constructor stub
		productList.add(new Product(1, "furniture", "chair", 100, 5));
		productList.add(new Product(1, "furniture", "table", 150, 6));
		productList.add(new Product(1, "clothes", "shirt", 50, 3));
		productList.add(new Product(1, "stationary", "pen", 10, 2));
		productList.add(new Product(1, "stationary", "note-book", 20, 7));
	}
	
	private static ProductDao productDao_Object = null;
	
	
	public static ProductDao getInstance()
	{
		if(productDao_Object == null)
		{
			productDao_Object = new ProductDao();
		}
		return productDao_Object;
	}
	
	public List<Product> getAllproducts()
	{
		return productList;
	}

}
