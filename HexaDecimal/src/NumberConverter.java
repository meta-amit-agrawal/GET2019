
public class NumberConverter 
{
	/*
	 * decimalToAnyBase method to convert any decimal number to any format of 
	 * number according to given base
	 * @param number1 of type string which holds the decimal number to be converted
	 * @return result which holds the converted number in the given base format
	 */
	public String decimalToAnyBase(String number , int base)
	{
		
		String list_of_number[] = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
		String result="";
		
		int temp_num;
		int remainder;
		
		temp_num = Integer.parseInt(number);
		
		while(temp_num > 0)
		{
			
			remainder = temp_num % base;
			result = list_of_number[remainder] + result;
			temp_num = temp_num / base;
			
		}
		
		return result;
		
	}
	
	/*
	 * anyBaseToDecimal method to convert any format of number to decimal format number
	 * @param number1 of type string which holds the decimal number to be converted
	 * @return result which holds the converted number in the decimal format
	 */
	public String anyBaseToDecimal(String number , int base)
	{
		
		String number_directory="0123456789ABCDEF";
		int result = 0;
		int loop1;
		
		for(loop1 = 0 ; loop1 < number.length() ; loop1++)
		{
			
			char current_character = number.charAt(loop1);
			int value_of_char = number_directory.indexOf(current_character);
			result = result + (int)(Math.pow(base, number.length()-loop1-1) * value_of_char);
			
		}
		
		return ""+result;
		
	}
}
