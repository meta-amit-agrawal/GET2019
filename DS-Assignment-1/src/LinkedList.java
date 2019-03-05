
public class LinkedList 
{
	
	Node head;
	int size;
	
	public LinkedList()
	{
		head = null;
	}
	
	public boolean isEmpty()
	{
		if(head==null)
			return true;
		return false;
	}
	
	public void addNode(Node node)
	{
		if(head == null)
		{
			head = node;
			node.setNext(null);
			size+=1;
		}
		else
		{
			Node current = head;	
			while(current.getNext()!=null)
			{
				current = current.getNext();
			}
			current.setNext(node);
			node.setNext(null);
			size+=1;
		}
	}
	
	public void rotate(int left, int right, int rotateTimes) throws Exception
	{
		int sublistSize = right-left+1;
		if(rotateTimes > sublistSize)
		{
			rotateTimes = rotateTimes % sublistSize;
			System.out.println(rotateTimes);
		}
		
		if(left<0 || right>size || left>size || right<0)
		{
			throw new Exception("Not a correct positions");
		}
		
		Node startNode,endNode,pre,end;
		startNode=endNode=pre=end=null;
		Node current = head;
		
		int count=0;
		
		
		while(current.getNext()!=null)
		{
			count++;
			System.out.println("Hello");
			if(count==left-1)
			{
				pre = current;
				startNode = current.getNext();
			}
			if(count==right-1)
			{
				end = current; 
				endNode = current.getNext();
			}
			current = current.getNext();
		}
		
		
		System.out.println(startNode.getData());
		System.out.println(endNode.getData());
		System.out.println(rotateTimes);
		
		while(rotateTimes > 0)
		{
			
		}
		
	}
	
	public void printList()
	{
		Node current = head;
		System.out.println("Currently the list is....");
		while(current!=null)
		{
			System.out.println(current.getData());
			current = current.getNext();
		}
	}
	
	public static void main(String args[])
	{
		LinkedList linkedList = new LinkedList();
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		
		linkedList.addNode(node1);
		linkedList.addNode(node2);
		linkedList.addNode(node3);
		linkedList.addNode(node4);
		linkedList.addNode(node5);
		linkedList.printList();
		
		try {
			linkedList.rotate(2, 4, 5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
}
