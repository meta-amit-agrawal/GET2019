package Question3;

public class QueueImplementation implements Queue 
{
	int front=0;
	int rear=0;
	int SIZE = UtilityClass.FIXED_SIZE;
	boolean circular_flag=false;
	int[] queue = new int[SIZE];
	
	
	//This method will add the data into the queue
	@Override
	public void Enqueue(int data) throws Exception {
		if(circular_flag) {
			if(rear==SIZE-1)
				rear=0;
		}
		if(!isFull())
		{
			queue[rear]=data;
			rear+=1;
		}
		throw new Exception("Queue is Full");
	}

	//This method will delete the data from the queue and returns the deleted value
	@Override
	public int Dequeue() throws Exception {
		if(circular_flag)
		{
			if(front == SIZE-1)
				front=0;
		}
		if(!isEmpty())
		{
			return queue[front++];
		}
		throw new Exception("Queue is Empty");
		
	}

	//This method checks whether queue is empty or not
	@Override
	public boolean isEmpty() {
		if(rear == front)
			return true;
		return false;
	}

	//This method will check whether queue is full or not
	@Override
	public boolean isFull() {
		if(circular_flag)
		{
			if(rear==front-1)
				return true;
			return false;
		}
		if(rear == SIZE-1 && front == 0)
		{
			return true;
		}
		return false;
	}

	//This will make the queue as circular queue
	@Override
	public void makeItCircular() {
		circular_flag=true;
	}	
}
