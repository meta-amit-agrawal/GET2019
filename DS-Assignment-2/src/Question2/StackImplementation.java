package Question2;

public class StackImplementation implements Stack 
{	
     Node head,top;
    @Override
    public void Push(String data) 
    {
        Node node =new Node(data);
        if(isEmpty()) 
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
    public String Pop() 
    {
    	String data=top.data;
        top=top.next;
        return data;
    }

    @Override
    public String Top() 
    {
        return top.data;
    }

	@Override
	public boolean isEmpty() 
	{
		if(head == null)
			return true;
		return false;
	}
}
