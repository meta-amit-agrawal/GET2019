import java.text.DecimalFormat;
import java.util.Scanner;


public class MarksheetMenu 
{
	//to round the values up to 2 decimal values
	DecimalFormat decimalFormat = new DecimalFormat(".##");
	
	
	//to show the menu to the user
	public void showMenu()
	{
		
		System.out.println("Choose the option below...");
		System.out.println("1. Return average of all grades. \r\n" + 
				"2. Return maximum of all grades.\r\n" + 
				"3. Return minimum of all grades.\r\n" + 
				"4. Return percentage of students passed.\r\n" + 
				"5. Exit");
		
	}
	
	/*
	 * checkInputInteger method use to check the input is integer or not and also should not be less than zero
	 * @param requires an input string which contains the input given by the user and should not be null
	 * @return the integer value inserted by the user if it is integer
	 */
	public int checkInputInteger(String input)
	{
		
		Scanner sc = new Scanner(System.in);
		
		boolean flag=false;
		int integer_input=0;
		
		while(!flag)
		{
			
			flag=checkInteger(input);
			
			if(!flag)
			{
				System.out.println("Only Integers!!Please Re-Enter...");
				input=sc.next();
			}
			
			else
			{
				
				while((integer_input=Integer.parseInt(input)) < 0)
				{
					System.out.println("cannot be negative!!\nPlease re-enter");
					input=sc.next();
					flag=false;
					break;	
				}
				
			}
			
		}
		
		return integer_input;
		
	}
	
	/*
	 * checkInputDouble method use to check the input is double or not and also should not be less than zero
	 * @param requires an input string which contains the input given by the user and should not be null
	 * @return the double value inserted by the user if it is double
	 */
	public Double checkInputDouble(String input)
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
				
				while((double_input=Double.parseDouble(input)) < 0)
				{
					System.out.println("cannot be negative!!\nPlease re-enter");
					input=sc.next();
					flag=false;
					break;			
				}
				
			}
		}
		
		
		return Double.parseDouble(decimalFormat.format(double_input));
	}
	
	/*
	 * checkDouble method use to check the input is double or not
	 * @param requires the input value in string format and should not be null
	 * @return a boolean value true of it is double or false it not
	 */
	public boolean checkDouble(String input)
	{
		
		try
		{
			new Double(input);
			return true;
		}
		
		catch(Exception e)
		{
			return false;
		}
		
	}
	
	/*
	 * checkInteger method use to check the input is integer or not
	 * @param requires the input value in string format and should not be null
	 * @return a boolean value true of it is integer or false it not
	 */
	public boolean checkInteger(String input)
	{
		
		try
		{
			new Integer(input);
			return true;
		}
		
		catch(Exception e)
		{
			return false;
		}
		
	}
	
	public static void main(String args[])
	{
		
		MarksheetMenu marksheetMenu = new MarksheetMenu();
		Marksheet marksheet = new Marksheet();
		Scanner sc = new Scanner(System.in);
		
		String temp_input="";
		double result,temp_double_input;
		int user_choice=0,number_of_students=0,loop;
		boolean flag=false;
		
		System.out.println("Enter the number of students....");
		
		//loop to check the number_of_students has valid input or not
		while(!flag)
		{
			temp_input=sc.next();
			
			number_of_students=marksheetMenu.checkInputInteger(temp_input);
			if(number_of_students==0)
			{
				System.out.println("Number of students can't be zero");
			}
			else
			{
				flag=true;
			}
		}	
			
		//loop to enter the grades into the marks arraylist
		for(loop=0 ; loop<number_of_students ; loop++)
		{
			
			flag=false;
			
			System.out.println("Enter the grade of student "+(loop+1)+"...");
			
			while(!flag)
			{
				
				temp_double_input=marksheetMenu.checkInputDouble(sc.next());
				
				if(temp_double_input>100)
				{
					System.out.println("Grade should be between 0 to 100!!!\nPlease Re-Enter...");
					flag=false;
				}
				
				else
				{
					flag=marksheet.addGrades(temp_double_input);
				}
				
			}
			
		}
		
		marksheetMenu.showMenu();
		user_choice=marksheetMenu.checkInputInteger(sc.next());
		
		while(user_choice != 5)
		{
			
			flag=false;
			
			switch(user_choice)
			{
			
			case 1:
				
				try
				{
					result = marksheet.returnAverageOfGrades();
					System.out.println("The average of all grades is..."+result);
				}
				catch(ArithmeticException e)
				{
					e.getMessage();
				}
				
				break;
				
			case 2:
				
				try
				{
					result = marksheet.returnMaximumOfGrades();
					System.out.println("The maximum from all grades is..."+result);
				}
				catch(ArithmeticException e)
				{
					System.out.println("Arithmetic Exception Occurred");
				}
				
				break;
				
			case 3:
				
				try
				{
					result = marksheet.returnMinimumOfGrades();
					System.out.println("The minimum from all grades is..."+result);
				}
				catch(ArithmeticException e)
				{
					System.out.println("Arithmetic Exception Occurred");
				}
					
				break;
				
			case 4:
				
				try
				{
					result = marksheet.returnPercentageOfPassed();
					System.out.println("The percentange of student passed is..."+result);
				}
				catch(ArithmeticException e)
				{
					System.out.println("Arithmetic Exception Occurred");
				}
				
				break;
				
			case 5:
				
				System.exit(0);
				
				break;
				
			default:
				
				System.out.println("Invalid Choice!!!");
			}
			
			System.out.println("\n");
			
			marksheetMenu.showMenu();
			user_choice=marksheetMenu.checkInputInteger(sc.next());

		}
		
	sc.close();
	
	}
	
}
