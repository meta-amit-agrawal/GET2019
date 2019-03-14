import java.util.List;

public interface BST 
{
	//checks of tree is empty or not
	public boolean isEmpty();
	
	//add the node with key and value in the tree
	public boolean add(String key, String value) throws Exception;
	
	//delete the node which contains the given key
	public boolean delete(String key) throws Exception;
	
	//find the value of the node which contains the given key
	public String findValue(String key) throws Exception;
	
	//returns the list which contains the key and values of all nodes present in tree
	public List<Data> getAll() throws Exception;
	
	//returns the list which contains the key in between the two keys 
	public List<Data> getBetweenKeys(String key1, String key2) throws Exception;
}
