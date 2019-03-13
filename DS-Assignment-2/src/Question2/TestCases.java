package Question2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestCases 
{
	
	
	@Test
	public void testCase() throws Exception
	{
		InfixToPostfix infixToPostfix = new InfixToPostfix();
		assertEquals("ab==", infixToPostfix.convertToPostfix("a == b"));
	}

	@Test
	public void testCase2() throws Exception
	{
		InfixToPostfix infixToPostfix = new InfixToPostfix();
		assertEquals("abcd^e-fgh*+^*+i-", infixToPostfix.convertToPostfix("a + b * ( c ^ d - e ) ^ ( f + g * h ) - i"));
	}

	@Test(expected = Exception.class)
	public void testCase3() throws Exception
	{
		InfixToPostfix infixToPostfix = new InfixToPostfix();
		infixToPostfix.convertToPostfix("a + b * ( c ^ d - e ) ^ ( f + g * h ) ( _ i");
	}

	@Test
	public void testCase4() throws Exception
	{
		InfixToPostfix infixToPostfix = new InfixToPostfix();
		assertEquals("abc*+", infixToPostfix.convertToPostfix("a + b * c"));
	}
	
	
}
