package com.metacube.shoppingcart.View;

import java.util.Scanner;

import com.metacube.shoppingcart.Controller.UserController;
import com.metacube.shoppingcart.Model.User;

public class MenuView {
	
	public void showMenu()
	{
		System.out.println("Choose the option below...");
		System.out.println("1. Add User");
		System.out.println("2. Login");
	}
	
	public void showCartMenu()
	{
		System.out.println("Choose the below cart option...");
		System.out.println("1. Add Product to cart");
		System.out.println("2. Update product to cart");
		System.out.println("3. Change User");
	}
	
	public static void main(String args[])
	{
		MenuView menuView = new MenuView();
		menuView.showMenu();
		UserController userController = new UserController();
		
		Scanner sc = new Scanner(System.in);
		int menuChoice,cartChoice;
		menuChoice = sc.nextInt();
		while(menuChoice>0 && menuChoice<5)
		{
			switch(menuChoice)
			{
			case 1:
				System.out.println("Enter the id of the user");
				int newuserId = sc.nextInt();
				System.out.println("Enter the name of the user");
				String newname = sc.next();
				try {
					userController.addUser(new User(newuserId, newname));
					System.out.println("Added");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				menuView.showCartMenu();
				cartChoice = sc.nextInt();
				while(cartChoice>0 && cartChoice<4)
				{
					switch(cartChoice)
					{
					case 1:
						break;
					case 2:
						break;
					case 3:
						System.out.println("Enter id of user...");
						int userID = sc.nextInt();
						User u = userController.getUserByID(userID);
						if(u==null)
						{
							System.out.println("User Doesn't exists");
						}
						break;
					}
				}
				
				break;
			case 2:
				System.out.println("Enter the id of the user");
				
				break;
			default:
				System.out.println("Invalid choice!!!1");
			}
			
			
			System.out.println();
			menuView.showMenu();
			menuChoice = sc.nextInt();
			
		}
		
		sc.close();
	}

}
