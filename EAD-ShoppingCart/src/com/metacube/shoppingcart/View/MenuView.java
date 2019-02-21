package com.metacube.shoppingcart.View;

import java.util.List;
import java.util.Scanner;

import com.metacube.shoppingcart.Controller.CartController;
import com.metacube.shoppingcart.Controller.ProductController;
import com.metacube.shoppingcart.Controller.UserController;
import com.metacube.shoppingcart.Model.Cart;
import com.metacube.shoppingcart.Model.Product;
import com.metacube.shoppingcart.Model.User;

public class MenuView {
	
	public void showMenu()
	{
		System.out.println("Choose the option below...");
		System.out.println("1. Add User");
		System.out.println("2. Login");
		System.out.println("Press any other key to exit");
	}
	
	public void showCartMenu()
	{
		System.out.println("Choose the below cart option...");
		System.out.println("1. Add Product to cart");
		System.out.println("2. Update product to cart");
		System.out.println("3. Logout");
	}
	
	public static void main(String args[])
	{
		MenuView menuView = new MenuView();
		menuView.showMenu();
		UserController userController = new UserController();
		ProductController productController = new ProductController();
		CartController cartController = new CartController();
		
		Scanner sc = new Scanner(System.in);
		int menuChoice,cartChoice;
		menuChoice = sc.nextInt();
		while(menuChoice>0 && menuChoice<3)
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
					System.out.println("Error: "+e.getMessage());
				}
								
				break;
			case 2:
				System.out.println("Enter the id of the user");
				int userID = sc.nextInt();
				User user = userController.getUserByID(userID);
				if(user!=null)
				{
					menuView.showCartMenu();
					cartChoice = sc.nextInt();
					
					while(cartChoice>0 && cartChoice<4)
					{
						switch(cartChoice)
						{
						case 1:
							List<Product> store = productController.getStoreProduct();
							for(int i=0;i<store.size();i++)
							{
								System.out.println(store.get(i).getProduct_code()+"\t"+store.get(i).getProduct_name()+"\t"
										+store.get(i).getProduct_price()+"\t"+store.get(i).getProduct_type()+"\t"+store.get(i).getProduct_qty());
							}
							System.out.println("Enter the id of the product...");
							int proID = sc.nextInt();
							System.out.println("Enter the quantity of the product...");
							int proQty = sc.nextInt();
							
							break;
						case 2:
							
							List<Product> cartList = cartController.getCartList(userID);
							
							for(int i=0;i<cartList.size();i++)
							{
								Product cartProduct = cartList.get(i);
								System.out.println(cartProduct.getProduct_code()+"\t"+cartProduct.getProduct_name()+"\t"
										+cartProduct.getProduct_price()+"\t"+cartProduct.getProduct_type()+"\t"+cartProduct.getProduct_qty());
							}
							
							System.out.println("Enter the id of the product to update...");
							int productID = sc.nextInt();
							System.out.println("Enter the Quantity of the product...");
							int productQTY = sc.nextInt();
							
							
							break;
						case 3: 
							break;
						default:
							System.out.println("Invalid Choice!!");
						}
						
						menuView.showCartMenu();
						cartChoice = sc.nextInt();
						if(cartChoice == 3)
						{
							break;
						}
						
					}
					
				}
				else
				{
					System.out.println("User doesn't exist");
				}
				break;
			default:
				
				
				
				System.out.println("Invalid choice!!!");
				
			}
			
			
			List<User> userList = userController.getAllUser();
			
			for(int i=0;i<userList.size();i++)
			{
				System.out.println(userList.get(i).getUser_id()+"  "+userList.get(i).getUser_name());
			}
			
			System.out.println();
			menuView.showMenu();
			menuChoice = sc.nextInt();
			
		}
		
		sc.close();
	}

}
