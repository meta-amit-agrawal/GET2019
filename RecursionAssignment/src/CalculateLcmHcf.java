
public class CalculateLcmHcf 
{
	/*
	 * getHCF method used to find the HCF between first and second number
	 * @param first is of integer type value which holds the first value to find HCF
	 * @param second is of integer type value which holds the second value to find HCF
	 * @return the computed HCF between first and second value
	 */
	static int getHCF( int first, int second )
	{
		
		try
		{
			if( second == 0)
			{
				return first;
			}
			
			else
			{
				return getHCF( second, first % second );
			}
		}
		catch(StackOverflowError stackOverflowError)
		{
			throw stackOverflowError;
		}
		
	}
	
	/*
	 * getLCM method used to find the LCM between first and second number, This method make use of getHCF method 
	 * to find the LCM between two values given as parameter
	 * @param first is of integer type value which holds the first value to find LCM
	 * @param second is of integer type value which holds the second value to find LCM
	 * @return the computed LCM between first and second value
	 */
	static int getLCM( int first , int second )
	{
		
		try
		{
			int lcm,hcf;
			
			hcf = getHCF(first, second);
			
			lcm = (first * second) / hcf;
			
			return lcm;
		}
		
		catch(StackOverflowError stackOverflowError)
		{
			throw stackOverflowError;
		}
		
	}
	
}