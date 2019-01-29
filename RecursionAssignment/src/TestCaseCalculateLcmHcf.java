import static org.junit.Assert.*;
import org.junit.Test;
public class TestCaseCalculateLcmHcf 
{
	//test case of HCF with input 1
	@Test
	public void testcaseHCFInput1()
	{
		int first=20,second=30,expected=10;
		assertEquals(expected, CalculateLcmHcf.getHCF(first, second));
	}
	
	//test case of HCF with input 2
	@Test
	public void testcaseHCFNegativeTest()
	{
		int first=20,second=30,expected=5;
		assertNotEquals(expected, CalculateLcmHcf.getHCF(first, second));
	}
	
	//test case of LCM with input 2
	@Test
	public void testcaseLCMInput()
	{
		int first=20,second=30,expected=60;
		assertEquals(expected, CalculateLcmHcf.getLCM(first, second));
	}
	
	//test case of LCM with input 2
	@Test
	public void testcaseLCMNegativeTest()
	{
		int first=20,second=30,expected=10;
		assertNotEquals(expected, CalculateLcmHcf.getLCM(first, second));
	}
}
