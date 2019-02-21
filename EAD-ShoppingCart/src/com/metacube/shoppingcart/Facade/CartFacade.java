package com.metacube.shoppingcart.Facade;

import java.util.List;

import com.metacube.shoppingcart.Dao.CartDao;
import com.metacube.shoppingcart.Model.Cart;
import com.metacube.shoppingcart.Model.Product;
import com.metacube.shoppingcart.enums.status;

public class CartFacade {
	
	
	CartDao cartDao = new CartDao();
	
	public status addProductToCart(int userId, Product product, int productQTY)
	{
		Cart cart = cartDao.getCart(userId);
		if(cart!=null)
		{
			Product pro = cart.getProductById(product.getProduct_code());
			if(pro!=null)
			{
				pro.setProduct_qty(pro.getProduct_qty()+product.getProduct_qty());
				return status.SUCCESSFULL;
			}
			else
			{
				cart.addProduct(product);
				return status.SUCCESSFULL;
			}
		}
		else 
		{
			return status.NOTEXISTS;
		}
		
	}
	
	public status deleteProductFromCart(int userId, Product product)
	{
		Cart cart = cartDao.getCart(userId);
		Product pro = cart.getProductById(product.getProduct_code());
		if(pro!=null)
		{
			if(pro.getProduct_qty() == product.getProduct_qty())
			{
				 cart.removeProduct(pro);
				 return status.SUCCESSFULL;
			}
			else if(pro.getProduct_qty() > product.getProduct_qty())
			{
				pro.setProduct_qty(pro.getProduct_qty() - product.getProduct_qty());
				return status.SUCCESSFULL;
			}
			else
			{
				return status.NOTSUCCESSFULL;
			}	
		}
		return status.NOTEXISTS;
	}
	
	public List<Product> getCartList(int user_id)
	{
		Cart cart = cartDao.getCart(user_id);
		if(cart!=null)
		{
			return cart.getCartItem();
		}
		return null;
	}
	
	
	

}
