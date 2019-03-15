import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DictionaryImpl implements Dictionary 
{

	//BST to store the key and value
	BST bst = new BSTImplementation();
	
	
	//constructor to which get the JSON object and add the data into the tree 
	@SuppressWarnings("unchecked")
	public DictionaryImpl(JSONObject jsonObject) throws Exception {
		Map<String, String> data = new HashMap<String, String>();
		
		try 
		{
			data = new ObjectMapper().readValue(jsonObject.toString(),HashMap.class);
		}
		catch (IOException e) 
		{
			throw e;
		}
		
		for(String key : data.keySet())
		{
			add(key, data.get(key));
		}
		
	}
	
	/**
	 * add method add the data into the tree with the help of BST object
	 * @param key
	 * @param value
	 * @return true if node is added 
	 * @throws Exception if not already exist or if key or value is null
	 */
	@Override
	public boolean add(String key, String value) throws Exception 
	{
		if(checkNull(key) || checkNull(value))
			throw new Exception("Key or value cannot be null");
		return bst.add(key, value);
		
	}

	/**
	 * delete method to delete the node from the tree
	 * @param key 
	 * @return true of node is deleted from the tree
	 * @throws Exception if node is not available or if key is null
	 */
	@Override
	public boolean delete(String key) throws Exception 
	{
		if(checkNull(key))
			throw new Exception("Key cannot be null");
		return bst.delete(key);
	}

	/**
	 * getValue method finds the value of the given key
	 * @param key
	 * @return the value against the given key
	 * @throws Exception if node is not available of given key or if key is null
	 */
	@Override
	public String getValue(String key) throws Exception
	{
		if(checkNull(key))
			throw new Exception("key cannot be null");
		return bst.findValue(key);
	}

	/**
	 * getSortedKeyValue returns the list of key value from the tree
	 * @return the list which contains key and their values
	 * @throws Exception if tree is null
	 */
	@Override
	public List<Data> getSortedKeyValue() throws Exception 
	{
		return bst.getAll();
	}
	
	/**
	 * getSortedKeyValueBetweenKeys method find the nodes in between the given keys
	 * @param key1
	 * @param key2
	 * @return list which contains the key and values
	 * @throws Exception if tree is empty or any of the given key is empty
	 */
	@Override
	public List<Data> getSortedKeyValueBetweenKeys(String key1, String key2) throws Exception
	{
		if(checkNull(key1) || checkNull(key2))
			throw new Exception("Input cannot be null");
		return bst.getBetweenKeys(key1, key2);
	}
	
	/**
	 * private helper method which checks the given input is null or not
	 * @param data
	 * @return true of key is null
	 * @throws Exception if tree is empty
	 */
	private boolean checkNull(String data) throws Exception
	{
		if(data==null || data.length()==0)
		{
			return true;
		}
		return false;
	}
	
}
