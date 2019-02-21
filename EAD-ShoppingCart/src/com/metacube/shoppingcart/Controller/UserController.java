package com.metacube.shoppingcart.Controller;

import java.util.List;

import com.metacube.shoppingcart.Facade.UserFacade;
import com.metacube.shoppingcart.Model.User;
import com.metacube.shoppingcart.enums.status;

public class UserController {
	
	UserFacade userFacade = new UserFacade();	
	
	/*
	 * addUser method to add the user in the application
	 * @requires the object of user to add in the list
	 * @return true if user is added 
	 */
	public boolean addUser(User user) throws Exception
	{
		if(userFacade.addUser(user)==status.SUCCESSFULL)
		{
			return true;
		}
		throw new Exception("Duplicate User");
	}
	
	/*
	 * getAllUser method returns the list of all users available in the system
	 * @returns the list of users
	 */
	public List<User> getAllUser()
	{
		return  userFacade.getAllUser();
	}
	
	/*
	 * getUserByID method finds the user of given userID by calling UserFacade class
	 * @returns the user of given userID
	 */
	public User getUserByID(int userID)
	{
		return userFacade.getUserByID(userID);
	}

}
