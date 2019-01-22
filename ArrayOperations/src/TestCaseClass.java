import static org.junit.Assert.*;
import org.junit.Test;
public class TestCaseClass 
{
	
	ArrayOperations arrayOperations = new ArrayOperations();
	
	//test case of split array method
	
	//test case of split method with input 1
	@Test
	public void testCaseSplitArrayInput1()
	{
		int num[] = new int[]{1,1,1,2,1};
		assertEquals(3, arrayOperations.splitArray(num));
	}
	
	//test case of split method with input 2
	@Test
	public void testCaseSplitArrayInput2()
	{
		int num[] = new int[]{2, 1, 1, 2, 1};
		assertEquals(-1, arrayOperations.splitArray(num));
	}
	
	//test case with split method with null array
	@Test(expected = AssertionError.class)
	public void testCaseSplitArrayNullArray()
	{
		int num[] = new int[]{};
		  arrayOperations.splitArray(num);
	}
	
	//test case with split method with input (Negative Test Case)
	@Test(expected = AssertionError.class)
	public void testCaseSplitArrayNullArrayNegative()
	{
		int num[] = new int[]{2, 1, 1, 2, 1};	//but sends an array with input instead of null
		  arrayOperations.splitArray(num);
	}
	
	//test case of split method with null array (Negative Test Case)
	@Test
	public void testCaseSplitArrayInputNegative()
	{
		int num[] = new int[]{1,1,1,2,1};
		assertEquals(-1, arrayOperations.splitArray(num));	//expected -1 but receives 3
	}
	
	
	
	
	//test cases of countClumb Method
	
	//test case with countClumb method with Input 1
	@Test
	public void testCaseClumbInput1()
	{
		int num[] = new int[]{1,1,1,1,1};
		assertEquals(1, arrayOperations.countClumbs(num) );
	}
	
	//test case with countClumb method with null array
	@Test(expected = AssertionError.class)
	public void testCaseClumbNullArray()
	{
		int num[] = new int[]{};
		arrayOperations.countClumbs(num);
	}
	
	//test case with countClumb method with Input 2
	@Test
	public void testCaseClumbInput2()
	{
		int num[] = new int[]{1,2,2,3,4,4};
		assertEquals(2, arrayOperations.countClumbs(num));
	}
	
	//test case with countClumb method with null array (Negative Test Case)
	@Test
	public void testCaseClumbNullArrayNegative()
	{
		int num[] = new int[]{};
		arrayOperations.countClumbs(num);	//expected exception 
	}
	
	//test case with countClumb method with Input (Negative Test Case)
	@Test
	public void testCaseClumbInputNegative()
	{
		int num[] = new int[]{1,2,2,3,4,4};
		assertEquals(1, arrayOperations.countClumbs(num));	//expected 1 but receives 2
	}
	
	
	
	//test cases of FitXY method
	
	//test case of FitXY with input 1
	@Test
	public void testcaseFitXYInput1()
	{
		int expected[]=new int[]{9,4,5,4,5,9};
		int num[]=new int[]{5,4,9,4,9,5};
		assertArrayEquals(expected, arrayOperations.fitXY(num, 4, 5));
	}
	
	//test case of FitXY with input 2
	@Test
	public void testcaseFitXYInput2()
	{
		int expected[]=new int[]{1, 4, 5, 1, 1, 4, 5};
		int num[]=new int[]{1, 4, 1, 5, 5, 4, 1};
		assertArrayEquals(expected, arrayOperations.fitXY(num, 4, 5));
	}
	
	//test case of FitXY with null array
	@Test(expected = AssertionError.class)
	public void testcaseFitXYNullArray()
	{
		int num[]=new int[]{};
		arrayOperations.fitXY(num, 4, 5);
	}
	
	//test case of FitXY with last element X
	@Test(expected = AssertionError.class)
	public void testcaseFitXYLastElementX()
	{
		int num[]=new int[]{1,4,5,5,1,4};
		arrayOperations.fitXY(num, 4, 5);
	}
	
	//test case of FitXY with Consecutive X
	@Test(expected = AssertionError.class)
	public void testcaseFitXYConsecutiveX()
	{
		int num[]=new int[]{1,4,4,5,1,5};
		arrayOperations.fitXY(num, 4, 5);
	}
	
	//test case of FitXY with unequal X and Y
	@Test(expected = AssertionError.class)
	public void testcaseFitXYUnequalXY()
	{
		int num[]=new int[]{5, 4, 4, 4, 9, 5};
		arrayOperations.fitXY(num, 4, 5);
	}
	
	
	
	
	//test cases of maximumMirrorCount method
	
	//test case of maximumMirrorCount with input 1
	@Test
	public void testcaseMirrorCountInput1()
	{
		int num[]=new int[]{1, 2, 3, 8, 9, 3, 2, 1};
		assertEquals(3, arrayOperations.maximumMirrorCount(num));
	}
	
	//test case of maximumMirrorCount with input 2
	@Test
	public void testcaseMirrorCountInput2()
	{
		int num[]=new int[]{1, 4, 5, 3, 5, 4, 1};
		assertEquals(7, arrayOperations.maximumMirrorCount(num));
	}
	
	//test case of maximumMirrorCount with null array
	@Test(expected = AssertionError.class)
	public void testcaseMirrorCountNullArray()
	{
		int num[]=new int[]{};
		arrayOperations.maximumMirrorCount(num);
	}
	
	//test case of maximumMirrorCount with null array (Negative Test Case)
	@Test(expected = AssertionError.class)
	public void testcaseMirrorCountNullArrayNegative()
	{
		int num[]=new int[]{1, 4, 5, 3, 5, 4, 1};	//passed array with values instead of null array
		arrayOperations.maximumMirrorCount(num);	//expected exception
	}
	
	//test case of maximumMirrorCount with Input (Negative Test Case)
	@Test(expected = AssertionError.class)
	public void testcaseMirrorCountInputNegative()
	{
		int num[]=new int[]{1, 4, 5, 3, 5, 4, 1};
		assertEquals(1,arrayOperations.maximumMirrorCount(num));	//expected 1 but receives 3
	}
	
}
