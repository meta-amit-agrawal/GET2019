package Question_3;

public class LinkedList 
{
	
	Node head;
	
	public LinkedList()
	{
		head=null;
	}
	
	public void add(Object data)
	{
		Node node = new Node(data);
		if(isEmpty())
		{
			head = node;
		}
		else
		{
			Node current=head;
			Node prev=null;
			while(current!=null)
			{
				prev = current;
				current = current.getNext();
			}
			prev.setNext(node);
			current = node;
			
		}
	}
	
	public void print()
	{
		
	}
	
	public Node getHead()
	{
		return this.head;
	}
	
	public boolean isEmpty()
	{
		if(head==null)
			return true;
		return false;
	}

	@Override
	public String toString() {
		return "LinkedList [head=" + head + "]";
	}
	
	
	
}
