import java.util.Scanner;

public class MenuStrings 
{
	
	/*
	 * showMenu method is used to show the option to be performed according to the user
	 * @param doesnot require any parameter
	 * @return doesn't return any value 
	 */
	public void showMenu()
	{	
		System.out.println("Choose the option below");
		System.out.println("1. Compare Two Strings");
		System.out.println("2. Reverse the given String");
		System.out.println("3. To modify the Strings (lower to upper case or vice versa)");
		System.out.println("4. Find largest word");
		System.out.println("5. Exit");	
	}
	
	/*
	 * checkInteger method is used to check the input should be integer only
	 * @param input of type string which holds the input given by user, assuming input should not be NULL
	 * @return a boolean value true if the input is Integer and false in it is not an Integer
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
	
	public static void main(String args[])
	{
		
		Scanner sc = new Scanner(System.in);
		MenuStrings menuStrings = new MenuStrings();
		StringOperations stringOperations = new StringOperations();
		
		String input_string1,input_string2,resultant_string;
		int userChoice=0;
		boolean flag=false;
		String temp_input;
		
		menuStrings.showMenu();
		
		while(!flag)								//loop checks for the input given by the user should be an integer
		{
			
			temp_input=sc.next();
			flag=menuStrings.checkInteger(temp_input);
			
			if(!flag)
			{		
				System.out.println("Only Integers!!!");
				System.out.println("Re-Enter the choice");
				menuStrings.showMenu();	
			}
			
			else
			{
				userChoice=Integer.parseInt(temp_input);
			}
		}
		
		while( userChoice != 5)
		{
			
			flag=false;							// for again checking for the given input by the user at the end of the loop
			
			switch(userChoice)
			{
			
			case 1:
				
				System.out.println("Enter the first String...");
				sc.nextLine();
				input_string1=sc.nextLine();
				
				System.out.println("Enter the second string...");
				input_string2=sc.nextLine();
				
				resultant_string=String.valueOf(stringOperations.returnComparison(input_string1, input_string2));
				
				System.out.println("Comparison is..."+resultant_string);
				
				break;
				
			case 2:
				
				System.out.println("Enter the string to be reversed....");
				sc.nextLine();
				input_string1=sc.nextLine();
				
				resultant_string=stringOperations.returnReverse(input_string1);
				
				System.out.println(resultant_string);
				
				break;
				
			case 3:
				
				System.out.println("Enter the string to be modified...");
				sc.nextLine();
				input_string1=sc.nextLine();
				
				resultant_string=stringOperations.returnModifiedString(input_string1);
				
				System.out.println(resultant_string);
				
				break;
				
			case 4:
				
				System.out.println("Enter the sentence to find the largest word...");
				sc.nextLine();
				input_string1=sc.nextLine();
				
				resultant_string=stringOperations.returnMaximumLengthWord(input_string1);
				
				System.out.println(resultant_string);
				
				break;
				
			case 5:
				
				System.exit(0);
				
				break;
				
			default:
				
				System.out.println("Invalid Choice");
				
			}
			
		menuStrings.showMenu();
		
		while(!flag)				//loop checks for the input given by the user should be an integer
		{
			
			temp_input=sc.next();
			
			flag=menuStrings.checkInteger(temp_input);
			
			if(!flag)
			{
				System.out.println("Only Integers!!!");
				System.out.println("Re-Enter the choice");
				menuStrings.showMenu();
			}
			
			else
			{
				userChoice=Integer.parseInt(temp_input);
			}
			
		}
			
		}
		
		sc.close();
	}
}
