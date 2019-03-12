package Question2;

//Stack interface defined with the following Operations
public interface Stack 
{
	//To add the data into the stack
	 public void Push(String data);
	 
	//to remove the top node of the stack
	 public String Pop();
	 
	 //It will return the top data of the stack
	 public String Top();
	 
	 //it will check whether stack is empty or not 
	 public boolean isEmpty();
	
}
