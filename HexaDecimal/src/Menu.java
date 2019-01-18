import java.util.Scanner;

public class Menu 
{
	public void showMenu()
	{
		System.out.println("1. Convert Hexadecimal number into Decimal number ");
		System.out.println("2. Convert Decimal number into Hexadecimal number");
		System.out.println("3. Arithmatic Operations");
		System.out.println("4. Comapre Two Hexadecimal Number");
		System.out.println("5. exit ");
	}
	public static void main(String[] args) 
	{
		
		NumberConverter numberConverter=new NumberConverter();
		OperationsOnNumber operationsOnNumber=new OperationsOnNumber();
		Menu menu=new Menu();
		
		Scanner sc=new Scanner(System.in);
		
		int userChoice,base=16;
		String number1,number2,result;
		boolean compare_result;
		
		menu.showMenu();
		userChoice=sc.nextInt();
		
		//while loop for recursively showing the option until user wants to exit
		
		while(userChoice!=5)
		{
			//switch case to execute according to user option
			switch(userChoice)
			{
			case 1:
				
				System.out.println("Enter the Hexadecimal Number...");
				number1=sc.next();
				
				result=numberConverter.anyBaseToDecimal(number1, base);
				
				System.out.println("The decimal Number is..."+result);
				
				break;
				
			case 2:
				
				System.out.println("Enter the decimal number...");
				number1=sc.next();
				
				result=numberConverter.decimalToAnyBase(number1, base);
				
				System.out.println("\nThe Hexadecimal number is..."+result);
				
				break;
				
			case 3:
				
				System.out.println("Enter the first Hexadecimal Number...");
				number1=sc.next();
				
				System.out.println("Enter the second Hexadecimal Number...");
				number2=sc.next();
				
				System.out.println("1. Add Two Hexadecimal Numbers");
				System.out.println("2. Subtract Two Hexadecimal Number");
				System.out.println("3. Multiply Two Hexadecimal Number");
				System.out.println("4. Divide Two Hexadecimal Number");
				
				int arith_choice;
				arith_choice=sc.nextInt();
				
				//switch case to show various arithmetic operations 
					switch(arith_choice)
					{
					case 1:
						
						result=operationsOnNumber.addNumbers(number1, number2, base);
						System.out.println("The Result of addition is..."+result);
						break;
						
					case 2:
						
						result=operationsOnNumber.subtractNumbers(number1, number2, base);
						System.out.println("The Result of substraction is..."+result);
						break;
						
					case 3:
						
						result=operationsOnNumber.multiplyNumbers(number1, number2, base);
						System.out.println("The Result of multiplication is..."+result);
						break;
						
					case 4:
						
						String resultdiv[]=new String[2];
						resultdiv=operationsOnNumber.divideNumbers(number1, number2, base);
						System.out.println("Quotient is..."+resultdiv[0]);
						System.out.println("Remainder is..."+resultdiv[1]);
						break;
						
					default:
						
						System.out.println("Invalid Choice!!");
					}
				break;
				
			case 4:
				
				System.out.println("Enter the first Hexadecimal Number...");
				number1=sc.next();
				
				System.out.println("Enter the second Hexadecimal Number...");
				number2=sc.next();
				
				System.out.println("1. Check First Number is greater than Second");
				System.out.println("2. Check First Number is less than Second");
				System.out.println("3. Check Equality");
				
				int compare_choice;
				compare_choice=sc.nextInt();
				
				//switch case to various comparisons options
					switch(compare_choice)
					{
					case 1:
						
						compare_result=operationsOnNumber.greater(number1, number2, base);
						System.out.println("Result is..."+compare_result);
						break;
						
					case 2:
						
						compare_result=operationsOnNumber.lesser(number1, number2, base);
						System.out.println("Result is..."+compare_result);
						break;
						
					case 3:
						
						compare_result=operationsOnNumber.equality(number1, number2, base);
						System.out.println("Result is..."+compare_result);
						break;
						
					default:
						
						System.out.println("Invalid Choice!!");
						
				}
				break;
				
			case 5:
				
				System.exit(0);
				break;
				
			default:
				
				System.out.println("Invalid Choice");
			}
			
			menu.showMenu();
			userChoice=sc.nextInt();
			
		}
		
		System.out.println("Thank You!!!");
		sc.close();
		
	}

}
