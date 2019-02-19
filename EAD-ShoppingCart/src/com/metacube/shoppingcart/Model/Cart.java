package com.metacube.shoppingcart.Model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	
	List<Product> cartProduct;
	User user;
	
	public Cart(User user) {
		// TODO Auto-generated constructor stub
		cartProduct = new ArrayList<Product>();
		this.user = user;
	}

}
