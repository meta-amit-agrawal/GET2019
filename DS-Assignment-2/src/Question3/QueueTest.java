package Question3;

import static org.junit.Assert.*;
import org.junit.Test;

public class QueueTest 
{
	
	@Test
	public void testCase() throws Exception
	{
		Queue queue = new QueueImplementation();
		queue.Enqueue(1);
		queue.Enqueue(2);
		assertFalse(queue.isEmpty());
		assertFalse(queue.isFull());
	}
	
	@Test
	public void testCase2() throws Exception
	{
		Queue queue = new QueueImplementation();
		queue.Enqueue(1);
		queue.Enqueue(2);
		queue.Dequeue();
		queue.Dequeue();
		assertTrue(queue.isEmpty());
		assertFalse(queue.isFull());
	}
	
	@Test(expected = Exception.class)
	public void testCase4() throws Exception
	{
		Queue queue = new QueueImplementation();
		for(int i=0;i<100;i++)
		{
			queue.Enqueue(i);
		}
		queue.Enqueue(100);
	}
	
	
	@Test
	public void testCase3() throws Exception
	{
		Queue queue = new QueueImplementation();
		queue.makeItCircular();
		for(int i=0;i<100;i++)
		{
			queue.Enqueue(i);
		}
		queue.Dequeue();
		assertFalse(queue.isFull());
	}
	
}
