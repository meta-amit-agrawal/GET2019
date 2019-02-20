package com.metacube.shoppingcart.Model;

public class Product {
	
	int product_code;
	String product_type;
	String product_name;
	double product_price;
	int product_qty;
	
	public Product(int product_code, String product_type, String product_name, double product_price,int product_qty){
		this.product_name = product_name;
		this.product_code = product_code;
		this.product_price = product_price;
		this.product_type = product_type;
		this.product_qty = product_qty;
	}

	public int getProduct_code() {
		return this.product_code;
	}

	public String getProduct_type() {
		return this.product_type;
	}

	public String getProduct_name() {
		return this.product_name;
	}

	public double getProduct_price() {
		return this.product_price;
	}
	
	public int getProduct_qty()
	{
		return this.product_qty;
	}
	
	public void setProduct_qty(int qty)
	{
		this.product_qty = qty;
	}
	
	
}
