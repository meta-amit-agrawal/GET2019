import java.util.ArrayList;
import java.util.Scanner;


public class Menu extends Cart {
	public static ArrayList<Item> store=new ArrayList<Item>();
	
	public void showMenu()
	{
		System.out.println("Choose the option");
		System.out.println("1. Add item in the list");
		System.out.println("2. Add item in cart");
		System.out.println("3. Go to cart");
		System.out.println("4. Exit");
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
		while(choice!=4)
		{
			 i1=new Item();
		switch(choice)
		{
		case 1:
			System.out.println("Enter the ID of the Item");
			i1.setProductId(sc.nextInt());
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
			Item i2;
			for(i=0;i<store.size();i++)
			 {
				 i2=store.get(i);
				 System.out.println(i2.getProductId()+"  "+i2.getProductName()+"  "+i2.getProductPrice()+"  "+i2.getProductQty());
			 }
			 System.out.println("Enter the item ID to add in cart..");
			 int id,flag=0;
			 id=sc.nextInt();
			 for(i=0;i<store.size();i++)
			 {
				 i2=store.get(i);
				 if(id==i2.getProductId())
				 {
					if(Cart.cart.add(i2))
					{
						flag=1;
					}
					break;
				 }
			 }
			 if(flag==1)
			 {
				 System.out.println("Item Added to cart successfully");
			 }
			 else
			 {
				 System.out.println("Item not found!!!");
			 }
			break;
		case 3:
			break;
		case 4: 
			System.exit(0);
		default:
			System.out.println("Invalid choice!!");
		}
		m.showMenu();
		choice=sc.nextInt();
		}
	}

}
