package com.metacube.shoppingcart.Dao;

import java.util.ArrayList;
import java.util.List;

import com.metacube.shoppingcart.Model.Product;

public class ProductDao implements BaseDao<Product> {
	
	
	List<Product> productList = new ArrayList<Product>();
	
	@Override
	public void add(Product product) {
		// TODO Auto-generated method stub
		productList.add(product);
	}


	@Override
	public void delete(Product product) {
		// TODO Auto-generated method stub
		productList.remove(product);
		
	}


	@Override
	public void update(Product product,Product updated) {
		// TODO Auto-generated method stub
			int index;
			index=productList.indexOf(product);
			productList.add(index, updated);
	}
	
	
	public List<Product> getAllproducts()
	{
		return productList;
	}

}
