
public class ArrayOperations 
{
	public int maximumMirrorCount(int[] input_array)
	{
		int max_length,loop1,loop2,temp_loop1,temp_length;
		
		max_length = temp_length = 0;
		
		if(input_array.length == 0)
		{
			throw new AssertionError();
		}
		
		else
		{
			for(loop1 = 0 ; loop1 < input_array.length ; loop1++)
			{
				
				temp_loop1 = loop1;
				
				for(loop2 = input_array.length-1 ; loop2 >= 0 ; loop2--)
				{
					
					if(temp_loop1 < input_array.length && input_array[temp_loop1] == input_array[loop2])
					{
						temp_length++;
						temp_loop1++;
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
		
		
		
	}
	
	public int splitArray(int[] input_array)
	{
		int left_sum,right_sum,loop,left_loop,right_loop;
		
		if(input_array.length==0)
		{
			throw new AssertionError();
		}
		
		else
		{
			for(loop = 0 ; loop < input_array.length ; loop++)
			{
				
				left_sum = right_sum = 0;
				
				for(left_loop = 0 ; left_loop < loop ; left_loop++)
				{
					left_sum = left_sum + input_array[left_loop];
				}
				
				for(right_loop = loop ; right_loop < input_array.length ; right_loop++)
				{
					right_sum = right_sum + input_array[right_loop];
				}
				
				if (left_sum == right_sum) 
				{
					return loop;
				}
				
			}
			
			return -1;
		}
		
		
		
	}
	
	public int countClumbs(int[] input_array)
	{
		int loop1,loop2,clumb_count=0,count=1;
		
		if(input_array.length==0)
		{
			throw new AssertionError();
		}
		
		else
		{
			for(loop1=0;loop1<input_array.length;loop1++)
			{
				for(loop2=loop1+1 ; loop2<input_array.length ; loop2++) 
				{
					if(input_array[loop1] == input_array[loop2])
					{
						count+=1;
					}
					else
					{
						break;
					}
				}
				loop1=loop2-1;
				if(count>=2)
				{
					clumb_count+=1;
					count=1;
				}
			}
			return clumb_count;
		}
		
		
	}
	
	public int[] fitXY(int[] input_array , int value_of_X , int value_of_Y)
	{
		int length=input_array.length;
		int loop,indexofX,indexofY,temp,countX,countY;
		countX = countY = 0;
		indexofX = indexofY = 0;
		boolean flagX,flagY,flagadjacent=false;
		flagX = flagY = false;
		
		if(length==0)
		{
			throw new AssertionError("Array can't be empty");
		}
		
		else 
		{
			for(loop=0;loop<length;loop++)
			{
				if(value_of_X==input_array[loop])
				{
					countX++;
				}
				else if(value_of_Y==input_array[loop])
				{
					countY++;
				}
				else if(input_array[loop]==value_of_X && loop+1<length)
				{
					if(input_array[loop+1]==value_of_X)
					{
						flagadjacent=true;
					}
				}
			}
			if(countX != countY)
			{
				throw new AssertionError();
			}
			else if(flagadjacent)
			{
				throw new AssertionError();
			}
			else if(input_array[length-1]==value_of_X)
			{
				throw new AssertionError();
			}
			else
			{
				for (loop = 0 ; loop < length ; loop++)
				{
					if(input_array[loop] == value_of_X && input_array[loop+1] == value_of_Y)
					{
						continue;
					}
					else if(input_array[loop] == value_of_X)
					{
						flagX=true;
						indexofX = loop;
					}
					else if(input_array[loop] == value_of_Y)
					{
						flagY=true;
						indexofY = loop;
					}
					if(flagX && flagY )
					{
						temp=input_array[indexofX+1];
						input_array[indexofX+1]=input_array[indexofY];
						input_array[indexofY]=temp;
						flagX=flagY=false;
						loop=indexofX+1;
					}
				}
				return input_array;
			}
			
		}
		
		
	}
	
	public static void main(String args[])
	{
		ArrayOperations arrayOperations = new ArrayOperations();
		int array[]= {1,4,1,5,5,4,1};
		int num[]=arrayOperations.fitXY(array, 4, 5);
		for(int i=0;i<num.length;i++)
		{
			System.out.print(" "+num[i]);
		}
	}
}
