package com.metacube.shoppingcart.Model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	
	private List<Product> cartItem;
	
	public Cart() {
		// TODO Auto-generated constructor stub
		cartItem = new ArrayList<Product>();
	}
	
	public List<Product> getCartItem()
	{
		return cartItem;
	}
	
	public Product getProductById(int product_id)
	{
		for(Product pro : cartItem)
		{
			if(pro.getProduct_code()==product_id)
			{
				return pro;
			}
		}
		return null;
	}
	
	public void addProduct(Product product)
	{
		cartItem.add(product);
	}
	
	public void removeProduct(Product product)
	{
		cartItem.remove(product);
	}
}
