import java.util.List;

public interface Dictionary 
{
	//to add the key and value into dictionary
	public boolean add(String key, String value) throws Exception;
	
	//to delete the key from the dictionary
	public boolean delete(String key) throws Exception;
	
	//to get the value of the key
	public String getValue(String key) throws Exception;
	
	//to get all keys with their values
	public List<Data> getSortedKeyValue() throws Exception;
	
	//to get keys with their values which comes in between the two given keys
	public List<Data> getSortedKeyValueBetweenKeys(String key1, String key2) throws Exception;
	
}
