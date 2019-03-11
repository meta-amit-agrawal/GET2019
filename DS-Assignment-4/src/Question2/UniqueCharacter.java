package Question2;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class UniqueCharacter
{
	HashMap<String, Integer> cache= new HashMap<>();
		
	public int numberOfUniqueCharacter(String input)
	{
		int result=0;
			
		if(cache.containsKey(input))
		{
			result = cache.get(input);
			System.out.println("ye");
			return result;
		}
		
		HashMap<Character, Integer> uniquecharacter= new HashMap<>();
		
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
		 	Set<Character> keyset= uniquecharacter.keySet();
		
		 	
		
		Iterator<Character> iterator = keyset.iterator(); 

		while(iterator.hasNext())
		{
			if(uniquecharacter.get(iterator.next()) == 1 )
				result ++;
		}
		
		cache.put(input, result);
		return result;
	}
		
		
	public static void main(String args[])
	{
		UniqueCharacter nu= new UniqueCharacter();
		int value=nu.numberOfUniqueCharacter("aqwe@#$qwea@#");
		System.out.println(value);
		System.out.println(nu.numberOfUniqueCharacter("paravijay"));
				
	}
		
		
}




