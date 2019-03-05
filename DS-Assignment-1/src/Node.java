
public class Node 
{
	
	private int data;
	private Node next;
	
	
	public Node(int data)
	{
		this.data = data;
	}
	
	public void setNext(Node next)
	{
		this.next = next;
	}
	
	public int getData()
	{
		return data;
	}
	
	public Node getNext()
	{
		return next;
	}
	public boolean hasNext()
	{
		if(next==null)
			return false;
		return true;
	}
	
}
