public class Search 
{
	/*
	 * binarySearch method to find the particular element is present in the given array or not
	 * @param input array of double type, assumes array to be sorted for binary search 
	 * 			or will throw an assertion error if array is null
	 * @param low is integer type value which is starting index of the array 
	 * @param high is integer type which is the last index of the array
	 * @param search element is double type which is the element to be search in the given array
	 * @return the index at which the element found in an array or else will 
	 * 			return -1 if element is not present 
	 */
	static int  binarySearch(double[] inputArray , int low , int high , double searchelement)
	{
		
		int lengthArray;
		
		try
		{
			
			lengthArray = returnLengthArray(inputArray);
			
			if(high >= low  && low >= 0)
			{
				
				int mid = (low + high) / 2;
				
				//check for the element to be at mid of the array
				if( inputArray[mid] == searchelement )
				{
					return mid;
				}
				
				//if searchElement is greater then it should be present in the right side of the array
				if( inputArray[mid] < searchelement )
				{
					return binarySearch(inputArray, mid+1, high, searchelement);
				}
				
				//if the above condition gets false the searchElement should be present in the left side of the array
				else
				{
					return binarySearch(inputArray, low, mid-1, searchelement);
				}
				
			}
			
			//if element is not found in the array then the method will return -1
			else
			{
				return -1;
			}
			
		}
		
		catch(AssertionError assertionError)
		{
			throw assertionError;
		}
		
		catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException)
		{
			throw arrayIndexOutOfBoundsException;
		}
		
		
		
	}
	
	/*
	 * linearSearch is the method is used to find the element given by user is present 
	 * 			in given array or not
	 * @param input array of double type, will throw an assertion error if array is null
	 * @param index is integer type which holds the current index at which 
	 * 			the searching of element is done
	 * @param search element is double type value which holds the element to be searched for
	 * @return the index at which the element is founded in array or else will return -1 
	 * 			if element is not present in given array  
	 */
	static int linearSearch(double[] inputArray , int index , double searchelement)
	{
		int arrayLength;
		try
		{
			arrayLength = returnLengthArray(inputArray);
			
			//index gets equal with array length the element is not present in array, then return -1
			if( index == arrayLength )
			{
				return -1;
			}
			
			//if searchElement gets found in the array the return the index of the element
			if( inputArray[index] == searchelement )
			{
				return index;
			}
			
			//if element is not found in above condition the it should recursively call to find at next index
			else 
			{
				return linearSearch(inputArray, index+1, searchelement);
			}
			
		}
		
		catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException)
		{
			throw arrayIndexOutOfBoundsException;
		}
		
		catch(AssertionError assertionError)
		{
			throw assertionError;
		}
		
	}
	
	/*
	 * returnLengthArray method is used to calculate the length of the given array
	 * @param requires the array of type double 
	 * @return the length of an array or else will throw an assertion error 
	 */
	static int returnLengthArray(double[] inputArray)
	{
		
		int arrayLength = inputArray.length;
		
		if(arrayLength > 0)
		{
			return arrayLength;
		}
		
		else
		{
			throw new AssertionError();
		}
		
	}
	
}