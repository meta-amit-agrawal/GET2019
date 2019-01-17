import java.util.ArrayList;
import java.util.Scanner;


public class Cart  {
	
	public static ArrayList<Item> cart=new ArrayList<Item>();
	Scanner sc=new Scanner(System.in);
	int cartChoice;
	public void addItem(Item i)
	{
		Item i1;
		int j,flag=0;
		for(j=0;j<cart.size();j++)
		{
			i1=cart.get(j);
			if(i.getProductId()==i1.getProductId())
			{
				i1.setProductQty(i1.getProductQty()+i.getProductQty());
				flag=1;
			}
		}
		if(flag!=1)
		{
			cart.add(i);
		}
		
	}
	
	public void removeItem(int id)
	{
		int i,remove_qty;
		Item i1;
		
			for(i=0;i<cart.size();i++)
			{
			i1=cart.get(i);
			if(i1.getProductId()==id)
			{
				System.out.println("Enter the quantity to be removed...");
				while((remove_qty=sc.nextInt())>i1.getProductQty())
				{
					System.out.println("Quantity present in cat is less than the entered quantity!!!");
					System.out.println("\nPlease Re-enter the quantity...");
				}
				if((i1.getProductQty()-remove_qty)==0)
				{
					cart.remove(i);
				}
				else
				{
				i1.setProductQty(i1.getProductQty()-remove_qty);
				}
				System.out.println("Item updated Successfully");
			}
			else
			{
				System.out.println("Item Not Found...");
			}
			
		}
	}
	
	public void finalBill()
	{
		if(isCartEmpty())
		{
			System.out.println("Cart is Empty!!!");
		}
		else
		{
			int i;
			Item  i1;
			float finalbillamount=0.0f;
			System.out.println("\n\nYour Final Cart is as follows");
			showCart();
			for(i=0; i<cart.size(); i++)
			{
				i1=cart.get(i);
				finalbillamount= finalbillamount+(i1.getProductPrice()*i1.getProductQty());
				
			}
		System.out.println("\nYour Final amount is......"+finalbillamount);
		cart.clear();;
		}
	}
	
	public void showCart()
	{
		Item i1;
		int i;
		if(isCartEmpty())
		{
			System.out.println("\nCart is empty!!!");
		}
		else
		{
		System.out.println("\nID\tName\tPrice\tQuantity");
		for(i=0; i<cart.size(); i++)
		{
			
			i1=cart.get(i);
			System.out.println("\n"+i1.getProductId()+"\t"+i1.getProductName()+"\t"+i1.getProductPrice()+"\t"+i1.getProductQty());
	//		showCartMenu();
		}
		}
		
	}
	public void showCartMenu()
	{
		System.out.println("Choose the option for cart");
		System.out.println("2. Remove an Item");
		System.out.println("3. Modify an Item");
		System.out.println("4. Generate final bill");
		cartChoice=sc.nextInt();
	}
	public boolean isCartEmpty()
	{
		if(cart.size()==0)
		{
			return true;
		}
		return false;
	}
	
}
