
public class LinkedList 
{
	
	Node head,current;
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
	
	public void addData(int data)
	{
		Node node = new Node(data);
		node.setNext(null);
		if(head == null)
		{
			head = node;
			current = node;
			size+=1;
		}
		current.setNext(node);;
		current=node;
	}
	
	 public void rotate(int left,int right,int noOfTimes) throws Exception
	 {
	        
		 int subListSize = right - left + 1;
		 
		 if(left < 0 || right >size || left > right)
	     {
			 throw new Exception("Provide Valid Left and Right Coordinates");
	     }
		 
		 if (noOfTimes > subListSize) 
		 { 
			 noOfTimes = noOfTimes % subListSize; 
		 }
	     
		 Node node=head;
	     Node end;
	     Node joint_start=node;
	     Node joint_end;
	     int start_position=1;
	     int end_position;
	     
	     while(start_position<left-1) 
	     {
	    	 joint_start=joint_start.getNext();
	    	 start_position++;
	     }
	     end_position=left;
	     joint_end=joint_start.getNext();
	     
	     while(end_position<right) 
	     {
	    	 joint_end=joint_end.getNext();
	    	 end_position++;
	     }
	     
	     Node start=joint_start.getNext();
	     
	     if(joint_end==null) 
	     {
	    	 end=joint_end;
	     }
	     else 
	     {
	    	 end=joint_end.getNext();
	     }
	     
	     while(noOfTimes>0) 
	     {
	    	 Node temp=start;
	    	 start=start.getNext();
	    	 joint_end.setNext(temp);
	    	 joint_end=temp;
	    	 noOfTimes--;
	     }
	     joint_start.setNext(start);
	     joint_end.setNext(end);
	 }
	
	public Node getHead()
	{
		return head;
	}
	
	public boolean detectLoop()
	{
		Node start, end;
		start  = head;
		end =head.getNext();
		while(end!=null)
		{			
			if(end.getNext()!=null)
			{
				end = end.getNext().getNext();
				start = start.getNext();
				if(start == end)
					return true;
			}
		}
		return false;
	}
}
