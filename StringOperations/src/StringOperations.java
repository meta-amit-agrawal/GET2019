
public class StringOperations 
{
	
	/*
	 * returnReverse method is used to reverse the given input string
	 * @param input_string of type string which holds the input string given by the user assumes string is not NULL
	 * @return reverse_string variable which holds the reversed string of given input string
	 */
	public String returnReverse(String input_string)
	{
		
		int loop,length_of_string;
		String reverse_string="";
		
		length_of_string=input_string.length();
		
		for(loop=length_of_string-1;loop>=0;loop--)
			reverse_string=reverse_string+input_string.charAt(loop);
		
		return reverse_string;
		
	}
	
	/*
	 * retrunModifiedString method used to modify the given string from lower case to upper case or vice versa
	 * @param input_string of type string which holds the input string given by the user assumes string is not NULL
	 * @return resultant_string which contains the modified string 
	 */
	public String returnModifiedString(String input_string)
	{
		
		int loop,length_of_string,asci;
		char current_char;
		String resultant_string="";
		
		length_of_string=input_string.length();
		
		for(loop=0;loop<length_of_string;loop++)
		{
			
			current_char=input_string.charAt(loop);
			asci=(int)current_char;
			
			if(asci>=65 && asci <=90)				
				asci=asci+32;

			else if(asci >=97 && asci <=122)
				asci=asci-32;

			resultant_string=resultant_string+(char)asci;
		}
		
		return resultant_string;
	}
	
	/*
	 * returnComparison method used to compare two strings which is case sensitive in nature
	 * @param input_string1 which holds the first string given by the user, Assumes string is not null
	 * @param input_string2 which holds the second string for comparison, assumes string is not null
	 * @return the boolean value true if both strings are equal and false if two strings are not equal
	 */
	public int returnComparison(String input_string1 , String input_string2)
	{
		int loop;
		
		//removing the unwanted space from the beginning and the after the end of the string
		input_string1=input_string1.trim();
		input_string2=input_string2.trim();
		
		if(input_string1.length()!=input_string2.length())
			return 0;
		
		else
		{
			
			for(loop=0;loop<input_string1.length();loop++)
			{	
				if(input_string1.charAt(loop)!=input_string2.charAt(loop))
					return 0;	
			}
			
			return 1;
			
		}
	}
	
	/*
	 * returnMaximumLengthWord method is used to find the word of maximum length and if two word are of same length then returns the last word from the sentence
	 * @param input_stirng which contains the sentence given by the user, assumes input_string should not be null
	 * #return the word of maximum length from the input string
	 */
	public String returnMaximumLengthWord(String input_string)
	{
		
		String max_length_word="";
		String current_word="";
		int loop;
		
		for(loop=0;loop<input_string.length();loop++)
		{
			//checking the input character should not be space and must be a valid character
			if(input_string.charAt(loop)!=' ' && ((int)input_string.charAt(loop)>=65 && (int)input_string.charAt(loop)<=90) || ((int)input_string.charAt(loop)>=97 && (int)input_string.charAt(loop)<=122) || ((int)input_string.charAt(loop)>=48 && (int)input_string.charAt(loop)<=57) )				
				current_word=current_word+input_string.charAt(loop);

			//checking for the occurrence of space or any other character other than alphabet 
			else if(input_string.charAt(loop)==' ' || !(((int)input_string.charAt(loop)>=65 && (int)input_string.charAt(loop)<=90) || ((int)input_string.charAt(loop)>=97 && (int)input_string.charAt(loop)<=122) || ((int)input_string.charAt(loop)>=48 && (int)input_string.charAt(loop)<=57)  ))
				current_word="";
			
			//finding the word of maximum length
			if(current_word.length()>=max_length_word.length())
				max_length_word=current_word;
			
		}
		
		return max_length_word;
	}
	
}
