import java.util.ArrayList;
import java.util.Scanner;


public class Cart  {
	
	public static ArrayList<Item> cartItemList=new ArrayList<Item>();
	Scanner sc=new Scanner(System.in);
	public void addItem(Item newItem)
	{
		Item existingItem;
		int j,flag=0;
		for(j=0;j<cartItemList.size();j++)
		{
			existingItem=cartItemList.get(j);
			if(newItem.getProductId()==existingItem.getProductId())
			{
				existingItem.setProductQty(existingItem.getProductQty()+newItem.getProductQty());
	
	
				flag=1;
			}
		}
		if(flag!=1)
		{
			cartItemList.add(newItem);
		}
		
	}
	
	public void removeItem(int id)
	{
		int i,remove_qty,final_qty;
		Item existingItem;
		
			for(i=0;i<cartItemList.size();i++)
			{
			existingItem=cartItemList.get(i);
			if(existingItem.getProductId()==id)
			{
				System.out.println("Enter the quantity to be removed...");
				while((remove_qty=sc.nextInt())>existingItem.getProductQty())
				{
					System.out.println("Quantity present in cat is less than the entered quantity!!!");
					System.out.println("\nPlease Re-enter the quantity...");
				}
				final_qty=existingItem.getProductQty()-remove_qty;
				if(final_qty==0)
				{
					cartItemList.remove(i);
				}
				else
				{
				existingItem.setProductQty(final_qty);
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
			Item  existingItem;
			float finalbillamount=0.0f;
			System.out.println("\n\nYour Final Cart is as follows");
			showCart();
			for(i=0; i<cartItemList.size(); i++)
			{
				existingItem=cartItemList.get(i);
				finalbillamount= finalbillamount+(existingItem.getProductPrice()*existingItem.getProductQty());
				
			}
			System.out.println("\nYour Final amount is......"+finalbillamount);
			cartItemList.clear();
			
		}
	}
	
	public void showCart()
	{
		Item cartItems;
		int i;
		if(isCartEmpty())
		{
			System.out.println("\nCart is empty!!!");
		}
		else
		{
		System.out.println("\nID\tName\tPrice\tQuantity");

		for(i=0; i<cartItemList.size(); i++)
		{
			
			cartItems=cartItemList.get(i);
			System.out.println("\n"+cartItems.getProductId()+"\t"+cartItems.getProductName()+"\t"+cartItems.getProductPrice()+"\t"+cartItems.getProductQty());
		}
		
		
	}
	}

	
	public boolean isCartEmpty()
	{
		if(cartItemList.size()==0)

		{
			return true;
		}
		return false;
	}

}