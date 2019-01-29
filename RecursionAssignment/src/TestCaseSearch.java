import static org.junit.Assert.*;
import org.junit.Test;
public class TestCaseSearch 
{
	//test case of null array in binary search
	@Test(expected = AssertionError.class)
	public void testcaseBinarySearchNullArrayNegativeTest()
	{
		double input[]=new double[]{};
		double search =4;
		Search.binarySearch(input, 0, input.length-1, search);
	}
	
	//test case of input in binary search
	@Test
	public void testcaseBinarySearchInput()
	{
		double input[]=new double[]{1,2,3,4,5,6};
		double search=4;
		int expected =3;
		assertEquals(expected, Search.binarySearch(input, 0, input.length-1, search));
	}
	
	//test case of input with no element present in binary search
	@Test
	public void testcaseBinarySearchNegativeTest()
	{
		double input[]=new double[]{1,2,3,4,5,6};
		double search=4;
		int expected =-1;
		assertNotEquals(expected, Search.binarySearch(input, 0, input.length-1, search));
	}
	
	//test case of null array in linear search
	@Test(expected = AssertionError.class)
	public void testcaseLinearSearchNullArrayNegativeTest()
	{
		double input[]=new double[]{};
		double search =4;
		Search.linearSearch(input, 0, search);
	}
	
	//test case of input in linear search
	@Test
	public void testcaseLinearSearchInput()
	{
		double input[]=new double[]{1,3,2,5,4,6};
		double search=4;
		int expected =4;
		assertEquals(expected, Search.linearSearch(input, 0, search));
	}
	
	//test case of input with no element present in linear search
	@Test
	public void testcaseLinearSearchNegativeTest()
	{
		double input[]=new double[]{1,3,2,5,4,6};
		double search=4;
		int expected =-1;
		assertNotEquals(expected, Search.linearSearch(input, 0, search));
	}
	
}
