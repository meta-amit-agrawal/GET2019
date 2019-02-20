package com.metacube.shoppingcart.Facade;

import java.util.List;

import com.metacube.shoppingcart.Controller.UserController;
import com.metacube.shoppingcart.Dao.CartDao;
import com.metacube.shoppingcart.Dao.UserDao;
import com.metacube.shoppingcart.Model.Cart;
import com.metacube.shoppingcart.Model.Product;
import com.metacube.shoppingcart.Model.User;
import com.metacube.shoppingcart.enums.status;

public class CartFacade {
	
	
	CartDao cartDao = new CartDao();
	
	public status addProductToCart(int userId, Product product)
	{
		Cart cart = cartDao.getCart(userId);
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
	
	
	public static void main(String args[])
	{
		UserController userController =new UserController();
		UserDao userDao =UserDao.getInstance();
		User user = new User(1,"Akshat");
		User user2 = new User(2,"Akshat");
		User user3 = new User(3,"Akshat");
		User user4 = new User(1,"Akshat");		
		try {
			userController.addUser(user);
			userController.addUser(user2);
			userController.addUser(user3);
			userController.addUser(user4);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		CartFacade cartFacade = new CartFacade();
		cartFacade.addProductToCart(1, new Product(1, "furnitue", "chair", 100,1));
		cartFacade.addProductToCart(1, new Product(1, "furnitue", "chair", 100,1));
		cartFacade.addProductToCart(2, new Product(1, "furnitue", "chair", 100,1));
		cartFacade.addProductToCart(5, new Product(1, "furnitue", "chair", 100,1));
		cartFacade.addProductToCart(1, new Product(2, "furnitue", "chair", 100,1));
		
		cartFacade.deleteProductFromCart(1, new Product(1, "furniture", "chair", 100, 2));
		
		List<User> users = userDao.getAllUser();
		for(int i=0;i<users.size();i++)
		{
			System.out.println(users.get(i).getUser_id()+"  "+users.get(i).getUser_name());
			User u = users.get(i);
			Cart c = u.getCart();
			for(int j=0;j<c.getCartItem().size();j++)
			{
				System.out.println(c.getCartItem().get(j).getProduct_code()+"  "+c.getCartItem().get(j).getProduct_qty());
			}
		}
		
		
	}

}
