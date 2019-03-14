package Question2;

public class StackImplementation implements Stack 
{	
     Node head,top;
     
     /**
	  * Push method will add the data at the top of the stack
	  * @param data
	  */ 
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

    /**
	 * Pop method deletes the Top node of the stack
	 * @return the deleted data from the stack
	 */
    @Override
    public String Pop() 
    {
    	String data=top.data;
        top=top.next;
        return data;
    }

    /**
	 * This method performs the peek operation of the stack
	 * @return the top data of the stack
	 */
    @Override
    public String Top() 
    {
        return top.data;
    }

    /**
     * This method will check whether stack is empty or not
     * @return true if stack is empty else false
     */
	@Override
	public boolean isEmpty() 
	{
		if(head == null)
			return true;
		return false;
	}
}
