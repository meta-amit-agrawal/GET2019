import java.util.ArrayList;
import java.util.Scanner;


public class Menu  {
	public static ArrayList<Item> store=new ArrayList<Item>();
	Cart newCart=new Cart();
	
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
		Item newItemStore;
		m.showMenu();
		int choice,i,temp_qty;
		float temp_price;
		
		choice=sc.nextInt();
		while(choice!=7)
		{
		newItemStore=new Item();
		switch(choice)
		{
		case 1:
			Item existingItemStore;
			int temp_id = 0;
			System.out.println("Enter the ID of the Item");
			if(store.isEmpty())
			{
				temp_id=sc.nextInt();
				newItemStore.setProductId(temp_id);
			}
			else
			{
				for(int k=0; k<store.size(); k++)
				{
						temp_id=sc.nextInt();
						existingItemStore=store.get(k);
						if(temp_id==existingItemStore.getProductId())
						{
							System.out.println("ID already Exists...");
							System.out.println("Please Re-enter the ID");
							temp_id=sc.nextInt();
						}
						newItemStore.setProductId(temp_id);
						break;
				}
			}
			System.out.println("Enter the name of the Item");
			newItemStore.setProductName(sc.next());
			System.out.println("Enter the price of the Item");
			while((temp_price=sc.nextFloat())<=0)
			{
				System.out.println("Price cannot be zero or negative!!");
				System.out.println("PLease Re-Enter the price");
			}
			
			newItemStore.setProductPrice(temp_price);
			
			System.out.println("Enter the quantity of the product");
			while((temp_qty=sc.nextInt())<=0)
			{
				System.out.println("Quantity cannot be zero or negative!!");
				System.out.println("PLease Re-Enter the Quantity");
			}
			
			newItemStore.setProductQty(temp_qty);
			
			if(store.add(newItemStore))
			{
			System.out.println("Successfully added");
			}
			
			break;
		case 2:
			Item existingItem = null;
			Item newItem = null;
			if(store.isEmpty())
			{
				System.out.println("Item List is Empty!!");
			}
			else
			{
				System.out.println("ID\tName\tPrice\tQuantity");
				for(i=0; i<store.size(); i++)
				 {

					 existingItem = store.get(i);
					 
					 System.out.println(existingItem.getProductId()+"\t"+existingItem.getProductName()+"\t"+existingItem.getProductPrice()+"\t"+existingItem.getProductQty());
				 }
				 System.out.println("Enter the item ID to add in cart");
				 int id,flag=0,flag_qty=0,qty;
				 id=sc.nextInt();
				 System.out.println("Enter the quantity to add in cart");
				 qty=sc.nextInt();
				 
				 for(i=0;i<store.size();i++)
				 {
					 existingItem=store.get(i);
					 if(id==existingItem.getProductId())
					 {
						 flag=1;
						 if(qty<=existingItem.getProductQty())
						 {
							 existingItem.setProductQty(existingItem.getProductQty()-qty);
							 flag_qty=1;
							 break;
						 }
					 }
				 }
				 
				 if(flag==1)
				 {
					 if(flag_qty==1)
					 {
						 newItem=new Item();
						 newItem.setProductId(existingItem.getProductId());
						 newItem.setProductName(existingItem.getProductName());
						 newItem.setProductQty(qty);
						 newItem.setProductPrice(existingItem.getProductPrice());
						m.newCart.addItem(newItem);
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
			if(m.newCart.isCartEmpty())
			{
				System.out.println("Cart is empty");
			}
			else
			{
				m.newCart.showCart();
				System.out.println("Enter the id of the item to be removed...");
				m.newCart.removeItem(sc.nextInt());
			}
			
			break;
		
		case 4:
			m.newCart.finalBill();
			break;
			
		case 5:
			m.newCart.showCart();
			break;
			
		case 6:
			Item item_avail_store;
			if(store.isEmpty())
			{
				System.out.println("Item List is Empty!!");
			}
			else
			{
				System.out.println("ID\tName\tPrice\tQuantity");
				for(i=0; i<store.size(); i++)
				 {
					 item_avail_store = store.get(i);
					 
					 System.out.println(item_avail_store.getProductId()+"\t"+item_avail_store.getProductName()+"\t"+item_avail_store.getProductPrice()+"\t"+item_avail_store.getProductQty());
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