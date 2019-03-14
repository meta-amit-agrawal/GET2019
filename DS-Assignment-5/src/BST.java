
public interface BST 
{
	
	public boolean add(String key, String value) throws Exception;
	
	public boolean delete(String key) throws Exception;
	
	public String findValue();
	
	public void inOrder();
	
	public Node minValue(Node node);
	
}
