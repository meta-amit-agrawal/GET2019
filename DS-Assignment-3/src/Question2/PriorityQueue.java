package Question2;

public class PriorityQueue 
{
	Node[] node;
	int start = 0;
	int end = 0;
	
	public PriorityQueue(int size) 
	{
		node = new Node[size];
	}
	
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
	
	public boolean isFull()
	{
		if(end > node.length-1)
		{
			return true;
		}
		return false;
	}
	
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
	
	public boolean isEmpty()
	{
		if(start == end)
			return true;
		return false;
	}
	
	public static void main(String args[])
	{
		PriorityQueue priorityQueue = new PriorityQueue(3);
		try 
		{
			priorityQueue.enqueue(new Node(10, 4));
			priorityQueue.enqueue(new Node(11, 1));
			priorityQueue.enqueue(new Node(12, 3));
//			priorityQueue.enqueue(new Node(13, 4));
//			priorityQueue.enqueue(new Node(14, 5));
			System.out.println(priorityQueue.dequeue().getData());
			System.out.println(priorityQueue.dequeue().getData());
			System.out.println(priorityQueue.dequeue().getData());
			System.out.println(priorityQueue.dequeue().getData());
//			System.out.println(priorityQueue.dequeue().getData());
//			System.out.println(priorityQueue.dequeue().getData());
		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		
	}
}


