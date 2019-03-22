package Question_1_2;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;


public class TestLinkedList 
{
	@Test
	public void testAddData()
	{
		LinkedList linkedList = new LinkedList();
		linkedList.addData(2);
	}
	
//	@Test
//	public void testRotateWithWrongCoordinates()
//	{
//		LinkedList linkedList =new LinkedList();
//		linkedList.addData(1);
//		linkedList.addData(2);
//		linkedList.addData(3);
//		linkedList.addData(4);
//		linkedList.addData(5);
//		try 
//		{
//			linkedList.rotate(-1, 3, 2);
//		}
//		catch (Exception e) 
//		{
//			System.out.println(e.getMessage());
//		}
//		
//	}
//	
	@Test
	public void testRotateWithValidCoordinates()
	{
		List<Integer> expected = new ArrayList<Integer>();
		expected.add(1);
		expected.add(4);
		expected.add(2);
		expected.add(3);
		expected.add(5);
		
		LinkedList linkedList =new LinkedList();
		linkedList.addData(1);
		linkedList.addData(2);
		linkedList.addData(3);
		linkedList.addData(4);
		linkedList.addData(5);
		linkedList.addData(6);
		linkedList.addData(7);
		linkedList.addData(8);
		try 
		{
			linkedList.rotate(4, 6, 1);
			linkedList.getList();
//			List<Integer> list = linkedList.getList();
//			System.out.println(list);
		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		
	}
}
