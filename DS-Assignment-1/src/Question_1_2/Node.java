package Question_1_2;

public class Node 
{
	
	int data;
	Node next;
	
	//sets the data into the node
	public Node(int data)
	{
		this.data = data;
	}
	
	//sets the next node location into the node
	public void setNext(Node next)
	{
		this.next = next;
	}
	
	//returns the data of the node
	public int getData()
	{
		return data;
	}
	
	//returns the next node location
	public Node getNext()
	{
		return next;
	}
}
