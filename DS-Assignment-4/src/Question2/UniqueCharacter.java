package Question2;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class UniqueCharacter
{
	
	HashMap<String, Integer> cache= new HashMap<>();
	
	/**
	 * This method will calculate the number of unique character in the given string
	 * @param input 
	 * @return the number of unique character
	 */
	public int numberOfUniqueCharacter(String input)
	{
		int result=0;
		
		//checking the input is available in the cache or not
		if(cache.containsKey(input)){
			result = cache.get(input);
			System.out.println("ye");
			return result;
		}
		
		//map to store the character with the number of count available in the input string
		HashMap<Character, Integer> uniquecharacter= new HashMap<>();
		
		//it will count the number of the each character and stores into the map with count as value
		for(int i=0;i<input.length();i++)
		{
				char tempChar= input.charAt(i);
				if(uniquecharacter.containsKey(tempChar))
				{
					int val= uniquecharacter.get(tempChar);
					uniquecharacter.put(tempChar,val+1);
				}
				
				else
					uniquecharacter.put(tempChar, 1);
				
		}
		//convert the key of map into the set
		Set<Character> keyset= uniquecharacter.keySet();

		Iterator<Character> iterator = keyset.iterator(); 

		//calculating the number of unique character
		while(iterator.hasNext())
		{
			if(uniquecharacter.get(iterator.next()) == 1 )
				result ++;
		}
		
		cache.put(input, result);
		return result;
	}
}




