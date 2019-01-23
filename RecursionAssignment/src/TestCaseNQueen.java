import static org.junit.Assert.*;
import org.junit.Test;
public class TestCaseNQueen 
{
	
	//test case with board of dimension 4
	@Test
	public void testcaseNQueen()
	{
		int dimension = 4;
		int board[][] = new int[dimension][dimension];
		boolean expected =true;
		int startRow = 0;
		assertEquals(expected, NQueen.solveNQueen(board, startRow, dimension));
	}
	
	//test case of board with dimension 8
	@Test
	public void testcaseNQueeninput()
	{
		int dimension = 8;
		int board[][] = new int[dimension][dimension];
		boolean expected =true;
		int startRow = 2;
		assertEquals(expected, NQueen.solveNQueen(board, startRow, dimension));
	}
	
	//test case with wrong expected output
	@Test
	public void testcaseNQueenNegativeTest()
	{
		int dimension = 4;
		int board[][] = new int[dimension][dimension];
		boolean expected =false;
		int startRow = 3;
		assertNotEquals(expected, NQueen.solveNQueen(board, startRow, dimension));
	}
}
