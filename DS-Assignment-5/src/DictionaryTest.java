import java.io.FileReader;

import static org.junit.Assert.*;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Before;
import org.junit.Test;

public class DictionaryTest 
{
	
	Dictionary dictionary;
	
	//initialize the tree with the data from JSON file
	@Before
	public void initializeAddDataToTree() throws Exception
	{
		JSONObject json = null;
		JSONParser parser = new JSONParser();
	    try 
	    {
	        json = (JSONObject) parser.parse(new FileReader("keyvalue.json"));
	    }
	    catch(Exception e)
	    {
	        System.out.println(e.getMessage());
	    }
	    dictionary = new DictionaryImpl(json);
	}
	
	//Test case to get the sorted list of key and values
	@Test
	public void getAll() throws Exception
	{
		for(Data d : dictionary.getSortedKeyValue())
		{
			System.out.println(d.getKey()+"  "+d.getValue());
		}
	}
	
	//Negative test case of adding the node with existing key
	@Test(expected = Exception.class)
	public void addKey() throws Exception
	{
		dictionary.add("100", "Hundred");
	}
	
	//Positive test case of deleting the data
	@Test
	public void deletNode() throws Exception
	{
		dictionary.delete("200");
		System.out.println("\nAfter Deletion\n");
		getAll();
	}
	
	//negative test case of deleting the node with key which doesn't exist
	@Test(expected = Exception.class)
	public void deleteNode1() throws Exception
	{
		dictionary.delete("1000");
	}
	
	//Negative test case to delete node with key as null
	@Test(expected = Exception.class)
	public void deleteNode2() throws Exception
	{
		dictionary.delete("");
	}
	
	//Positive test case to get the sublist from the tree
	@Test
	public void getSubTree() throws Exception
	{
		System.out.println("\nSublist contains\n");
		for(Data d : dictionary.getSortedKeyValueBetweenKeys("200", "300"))
		{
			System.out.println(d.getKey()+"  "+d.getValue());
		}
	}
	
	//Negative test case to get sublist in which key doesn't exist
	@Test(expected = Exception.class)
	public void getSubTree1() throws Exception
	{
		dictionary.getSortedKeyValueBetweenKeys("200", "1000");
		
	}
	
	//Negative test case to get sublist in which key is null
	@Test(expected = Exception.class)
	public void getSubTree2() throws Exception
	{
		dictionary.getSortedKeyValueBetweenKeys("200", "");	
	}
	
	//positive test case to get the value of given key
	@Test
	public void getValueOfKey() throws Exception
	{
		assertEquals("Four Hundred", dictionary.getValue("400"));
	}
	
	//Negative test case of getting the value where key is null
	@Test(expected = Exception.class)
	public void getValueOfKey1() throws Exception
	{
		dictionary.getValue("");
	}
	
	//Negative test case to get the value where key doesn't exist in tree
	@Test(expected = Exception.class)
	public void getValueOfKey2() throws Exception
	{
		dictionary.getValue("10000");
	}
}
