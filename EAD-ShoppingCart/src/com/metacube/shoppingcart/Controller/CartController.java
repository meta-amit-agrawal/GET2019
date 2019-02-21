package com.metacube.shoppingcart.Controller;

import java.util.List;

import com.metacube.shoppingcart.Facade.CartFacade;
import com.metacube.shoppingcart.Model.Product;

public class CartController {
	
	CartFacade cartFacade = new CartFacade();
	ProductController productController = new ProductController();
	
	public List<Product> getCartList(int user_id)
	{
		return cartFacade.getCartList(user_id);
	}
	
	
	public void addProductToCart(int userId, int productID, int productQTY)
	{
			Product product=productController.getProductById(productID);
			cartFacade.addProductToCart(userId, product,productQTY);
	}
	
	

}
