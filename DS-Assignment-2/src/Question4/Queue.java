package Question4;

//interface of queue with the following operations
public interface Queue 
{
	//to add the data into the queue
	public void Enqueue(String data);
	//to delete the data from the queue
	public String  Dequeue();
	//checks whether queue id empty or not
	public boolean isEmpty();
	
	
}
