package com.metacube.shoppingcart.View;

import java.util.Scanner;

import com.metacube.shoppingcart.Controller.ProductController;
import com.metacube.shoppingcart.Model.Product;

public class MenuView {
	
	public void showMenu()
	{
		System.out.println("Choose the option below...\n1.Add Product\n2.Show Product\n3.Add User\n"
				+ "4.Delete User\n5.Add Product to cart");
	}
	
	public static void main(String args[])
	{
		MenuView menuView = new MenuView();
		menuView.showMenu();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter product details");
		String name=sc.next();
		int code=sc.nextInt();
		String type = sc.next();
		double price = sc.nextDouble();
		
		ProductController productController = new ProductController();
		char ch='y';
		while(ch=='y')
		{
			try {
				if(productController.addProduct(new Product(code, type, name, price)))
				System.out.println("Added");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			ch=sc.next().charAt(0);
		}
		
	}

}
