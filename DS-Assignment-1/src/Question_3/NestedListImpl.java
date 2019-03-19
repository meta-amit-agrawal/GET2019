package Question_3;

import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class NestedListImpl implements NestedList 
{
	
	List<Object> nestedList = new LinkedList<Object>();

	public NestedListImpl(JSONArray jsonArray) throws Exception 
	{
		if(jsonArray == null)
		{
			throw new Exception("Json object should not be null");
		}
		else
		{
			nestedList = createNestList(jsonArray);
			System.out.println(nestedList);
		}
	}

	
	private List<Object> createNestList(JSONArray jsonArray) throws Exception 
	{
		
		for(Object object : jsonArray)
		{
			if(object!=null)
			{
				if(object instanceof Long)
				{
					long value = (Long) object;
					System.out.println(value);
					//nestedList.add(value);
				}
				else
				{
					JSONArray newJsonArray = (JSONArray) object;
					createNestList(newJsonArray);
				}
			}
		}
		return null;
	}

	@Override
	public int getSum() 
	{
		return 0;
	}

	@Override
	public int getMaxValue() 
	{
		return 0;
	}

	@Override
	public boolean isValueAvailable(int value)
	{
		return false;
	}
	
	public static void main(String args[]) throws Exception
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
		
		NestedListImpl nestedListImpl = new NestedListImpl(json);
	}
	
}
