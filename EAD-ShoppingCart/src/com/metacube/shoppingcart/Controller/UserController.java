package com.metacube.shoppingcart.Controller;

import java.util.List;

import com.metacube.shoppingcart.Facade.UserFacade;
import com.metacube.shoppingcart.Model.User;
import com.metacube.shoppingcart.enums.status;

public class UserController {
	
	UserFacade userFacade = new UserFacade();
	
	List<User> existingUser = userFacade.getAllUser();
	
	public boolean addUser(User user) throws Exception
	{
		if(userFacade.addUser(user)==status.SUCCESSFULL)
		{
			return true;
		}
		throw new Exception("Duplicate User");
	}
	
	
	public List<User> getAllUser()
	{
		return  userFacade.getAllUser();
	}
	
	public User getUserByID(int userID)
	{
		return userFacade.getUserByID(userID);
	}

}
