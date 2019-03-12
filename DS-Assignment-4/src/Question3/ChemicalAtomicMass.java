package Question3;

import java.util.HashMap;

public class ChemicalAtomicMass 
{
	//map to store the atomic mass of the elements
	HashMap<Character, Integer> elementMass = new HashMap<Character, Integer>();
	
	//constructor will initialize the elements with the atomic mass 
	public ChemicalAtomicMass()
	{
		elementMass.put('C', 12);
		elementMass.put('H', 1);
		elementMass.put('O', 16);
	}
	
	/**
	 * updateMap will update the data into the map with corresponding parameters passed
	 * @param tempChar which is the key to be added into the map
	 * @param factor 
	 * @param map is the reference of the map in which the data is to be added
	 * @throws Exception if element passed is not available in the elementMass map
	 */
	private void updateMap(char tempChar, int factor, HashMap<Character, Integer> map) throws Exception
	{
		if(elementMass.containsKey(tempChar))
		{
			if(map.containsKey(tempChar))
			{
				int value = map.get(tempChar);
				map.put(tempChar, value+factor);
			}
			else
			{
				map.put(tempChar, factor);
			}
		}
		else
		{
			throw new Exception("Element Doesn't Exist");
		}
	}
	
	/**
	 * convertToMap method will convert the input string in the map format
	 * @param input is the string which is converted into map
	 * @return the converted string into the map
	 * @throws Exception if element is not present
	 */
	private HashMap<Character, Integer> convertToMap(String input) throws Exception
	{
		int index=0,j,factor;
		boolean flag = false;
		HashMap<Character, Integer> compound = new HashMap<Character, Integer>();
		HashMap<Character, Integer> temp = new HashMap<Character, Integer>();
		while(index < input.length()){
			factor=1;
			char tempChar = input.charAt(index);
			j=index+1;
			
			if(j<input.length()){
				char tempNext = input.charAt(j);
				if(Character.isDigit(tempNext)){
					factor = Character.getNumericValue(tempNext);
				}
			}
			if(tempChar == '('){
				flag=true;
				index++;
				continue;
			}
			if(tempChar == ')'){
				flag=false;
				if(factor>1){
					for(char c : temp.keySet()){
						temp.put(c, temp.get(c)*factor);
					}
				}
				index=updateIndex(factor, index);
				continue;
			}
			if(!flag){
				updateMap(tempChar, factor, compound);
				index=updateIndex(factor, index);
				continue;
			}
			if(flag){
				updateMap(tempChar, factor, temp);
				index=updateIndex(factor, index);
			}
		}
		merge(compound,temp);
		return compound;
	}
	
	/**
	 * merge is the private helper method which will merge the two maps
	 * @param compound is the one map in which the temp map is to be merged
	 * @param temp is the map which is to be merged into the compound
	 */
	private void merge(HashMap<Character, Integer> compound,  HashMap<Character, Integer> temp)
	{
		for(char tempChar : temp.keySet())
		{
			if(compound.containsKey(tempChar))
			{
				compound.put(tempChar, compound.get(tempChar)+temp.get(tempChar));
			}
			else
			{
				compound.put(tempChar, temp.get(tempChar));
			}
		}
		temp.clear();
	}
	
	/**
	 * calculateMass method to calculate the atomic mass of the compound given
	 * @param input is the string of which the atomic mass to be calculated
	 * @return the atomic mass of the string given as input
	 * @throws Exception if element is not present into the elementMass
	 */
	public int calculateMass(String input) throws Exception
	{
		int mass = 0;
		HashMap<Character, Integer> compound = convertToMap(input);
		
		
		for(Character c : compound.keySet())
		{
			if(compound.get(c)>0)
			{	
				mass = mass + elementMass.get(c)*compound.get(c);
			}
		}
		
		return mass;
	}
	
	/**
	 * updateIndex method is the private helper method which updates the index acc. to factor
	 * @param factor
	 * @param index
	 * @return the updated index
	 */
	private int updateIndex(int factor,int index)
	{
		if(factor>1)
		{
			return index+=2;
		}
		return index+=1;
	}
}
