package Question2;

public class PriorityQueue 
{
	//reference of array of node
	Node[] node;
	int start = 0;
	int end = 0;
	
	//constructor to define the size of the array
	public PriorityQueue(int size) 
	{
		node = new Node[size];
	}
	
	//enqueue method to add the data into the node array
	public void enqueue(Node node) throws Exception
	{
		if(isFull())
		{
			throw new Exception("Queue is full");
		}
		else
		{
			this.node[end++] = node;
			
		}
	}
	
	//to check whether array is full or not
	public boolean isFull()
	{
		if(end > node.length-1)
		{
			return true;
		}
		return false;
	}
	
	//private helper method to sort the array according to the priority
	private void getSorted()
	{
		for(int i=start;i<=end;i++)
		{
			for(int j=start;j<end-i-1;j++)
			{
				if(node[j].getPriority() > node[j+1].getPriority())
				{
					Node temp = node[j];
					node[j] = node[j+1];
					node[j+1] = temp;
				}
			}
		}
	}
	
	//dequeue method to delete the data or node from the array
	public Node dequeue() throws Exception
	{
		if(isEmpty())
		{
			throw new Exception("Queue is Empty");
		}
		else
		{
			getSorted();
			Node deletedNode = node[start++];
			return deletedNode;
		}
	}
	
	//to check whether array is empty or not
	public boolean isEmpty()
	{
		if(start == end)
			return true;
		return false;
	}

}


