
public class OperationsOnNumber 
{
	
	NumberConverter numberConverter=new NumberConverter();
	
	/*
	 * addNumber method is use to perform addition on two number
	 * @param number1 which holds the first number
	 * @param number1 which holds the first number
	 * @param number1 which holds the base of input number
	 * @return the addition of two numbers in type string
	 */
	public String addNumbers(String number1 , String number2 , int base)
	{
		int decimal_num1,decimal_num2,decimal_sum;
		String result="";
		
		decimal_num1=Integer.parseInt((numberConverter.anyBaseToDecimal(number1, base))); //converts the number of any base to decimal format number
		decimal_num2=Integer.parseInt((numberConverter.anyBaseToDecimal(number2, base))); //converts the number of any base to decimal format number
		
		decimal_sum=decimal_num1+decimal_num2;
		
		result=numberConverter.decimalToAnyBase(String.valueOf(decimal_sum), base); //converts the decimal format number according to given base.
		
		return result;
		
	}
	
	/*
	 * subtractNumber method is use to perform subtract on two number
	 * @param number1 which holds the first number
	 * @param number1 which holds the first number
	 * @param number1 which holds the base of input number
	 * @return the subtraction of two numbers in type string
	 */
	public String subtractNumbers(String number1 , String number2 , int base)
	{
		int decimal_num1,decimal_num2,decimal_sub;
		String result="";
		
		decimal_num1=Integer.parseInt((numberConverter.anyBaseToDecimal(number1, base)));
		decimal_num2=Integer.parseInt((numberConverter.anyBaseToDecimal(number2, base)));
		
		decimal_sub=decimal_num1-decimal_num2;
		
		result=numberConverter.decimalToAnyBase(String.valueOf(Math.abs(decimal_sub)), base);
		
		if(decimal_num1<decimal_num2) //check if negative number obtained then return with '-' sign
			return "-"+result;
		
		else
			return result;
		
	}
	
	/*
	 * multiplyNumber method is use to perform multiplication of two number
	 * @param number1 which holds the first number
	 * @param number1 which holds the first number
	 * @param number1 which holds the base of input number
	 * @return the multiplication of two numbers in type string
	 */
	public String multiplyNumbers(String number1 , String number2 , int base)
	{
		int decimal_num1,decimal_num2,decimal_mul;
		String result="";
		
		decimal_num1=Integer.parseInt((numberConverter.anyBaseToDecimal(number1, base)));
		decimal_num2=Integer.parseInt((numberConverter.anyBaseToDecimal(number2, base)));
		
		decimal_mul=decimal_num1*decimal_num2;
		
		result=numberConverter.decimalToAnyBase(String.valueOf(decimal_mul), base);
		
		return result;
		
	}
	
	/*
	 * divideNumber method is use to perform division on two number
	 * @param number1 which holds the first number
	 * @param number1 which holds the first number
	 * @param number1 which holds the base of input number
	 * @return the array which holds two numbers in type string as quotient and remainder
	 */
	public String[] divideNumbers(String number1 , String number2 , int base)
	{
		int decimal_num1,decimal_num2,decimal_div,decimal_rem;
		String result[]=new String[2];
		
		decimal_num1=Integer.parseInt((numberConverter.anyBaseToDecimal(number1, base)));
		decimal_num2=Integer.parseInt((numberConverter.anyBaseToDecimal(number2, base)));
		
		decimal_div=decimal_num1/decimal_num2;
		decimal_rem=decimal_num1%decimal_num2;
		
		result[0]=numberConverter.decimalToAnyBase(String.valueOf(decimal_div), base);
		result[1]=numberConverter.decimalToAnyBase(String.valueOf(decimal_rem), base);
		
		return result;		
	}
	
	/*
	 * greater method is use to check first number is greater than second  number
	 * @param number1 which holds the first number
	 * @param number1 which holds the first number
	 * @param number1 which holds the base of input number
	 * @return the boolean value which says true or false 
	 */
	public boolean greater(String number1, String number2, int base)
	{
		int num1,num2;
		
		num1=Integer.parseInt(number1 , base);
		num2=Integer.parseInt(number2 , base);
		
		if(num1 > num2)
			return true;
		
		else
			return false;
		
	}
	
	/*
	 * lesser method is use to check first number is lesser than second  number
	 * @param number1 which holds the first number
	 * @param number1 which holds the first number
	 * @param number1 which holds the base of input number
	 * @return the boolean value which says true or false 
	 */
	public boolean lesser(String number1, String number2, int base)
	{
		int num1,num2;
		
		num1=Integer.parseInt(number1 , base);
		num2=Integer.parseInt(number2 , base);
		
		if(num1 < num2)
			return true;
		
		else
			return false;
	}
	
	/*
	 * equality method is use to check first number is equal to second  number
	 * @param number1 which holds the first number
	 * @param number1 which holds the first number
	 * @param number1 which holds the base of input number
	 * @return the boolean value which says true or false 
	 */
	public boolean equality(String number1, String number2, int base)
	{
		int num1,num2;
		
		num1=Integer.parseInt(number1 , base);
		num2=Integer.parseInt(number2 , base);
		
		if(num1 == num2)
				return true;
		
		else
				return false;
		
		
	}
}
