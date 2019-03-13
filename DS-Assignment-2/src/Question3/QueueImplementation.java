package Question3;

public class QueueImplementation implements Queue 
{
	int front=0;
	int rear=0;
	int SIZE = UtilityClass.FIXED_SIZE;
	boolean circular_flag=false;
	int[] queue = new int[SIZE];
	@Override
	public void Enqueue(int data) {
		if(circular_flag) {
			if(rear==SIZE-1)
				rear=0;
		}
		queue[rear++]=data;
	}

	@Override
	public int Dequeue() {
		return queue[front++];
	}

	@Override
	public boolean isEmpty() {
		if(rear == front)
			return true;
		return false;
	}

	@Override
	public boolean isFull() {
		if(rear==SIZE)
			return true;
		return false;
	}

	@Override
	public void makeItCircular() {
		circular_flag=true;
	}	
}
