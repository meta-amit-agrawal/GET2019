package Question_1_2;
import java.util.ArrayList;
import java.util.List;


public class LinkedList 
{
	
	Node head,current;
	int size;
	
	public LinkedList()
	{
		head = null;
	}
	
	
	/*
	* method checks the list is empty or not
	* @return true if list is empty or false if not
	*/
	public boolean isEmpty()
	{
		if(head==null)
			return true;
		return false;
	}
	
	/*
	 * addData method add the data into the list
	 * @param requires the data which is to be added
	 */
	public void addData(int data)
	{
		Node node = new Node(data);
		node.setNext(null);
		if(isEmpty())
		{
			head = node;
			current = node;
			size+=1;
		}
		else
		{
			current.setNext(node);
			current=node;
			size+=1;
		}
		
	}
	
	public void rotate(int left, int right, int noOfTimes) throws Exception
	{
		System.out.println(size);
		if(left == 1 && right == size)
		{
			System.out.println("Ye Chala");
			if (noOfTimes > size) 
			{ 
				noOfTimes = noOfTimes % size; 
			}
			int count=1;
			Node current = head;
			while(count < noOfTimes && current.getNext()!=null)
			{
				current = current.getNext();
				count++;
			}
			
			Node kthNode = current;
			while(current.getNext()!=null)
			{
				current = current.getNext();
			}
			current.setNext(head);
			head = kthNode.getNext();
			kthNode.setNext(null);
		}
		else
		{
			rotatSubList(left, right, noOfTimes);
		}
	}
	
	
	/*
	 * rotate method rotates the sublist for which positions are given
	 * @param left is the starting position of the sublist
	 * @param right is the ending position of the sublist
	 * @param noOfTimes is the times to rotate the sublist
	 * @return
	 */
	public void rotatSubList(int left,int right,int noOfTimes) throws Exception
	{
		
		int subListSize = right - left + 1;
		
		//checking the coordinates of the sublist is valid or not 
		if(left < 0 || right >size || left > right)
	    {
			throw new Exception("Provide Valid Left and Right Coordinates");
	    }
		 
		//if number of times to be rotated is greater than size of sublist then modulus is taken 
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
	    
	  for(int i=0;i<noOfTimes;i++)
	  {
	    	Node temp=start;
	    	start=start.getNext();
	    	joint_end.setNext(temp);
	    	joint_end=temp;
	  }
	  joint_start.setNext(start);
	  joint_end.setNext(end);
	}
	
	public List<Integer> getList()
	{
		Node node = head;
		List<Integer> list = new ArrayList<Integer>();
		while(node!=null)
		{
			list.add(node.getData());
			node = node.getNext();
		}
		System.out.println(list);
		return list;
	}
	
	
	/*
	 * detectLoop method checks whether loop is available in the linked list or not
	 * @param
	 * @return true if loop is available in the list or false if not  
	 */
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
