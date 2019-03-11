package Question3;

public class QueueImplementation implements Queue 
{

	private static final int SIZE = 100;
	public static Queue queueimpl;
	static int front=0;
	static int rear=0;
	static boolean circular_flag=false;
	static int[] queue = new int[SIZE];
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
	public void Traverse() {
		for(int index=front;index<rear;index++) {
			System.out.println(queue[index]+" ");
		}
	}

	@Override
	public boolean isEmpty() {
		if(rear<100)
			return true;
		return false;
	}

	@Override
	public boolean isFull() {
		if(rear==100)
			return true;
		return false;
	}

	@Override
	public void makeItCircular() {
		circular_flag=true;
	}

	public static Queue getInstance() {
		if(queueimpl==null) {
			queueimpl=new QueueImplementation();
		}
		return queueimpl;
	}
	
}
