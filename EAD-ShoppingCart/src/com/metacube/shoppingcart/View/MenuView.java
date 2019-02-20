package com.metacube.shoppingcart.View;

import java.util.Scanner;

import com.metacube.shoppingcart.Controller.ProductController;
import com.metacube.shoppingcart.Model.Product;

public class MenuView {
	
	public void showMenu()
	{
		System.out.println("Choose  the option below...");
		System.out.println("1. Add User");
		System.out.println("2. Change User");
		System.out.println("2. Add product to cart");
		System.out.println("3. Update product from cart");
		
	}
	
	public static void main(String args[])
	{
		MenuView menuView = new MenuView();
		menuView.showMenu();
		
		Scanner sc = new Scanner(System.in);
		
	}

}
