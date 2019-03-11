package Question1;

public class StackImplementation implements Stack
{
	
	  StackImplementation stack;
	  Node head,top;
	  @Override
	  public void Push(int data) 
	  {
	     Node node =new Node(data);
	     if(head==null) 
	     {
	        head=node;  
	        top=node;
	     }
	     else 
	     {
	        node.setNext(top);
	        top=node;
	     }
	  }

	  @Override
	  public int Pop() 
	  {
	     int data=top.data;
	     top=top.next;
	     return data;
	  }

	  @Override
	  public int Top() 
	  {
	     return top.data;
	  }
	
}
