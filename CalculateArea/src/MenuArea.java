
import java.util.Scanner;

public class MenuArea 
{
	
	public void showMenu()
	{	
		System.out.println("Choose the option below");
		System.out.println("1. Area of Triangle");
		System.out.println("2. Area of Circle");
		System.out.println("3. Area of Rectangle");
		System.out.println("4. Area of Square");
		System.out.println("5. Exit");	
	}
	
	/*
	 * checkInput method to check the input given by is valid positive integer or not
	 * @param input which is a string type value which contains the input given by the user, assuming input is not null
	 * @return will return the value entered by the user if it is a positive integer.  
	 */
	public Double checkInput(String input)
	{
		Scanner sc = new Scanner(System.in);
		
		boolean flag=false;
		double double_input=0.0;
		
		while(!flag)	
		{
			flag=checkDouble(input);
			
			if(!flag)
			{
				System.out.println("Only Numbers!!");
				System.out.println("Please Re-enter...");
				input=sc.next();	
			}
			
			else
			{
				while((double_input=Double.parseDouble(input)) <= 0)
				{
					System.out.println("cannot be negative or Zero!!\nPlease re-enter");
					input=sc.next();
					flag=false;
					break;			
				}	
			}
			
		}
		
		
		return double_input;
	}
	
	/*
	 * checkInteger method to check whether the input is integer or not
	 * @param input which holds the value given by the user, assuming input should not be null
	 * @return the boolean value true of the value is an integer and false if not.
	 */
	public boolean checkInteger(String input)
	{
		
		try
		{
			 new Integer(input);
		}
		
		catch (Exception e) 
		{
			// TODO: handle exception
			return false;
		}
		
		return true;
	}
	
	/*
	 * checkDouble method to check whether the input is double or not
	 * @param input which holds the value given by the user, assuming input should not be null
	 * @return the boolean value true of the value is an double and false if not.
	 */
	public boolean checkDouble(String input)
	{
		
		try
		{
			new Double(input);
		}
		
		catch(Exception e)
		{
			return false;
		}
		
		return true;
	}
	
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);
		MenuArea menuArea = new MenuArea();
		Area area = new Area();
		
		boolean flag=false;
		int user_choice=0;
		double input_value1=0.0 , input_value2=0.0 ;
		String area_result,temp_input;
		
		menuArea.showMenu();
		while(!flag)	//loop to check recursively whether the input is integer or not
		{
			temp_input=sc.next();
			
			flag=menuArea.checkInteger(temp_input);
			
			if(!flag)
			{
				System.out.println("Only Integers!!!");
				System.out.println("Re-Enter the choice");
				menuArea.showMenu();
			}
			
			else
			{
				user_choice=Integer.parseInt(temp_input);
			}
			
		}
		
		
		while(user_choice!=5)	//loop to run the program until the user wants to stop 
		{
			
			flag=false;
			
			switch(user_choice)
			{
			
			case 1:
				
				System.out.println("Enter the base of the triangle...");
				input_value1=menuArea.checkInput(sc.next());
				
				System.out.println("Enter the height of the triangle...");
				input_value2=menuArea.checkInput(sc.next());
				
				try
				{
					area_result=area.calculateAreaTriangle(input_value1, input_value2);
					System.out.println("The area of triangle is..."+area_result);
				}
				
				catch (ArithmeticException e) 
				{
					System.out.println("Arithmetic Exception occurred");
				}
				
				break;
				
			case 2:
				
				System.out.println("Enter the radius of the circle...");
				input_value1=menuArea.checkInput(sc.next());
				
				try
				{
					area_result=area.calculateAreaOfCircle(input_value1);
					System.out.println("The area of circle is..."+area_result);
				}
				
				catch (ArithmeticException e) 
				{
					System.out.println("Arithmetic Exception occurred");
				}
				
				break;
				
			case 3:
				
				System.out.println("Enter the length of the rectangle...");
				input_value1=menuArea.checkInput(sc.next());
				
				System.out.println("Enter the breadth of the rectangle...");
				input_value2=menuArea.checkInput(sc.next());
				
				try
				{
					area_result=area.calculateAreaOfRectangle(input_value1, input_value2);
					System.out.println("The area of rectangle is..."+area_result);
				}
				
				catch (ArithmeticException e) 
				{
					System.out.println("Arithmetic Exception occurred");
				}
				
				break;
				
			case 4:
				
				System.out.println("Enter the length of the square...");
				input_value1=menuArea.checkInput(sc.next());
				
				try
				{
					area_result=area.calculateAreaOfSquare(input_value1);
					System.out.println("The area of sqaure is..."+area_result);
				}
				
				catch (ArithmeticException e) 
				{
					System.out.println("Arithmetic Exception occurred");
				}
				
				break;
				
			case 5:
				
				System.exit(0);
				
				break;
				
			default:
				
				System.out.println("Invalid choice!!");

			}
			
			menuArea.showMenu();
			
			//loop will check for the choice given by the user is valid or not
			while(!flag)
			{
				temp_input=sc.next();
				
				flag=menuArea.checkInteger(temp_input);
				
				if(!flag)
				{
					System.out.println("Only Integers!!!");
					System.out.println("Re-Enter the choice");
					menuArea.showMenu();
				}
				
				else
				{
					user_choice=Integer.parseInt(temp_input);
				}
				
			}
			
		}
		
		
	}
}
