import java.util.ArrayList;
import java.util.List;

/////////////////////////////////Implementation Of Immutable Class//////////////////////////  

public final class IntSet 
{
	private int set[];
	
	
	
	//parameterized constructor to initialize the data member
	IntSet(int input[])
	{
		set = new int[input.length];
		set = input;
	}
	
	//private helper method to return the private data member
	private int[] getSet()
	{
		return this.set;
	}
	
	//linear search algorithm to find the element in the list input
	static boolean linearSearch(List inputList , int index , int searchelement)
	{
		try
		{
			
			int arrayLength;
			arrayLength =inputList.size();;
				
			//index gets equal with array length the element is not present in array, then return false
			if( index == arrayLength )
			{
				return false;
			}
			
			//if searchElement gets found in the array the return the index of the element
			if( (int)inputList.get(index) == searchelement )
			{
			return true;
			}
				
			//if element is not found in above condition the it should recursively call to find at next index
			else 
			{
				return linearSearch(inputList, index+1, searchelement);
			}
		}
		catch(Exception e)
		{
			throw e;
		}
			
	}
	
	//returns the length of current set
	public int size()
	{
		return set.length;
	}
	
	/*
	 * isMember method to check the member is present in set or not
	 * @param member, assumes member of type integer only
	 * @return true if member present and false if not
	 */
	public boolean isMember(int member)
	{
		try
		{
			
			int index,length;
			length = size();
			
			for(index = 0 ; index < length ; index++)
			{
				
				if(set[index] == member)
				{
					return true;
				}
				
			}
			
			return false;
		}
		
		catch(Exception e)
		{
			throw e;
		}
	}
	
	/*
	 * getComplement method to find the complement of set
	 * assumes the universal set consist of integer values from 0 to 1000
	 * @return the complement set
	 */
	public int[] getComplement()
	{
		try
		{
			
			int length = size();
			int complement[] = new int[1000 - length];
			int index1,index=0;
			
			
			for(index1 = 1; index1 <= 1000; index1++)
			{

				if(isMember(index1))
				{
					continue;
				}
				
				else
				{
					complement[index++] = index1;
				}
				
			}
			
			return complement;
		}
		
		catch(Exception e)
		{
			throw e;
		}
	}
	
	/*
	 * isSubSet method to check for the subset of another set
	 * @param requires object of class IntSet
	 * @return true if subset and false if not.
	 */
	public boolean isSubSet(IntSet subset_object)
	{
		try
		{
			int subset[] = subset_object.getSet();
			
			int subset_length,count=0;
			
			subset_length = subset_object.size();	
							
			for(int index2 = 0; index2 <subset_length; index2++)
			{
					
				if(isMember(subset[index2]))
				{
					count++;
				}
					
			}
			
			if(count == subset_length)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
		catch(Exception e)
		{
			throw e;
		}
		
	}
	
	/*
	 * union method to compute the union set between two set
	 * @param reqiures two object of class IntSet
	 * @return the array of integer as the union set of two give set
	 */
	
	public static int[] union(IntSet object1, IntSet object2)
	{
		try
		{
			int index1,index2,set1_length,set2_length;
			int set1[] = object1.getSet();
			int set2[] = object2.getSet();
			set1_length = object1.size();
			set2_length = object2.size();
			
			List<Integer> unionList = new ArrayList<Integer>();
			
			index1=index2=0;
			
			for(index1=0;index1<set1_length;index1++)
			{
				unionList.add(set1[index1]);
			}
			
			while(index2<set2_length)
			{
				
				//checks for element is already present or not
				if(linearSearch(unionList, 0, set2[index2]))
				{
					index2++;
					continue;
				}
				
				//if not present then added to list
				else
				{
					unionList.add(set2[index2]);
					index2++;
				}
				
			}
			
			int[] union = new int[unionList.size()];
			
			for(index1=0;index1<unionList.size();index1++)
			{
				union[index1] = unionList.get(index1);
			}
			
			return union;
		}
		
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	
}