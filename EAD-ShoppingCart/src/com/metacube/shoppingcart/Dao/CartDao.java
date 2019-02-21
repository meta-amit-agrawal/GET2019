package com.metacube.shoppingcart.Dao;

import java.util.List;

import com.metacube.shoppingcart.Model.Cart;
import com.metacube.shoppingcart.Model.User;


public class CartDao  {

	private UserDao userDao = UserDao.getInstance();
	
	private List<User> userList = userDao.getAllUser();
	
	/*
	 *getCart method finds the cart of the given userID
	 *@param requirse the userID
	 *@returns the reference of cart of given userID
	 */
	
	public Cart getCart(int user_id)
	{
		for(User user : userList)
		{
			if(user.getUser_id() == user_id)
			{
				Cart cart = user.getCart();
				return cart;
			}
		}
		return null;
	}

}
