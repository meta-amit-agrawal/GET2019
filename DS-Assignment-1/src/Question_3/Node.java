package Question_3;

public class Node 
{
	
	Object object;
	
	Node next;
	
	public Node(Object object)
	{
		this.object = object;
		this.next=null;
	}
	
	public Object getData()
	{
		return this.object;
	}
	
	public Node getNext()
	{
		return this.next;
	}
	
	public void setNext(Node next)
	{
		this.next = next;
	}
	
}
