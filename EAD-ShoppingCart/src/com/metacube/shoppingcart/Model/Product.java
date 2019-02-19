package com.metacube.shoppingcart.Model;

public class Product {
	
	int product_code;
	String product_type;
	String product_name;
	double product_price;
	
	public Product(int product_code, String product_type, String product_name, double product_price){
		this.product_name = product_name;
		this.product_code = product_code;
		this.product_price = product_price;
		this.product_type = product_type;
	}

	public int getProduct_code() {
		return product_code;
	}

	public String getProduct_type() {
		return product_type;
	}

	public String getProduct_name() {
		return product_name;
	}

	public double getProduct_price() {
		return product_price;
	}
	
}
