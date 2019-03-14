package Question1;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestCases 
{
	
	@Test
	public void testCase1() throws Exception
	{
		EvaluateExpression evaluateExpression = new EvaluateExpression();
		assertEquals(20, evaluateExpression.evaluate("5 4 *"));
	}
	
	@Test
	public void testCase2() throws Exception
	{
		EvaluateExpression evaluateExpression = new EvaluateExpression();
		assertEquals(-4, evaluateExpression.evaluate("2 3 1 * + 9 -"));
	}
	
	@Test(expected = Exception.class)
	public void testCase3() throws Exception
	{
		EvaluateExpression evaluateExpression = new EvaluateExpression();
		assertEquals(-4, evaluateExpression.evaluate("2 3 1 * + 9 @"));
	}
	
	
}
