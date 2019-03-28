
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class TestCases 
{
	
	@Test
	public void isConnectedTest() throws Exception
	{
		GraphImp graph = new GraphImp(5);
		graph.addEdge(0, 1, 5);
		graph.addEdge(0, 2, 7);
		graph.addEdge(2, 3, 2);
		graph.addEdge(0, 3, 1);
		graph.addEdge(1, 3, 6);
		graph.addEdge(1, 4, 9);
		graph.addEdge(3, 4, 8);
		assertEquals(true, graph.isConnected());
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void reachableTest() throws Exception
	{
		GraphImp graph = new GraphImp(5);
		graph.addEdge(0, 1, 5);
		graph.addEdge(0, 2, 7);
		graph.addEdge(2, 3, 2);
		graph.addEdge(0, 3, 1);
		graph.addEdge(1, 3, 6);
		graph.addEdge(1, 4, 9);
		graph.addEdge(3, 4, 8);
		assertEquals(new ArrayList(Arrays.asList(0,1,2,3,4)),graph.getReachableVerttices(1));
		
	}
	
	@Test
	public void mstTest() throws Exception
	{
		GraphImp graph = new GraphImp(5);
		graph.addEdge(0, 1, 5);
		graph.addEdge(0, 2, 7);
		graph.addEdge(2, 3, 2);
		graph.addEdge(0, 3, 1);
		graph.addEdge(1, 3, 6);
		graph.addEdge(1, 4, 9);
		graph.addEdge(3, 4, 8);
		assertArrayEquals(new int[]{-1, 0,3,0,3},graph.getMST());
		
	}
	
	@Test
	public void shortestPathTest() throws Exception
	{
		GraphImp graph = new GraphImp(5);
		graph.addEdge(0, 1, 5);
		graph.addEdge(0, 2, 7);
		graph.addEdge(2, 3, 2);
		graph.addEdge(0, 3, 1);
		graph.addEdge(1, 3, 6);
		graph.addEdge(1, 4, 9);
		graph.addEdge(3, 4, 8);
		assertEquals(9, graph.getShortestPath(1, 4));
		
	}
	
}
