import java.util.ArrayList;
import java.util.Scanner;


public class Menu extends Cart {
	public static ArrayList<Item> store=new ArrayList<Item>();
	
	public void showMenu()
	{
		System.out.println("Choose the option");
		System.out.println("1. Add item in the list");
		System.out.println("2. Add item in cart");
		System.out.println("3. Remove item from cart");
		System.out.println("4. Generate final bill");
		System.out.println("5. Show Cart Items");
		System.out.println("6. Show item in store");
		System.out.println("7. Exit");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Menu m=new Menu();
		Item i1;
		m.showMenu();
		int choice,i,temp_qty;
		float temp;
		choice=sc.nextInt();
		while(choice!=7)
		{
			 i1=new Item();
		switch(choice)
		{
		case 1:
			Item i6;
			int temp_id = 0;
			System.out.println("Enter the ID of the Item");
			if(store.isEmpty())
			{
				temp_id=sc.nextInt();
				i1.setProductId(temp_id);
			}
			else
			{
				for(int k=0; k<store.size(); k++)
				{
						temp_id=sc.nextInt();
						i6=store.get(k);
						if(temp_id==i6.getProductId())
						{
							System.out.println("ID already Exists...");
							System.out.println("Please Re-enter the ID");
							temp_id=sc.nextInt();
						}
						i1.setProductId(temp_id);
						break;
				}
			}
			System.out.println("Enter the name of the Item");
			i1.setProductName(sc.next());
			System.out.println("Enter the price of the Item");
			while((temp=sc.nextFloat())<=0)
			{
				System.out.println("Price cannot be zero or negative!!");
				System.out.println("PLease Re-Enter the price");
			}
			
			i1.setProductPrice(temp);
			
			System.out.println("Enter the quantity of the product");
			while((temp_qty=sc.nextInt())<=0)
			{
				System.out.println("Quantity cannot be zero or negative!!");
				System.out.println("PLease Re-Enter the Quantity");
			}
			
			i1.setProductQty(temp_qty);
			
			if(store.add(i1))
			{
			System.out.println("Successfully added");
			}
			
			break;
		case 2:
			Item i2 = null;
			Item i3 = null;
			Cart c1 = null;
			if(store.isEmpty())
			{
				System.out.println("Item List is Empty!!");
			}
			else
			{
				System.out.println("ID\tName\tPrice\tQuantity");
				for(i=0; i<store.size(); i++)
				 {
					 i2 = store.get(i);
					 
					 System.out.println(i2.getProductId()+"\t"+i2.getProductName()+"\t"+i2.getProductPrice()+"\t"+i2.getProductQty());
				 }
				
				 System.out.println("Enter the item ID to add in cart");
				 int id,flag=0,flag_qty=0,qty;
				 id=sc.nextInt();
				 System.out.println("Enter the quantity to add in cart");
				 qty=sc.nextInt();
				 
				 for(i=0;i<store.size();i++)
				 {
					 i2=store.get(i);
					 if(id==i2.getProductId())
					 {
						 flag=1;
						 if(qty<=i2.getProductQty())
						 {
							 i2.setProductQty(i2.getProductQty()-qty);
							 flag_qty=1;
							 break;
						 }
					 }
				 }
				 
				 if(flag==1)
				 {
					 if(flag_qty==1)
					 {
						 i3=new Item();
						 i3.setProductId(i2.getProductId());
						 i3.setProductName(i2.getProductName());
						 i3.setProductQty(qty);
						 i3.setProductPrice(i2.getProductPrice());
						 c1=new Cart();
						 c1.addItem(i3);
						 System.out.println("Item added in cart successfully");
					 }
					 else
					 {
						 System.out.println("Required Quantity is not available in Stock");
					 }
				 }
				 else
				 {
					 System.out.println("Item not found!!!");
				 }
			}
			
			break;
			
		case 3:
			
			Cart c2=new Cart();
			
			if(c2.isCartEmpty())
			{
				System.out.println("Cart is empty");
			}
			else
			{
				c2.showCart();
				System.out.println("Enter the id of the item to be removed...");
				c2.removeItem(sc.nextInt());
			}
			
			break;
		
		case 4:
			Cart  c3=new Cart();
			c3.finalBill();
			break;
			
		case 5:
			Cart c4=new Cart();
			c4.showCart();
			break;
			
		case 6:
			Item i5;
			if(store.isEmpty())
			{
				System.out.println("Item List is Empty!!");
			}
			else
			{
				System.out.println("ID\tName\tPrice\tQuantity");
				for(i=0; i<store.size(); i++)
				 {
					 i5 = store.get(i);
					 
					 System.out.println(i5.getProductId()+"\t"+i5.getProductName()+"\t"+i5.getProductPrice()+"\t"+i5.getProductQty());
				 }
			}
			break;
			
		case 7:
			
			System.exit(0);
			
		default:
			
			System.out.println("Invalid choice!!");
		}
		m.showMenu();
		choice=sc.nextInt();
		}
	}

}
