
public class ArrayOperations 
{
	
	/*
	 * maximumMirrorCount method is used to find the sub-array which is mirror image of already present sub-array
	 * @param requires the input array of integer, will throw an exception if array is null, assumes input is array of positive integers
	 * @return the length of array whose mirror image is available else will return the exception
	 */
	
	public int maximumMirrorCount(int[] input_array)
	{
		
		int max_length,index1,index2,temp_index1,temp_length,length;
		
		max_length = temp_length = 0;
		
		try
		{
			length = returnLengthArray(input_array);
			
			for(index1 = 0 ; index1 < length ; index1++)
			{
				
				temp_index1 = index1;	//assign the index for second loop comparison and manipulation will be done on this only 
				
				for(index2 = length-1 ; index2 >= 0 ; index2--)
				{
					
					if(temp_index1 < length && input_array[temp_index1] == input_array[index2])
					{
						temp_length++;
						temp_index1++;
					}
					
					else
					{
						
						if(max_length < temp_length)
						{
							max_length = temp_length;
							temp_length = 0;
						}
						
						temp_length = 0;
					}
					
				}
				
			}
			
			return max_length;
		}
		
		catch(AssertionError assertionError)
		{
			throw assertionError;
		}
				
	}
	
	/*
	 * splitArray method to find the index where the sum of left side and right side is equal
	 * @param requires the array if integers ,will throw an exception if array is empty ,assumes input is array of positive integers
	 * @return the index where the sum of left and right side is equal or will return an exception
	 *         or if sum is not equal in any case then will return -1 
	 */
	public int splitArray(int[] input_array)
	{
		
		int left_sum,right_sum,index,left_loop,right_loop,length;
		
		try
		{
			length = returnLengthArray(input_array);
			for(index = 0 ; index < length ; index++)
			{
				
				left_sum = right_sum = 0;
				
				//loop to calculate the sum of left array
				for(left_loop = 0 ; left_loop < index ; left_loop++)
				{
					left_sum = left_sum + input_array[left_loop];
				}
				
				//loop to calculate the sum of right array
				for(right_loop = index ; right_loop < length ; right_loop++)
				{
					right_sum = right_sum + input_array[right_loop];
				}
				
				if (left_sum == right_sum) 
				{
					return index;
				}
				
			}
			
			return -1;
		}
		
		catch(AssertionError assertionError)
		{
			throw assertionError;
		}
					
	}
	
	/*
	 * countClumbs method is use to find the number of clumbs which have a series of 2 or more adjacent elements of the same value
	 * @param requires an array of integer type, will throw an exception if array is empty ,assumes input is array of positive integers
	 * @return the number of clumb 0 if any clumb is not present or will return the number of clumbs
	 */
	public int countClumbs(int[] input_array)
	{
		
		int index1,index2,clumb_count=0,count=1,length;
		int currentvalue,previousvalue;
		
		try
		{
			length = returnLengthArray(input_array);
			
			//loop to find the clumbs from the input array
			for(index1=0;index1<length;index1++)
			{
				
				previousvalue = input_array[index1];
				
				//loop will check for the next upcoming same values
				for(index2=index1+1 ; index2<length ; index2++) 
				{
					
					currentvalue = input_array[index2];
					
					if(previousvalue == currentvalue)
					{
						count+=1;
					}
					
					else
					{
						break;
					}
					
				}
				
				index1=index2-1;
				
				//it will check for the same values occurred continuously, if the value is present 
				//more than twice then a clumb is detected
				if(count>=2)
				{
					clumb_count+=1;
					count=1;
				}
				
			}
			
			return clumb_count;
		}
		
		catch(AssertionError assertionError)
		{
			throw assertionError;
		}
				
	}
	
	/*
	 * fitXY will change the position of Y after the value of X without changing the position of X
	 * @param requires the array of Integer assumes array is of integer type,
	 * 		  value_of_x, value_of_y, which will hold the value of X and Y
	 *        it will throw an exception an exception in the following cases:
	 *        1: if array is empty
	 *        2: if two consecutive value of X is present in an array
	 *        3: it value of X is present at the last index of array
	 *        4: if total number of X is not equal to total number of Y
	 * @return an array of integer with the modification as stated.
	 */
	public int[] fitXY(int[] input_array , int value_of_X , int value_of_Y)
	{
		
		int length,currentValue,nextValue;
		int index,indexofX,indexofY,temp,countX,countY;
		boolean flagX,flagY,flagadjacent=false;
		
		countX = countY = 0;
		indexofX = indexofY = 0;
		flagX = flagY = false;
		
		try
		{
			//block to check for exception
			length = returnLengthArray(input_array);
			
			//loop to trace the array
			for(index=0;index<length;index++)
			{
				currentValue = input_array[index];
				
				//to count the number of X present in array
				if(value_of_X==currentValue)
				{
					countX++;
				}
				
				//to count the number of Y present in array
				if(value_of_Y==currentValue)
				{
					countY++;
				}
				
				//to check for consecutive X in an array
				if(currentValue==value_of_X && index+1<length)
				{
					
					nextValue = input_array[index+1];
					
					if(nextValue==value_of_X)
					{
						flagadjacent=true;
					}
					
				}
				
			}
			
			//check whether number of X and Y are equal or not
			if(countX != countY)
			{
				throw new AssertionError();
			}
			
			else if(flagadjacent)
			{
				throw new AssertionError();
			}
			
			//to check that last element is X or not
			else if(input_array[length-1]==value_of_X)
			{
				throw new AssertionError();
			}
			
			else
			{
				
				for (index = 0 ; index < length ; index++)
				{
					
					currentValue = input_array[index];
					
					//check whether x is followed by Y or not
					if(currentValue == value_of_X && input_array[index+1] == value_of_Y)
					{
						continue;
					}
					
					//to find the index of X
					else if(currentValue == value_of_X)
					{
						flagX=true;
						indexofX = index;
					}
					
					//to find the index of Y
					else if(currentValue == value_of_Y)
					{
						flagY=true;
						indexofY = index;
					}
					
					
					//to swap the Y to next of X
					if(flagX && flagY )
					{
						temp=input_array[indexofX+1];
						input_array[indexofX+1]=input_array[indexofY];
						input_array[indexofY]=temp;
						flagX=flagY=false;
						index=indexofX+1;
					}
					
				}
				
				return input_array;
				
			}
			
		}
		catch(AssertionError assertionError)
		{
			throw assertionError;
		}
			
	}
	
	/*
	 * returnLengthArray method is used to compute the length of the input array
	 * @param requires an array of integers, assumes array is of integer type
	 * @return the length of array if array is not null, otherwise will throw an exception
	 */
	public int returnLengthArray(int[] input_array)
	{
		int length_array=input_array.length;
		
		if(length_array == 0)
		{
			throw new AssertionError();
		}
		
		else 
			return length_array;
	}
	
	
}
