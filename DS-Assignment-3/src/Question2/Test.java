package Question2;

import static org.junit.Assert.*;
public class Test 
{
	int size = 5;
	@org.junit.Test
	public void test1()
	{
		PriorityQueue PriorityQueue = new PriorityQueue(size);
		try 
		{
			PriorityQueue.enqueue(new Node(1, 1));
			PriorityQueue.enqueue(new Node(2, 2));
			PriorityQueue.enqueue(new Node(3, 3));
			PriorityQueue.enqueue(new Node(4, 4));
			PriorityQueue.enqueue(new Node(5, 5));
			PriorityQueue.enqueue(new Node(6, 6));
		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}
	
	@org.junit.Test
	public void test2()
	{
		PriorityQueue PriorityQueue = new PriorityQueue(size);
		try 
		{
			PriorityQueue.enqueue(new Node(1, 1));
			PriorityQueue.enqueue(new Node(2, 2));
			PriorityQueue.enqueue(new Node(3, 3));
			PriorityQueue.enqueue(new Node(4, 4));
			PriorityQueue.enqueue(new Node(5, 5));
			assertEquals(1, PriorityQueue.dequeue().getData());
		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}
	
	@org.junit.Test
	public void test3()
	{
		PriorityQueue PriorityQueue = new PriorityQueue(size);
		try 
		{
			assertTrue(PriorityQueue.isEmpty());
		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}
	
	@org.junit.Test
	public void test4()
	{
		PriorityQueue PriorityQueue = new PriorityQueue(size);
		try 
		{
			assertFalse(PriorityQueue.isFull());
		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}
	
	@org.junit.Test
	public void test5()
	{
		PriorityQueue PriorityQueue = new PriorityQueue(size);
		try 
		{
			assertEquals(1, PriorityQueue.dequeue().getData());
		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}
	
}
