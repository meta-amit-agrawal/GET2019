import java.util.List;

public interface Dictionary 
{
	
	public boolean add(String key, String value);
	
	public boolean delete(String key);
	
	public String getValue(String key);
	
	public List<Data> getSortedKeyValue();
	
	public List<Data> getSortedKeyValueBetweenKeys(String key1, String key2);
	
}
