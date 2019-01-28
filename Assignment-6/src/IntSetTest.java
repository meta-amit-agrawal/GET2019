import static org.junit.Assert.*;
import org.junit.Test;
public class IntSetTest 
{
	@Test
	public void sizeTestcaseWithInput1()
	{
		IntSet i1 = new IntSet(new int[]{1,2,3,4,5,6,7});
		int expected = 7;
		assertEquals(expected, i1.size());
	}
	
	@Test
	public void sizeTestcaseWithInput2()
	{
		IntSet i1 = new IntSet(new int[]{1,2});
		int expected = 2;
		assertEquals(expected, i1.size());
	}
	
	@Test
	public void sizeTestcaseWithNullArray()
	{
		IntSet i1 = new IntSet(new int[]{});
		int expected = 0;
		assertEquals(expected, i1.size());
	}
	
	@Test
	public void isMemberTestcaseWithInput1()
	{
		IntSet i1 = new IntSet(new int[]{1,2,3,4,5,6,7});
		int member=3;
		boolean expected = true;
		assertEquals(expected, i1.isMember(member));
	}
	
	@Test
	public void isMemberTestcaseWithInput2()
	{
		IntSet i1 = new IntSet(new int[]{1,2,3,4,5,6,7,8,9,10,121});
		int member=7;
		boolean expected = true;
		assertEquals(expected, i1.isMember(member));
	}
	
	@Test
	public void isMemberTestcaseWithInput3()
	{
		IntSet i1 = new IntSet(new int[]{1,2,3,4,5,6,7,8,9,10,121});
		int member=123;
		boolean expected = false;
		assertEquals(expected, i1.isMember(member));
	}
	
	@Test
	public void isMemberTestcaseWithNullSet()
	{
		IntSet i1 = new IntSet(new int[]{});
		int member=123;
		boolean expected = false;
		assertEquals(expected, i1.isMember(member));
	}
	
	@Test
	public void isSubsetTestcaseWithInput1()
	{
		IntSet i1 = new IntSet(new int[]{1,2,3,4,5,6,7,8,9,10,121});
		IntSet i2 = new IntSet(new int[]{1,2,3,4});
		boolean expected = true;
		assertEquals(expected, i1.isSubSet(i2));
	}
	
	@Test
	public void isSubsetTestcaseWithInput2()
	{
		IntSet i1 = new IntSet(new int[]{1,2,3,4,5,6,7,8,9,10,121});
		IntSet i2 = new IntSet(new int[]{1,2,3,4,190});
		boolean expected = false;
		assertEquals(expected, i1.isSubSet(i2));
	}
	
	@Test
	public void isSubsetTestcaseWithNullInput()
	{
		IntSet i1 = new IntSet(new int[]{1,2,3,4,5,6,7,8,9,10,121});
		IntSet i2 = new IntSet(new int[]{});
		boolean expected = true;		//as empty set is subset of every set
		assertEquals(expected, i1.isSubSet(i2));
	}
	
	@Test
	public void isSubsetTestcaseWithInput3()
	{
		IntSet i1 = new IntSet(new int[]{1,2,3,4,5,6,7,8,9,10,121});
		IntSet i2 = new IntSet(new int[]{1,2,3,4,5,6,7,8,9,10,121,123});
		boolean expected = false;		
		assertEquals(expected, i1.isSubSet(i2));
	}
	
	@Test 
	public void getComplementTestcaseWithInput1()
	{
		IntSet i1 = new IntSet(new int[]{1,2,3,4,5,6,7,8,9,10,11});
		int complement[]=new int[989];
		for(int i=0;i<989;i++)
		{
			complement[i]=i+12;
		}
		assertArrayEquals(complement , i1.getComplement());
	}
	
	@Test 
	public void getComplementTestcaseWithInput2()
	{
		int input[] = new int[100];
		for(int i=0;i<100;i++)
			input[i]=i+1;
		IntSet i1 = new IntSet(input);
		int complement[]=new int[900];
		for(int i=0;i<900;i++)
		{
			complement[i]=i+101;
		}
		int output[]=i1.getComplement();
		assertArrayEquals(complement , output);
	}
	
	@Test 
	public void getComplementTestcaseWithInput3()
	{
		int input[] = new int[1000];
		for(int i=0;i<1000;i++)
			input[i]=i+1;
		IntSet i1 = new IntSet(input);
		int complement[]=new int[0];
		int output[]=i1.getComplement();
		assertArrayEquals(complement , output);
	}
	
	@Test 
	public void getComplementTestcaseWithNullSet()
	{
		IntSet i1 = new IntSet(new int[]{});
		int complement[]=new int[1000];
		for(int i=0;i<1000;i++)
		{
			complement[i]=i+1;
		}
		assertArrayEquals(complement , i1.getComplement());
	}
	
	@Test 
	public void unionTestcaseWithInput1()
	{
		IntSet i1 = new IntSet(new int[]{1,2,3,4,5,6});
		IntSet i2 = new IntSet(new int[]{1,2,7,8,9});
		int union[]=new int[9];
		for(int i=0;i<9;i++)
		{
			union[i]=i+1;
		}
		assertArrayEquals(union , IntSet.union(i1,i2));
	}
	
	@Test 
	public void unionTestcaseWithInput2()
	{
		IntSet i1 = new IntSet(new int[]{1,2,3,4,5,6,7});
		IntSet i2 = new IntSet(new int[]{8,9,10,11,12});
		int union[]=new int[12];
		for(int i=0;i<12;i++)
		{
			union[i]=i+1;
		}
		assertArrayEquals(union , IntSet.union(i1,i2));
	}
	
	@Test 
	public void unionTestcaseWithNullInput()
	{
		IntSet i1 = new IntSet(new int[]{1,2,3,4,5,6,7});
		IntSet i2 = new IntSet(new int[]{});
		int union[]=new int[7];
		for(int i=0;i<7;i++)
		{
			union[i]=i+1;
		}
		assertArrayEquals(union , IntSet.union(i1,i2));
	}
	
	
}
