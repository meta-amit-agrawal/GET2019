package Question3;


public interface Queue {

	public void Enqueue(int data);
	
	public int  Dequeue();
	
	public boolean isEmpty();
	
	public boolean isFull();
	
	public void Traverse();
	
	public void makeItCircular();
	
}
