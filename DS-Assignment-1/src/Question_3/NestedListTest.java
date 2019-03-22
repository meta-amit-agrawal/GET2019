package Question_3;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
public class NestedListTest 
{
	NestedListImpl nestedListImpl;
	
	@Before
	public void test() throws Exception
	{
		JSONArray json = null;
		JSONParser parser = new JSONParser();
	    try 
	    {
	        json = (JSONArray) parser.parse(new FileReader("input.json"));
	    }
	    catch(Exception e)
	    {
	        System.out.println(e.getMessage());
	    }
		
		nestedListImpl = new NestedListImpl(json);
	}
	
	@Test
	public void testSumOfList()
	{
		assertEquals(190, nestedListImpl.getSum(),0);
	}
	
	@Test
	public void testSearchValue()
	{
		assertEquals(true, nestedListImpl.isValueAvailable(2));
	}
	
	@Test
	public void testSearchValue2()
	{
		assertEquals(false, nestedListImpl.isValueAvailable(20));
	}
	
	@Test
	public void getLargestValue()
	{
		assertEquals(19, nestedListImpl.getMaxValue(),0);
	}
}
