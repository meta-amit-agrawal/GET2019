package Question2;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestCases {
	
	@Test
	public void testCase()
	{
		UniqueCharacter uniqueCharacter = new UniqueCharacter();
		assertEquals(4,uniqueCharacter.numberOfUniqueCharacter("Amit"));
	}
	@Test
	public void testCase2()
	{
		UniqueCharacter uniqueCharacter = new UniqueCharacter();
		assertEquals(3,uniqueCharacter.numberOfUniqueCharacter("HELLO"));
	}
	
	@Test
	public void testCase3()
	{
		UniqueCharacter uniqueCharacter = new UniqueCharacter();
		assertEquals(1,uniqueCharacter.numberOfUniqueCharacter("AaaaAmmM"));
	}
	
	@Test
	public void negativeTestCase()
	{
		UniqueCharacter uniqueCharacter = new UniqueCharacter();
		assertEquals(0,uniqueCharacter.numberOfUniqueCharacter(""));
	}

}
