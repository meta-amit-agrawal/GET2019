package Question4;

public class QueueImplementation implements Queue
{
	
	Node front,rear;

	//Add the data into the queue
    @Override
    public void Enqueue(String data) {
        Node node =new Node(data);
        if(front==null) {
            front=node;  
            rear=node;
        }
        else {
            rear.setNext(node);
            rear=node;
        }
    }

    //deleted the data from the queue
    @Override
    public String Dequeue() {
        if(front==rear) {
            String data=front.data;
            front=null;
            rear=null;
            return data;
        }
        String data=front.data;
        front=front.next;
        return data;
    }

    //checks whether queue is empty
    @Override
    public boolean isEmpty() {

        if(rear==null) 
            return true; 
        else 
            return false;        
    }
	
}
