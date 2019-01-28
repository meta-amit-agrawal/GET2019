import static org.junit.Assert.*;
import org.junit.Test;
public class PolynomialTest 
{
	@Test
	public void degreeTestcasewithInput1()
	{
		Polynomial p1=new Polynomial(new int[]{5,8,3});
		int expected =2;
		assertEquals(expected, p1.degree());
	}
	
	@Test
	public void degreeTestcaseWithInput2()
	{
		Polynomial p1=new Polynomial(new int[]{5,4,6,7,8,0,1});
		int expected = 6;
		assertEquals(expected, p1.degree());
	}
	
	@Test
	public void degreeTestcaseWithNullInput()
	{
		Polynomial p1=new Polynomial(new int[]{});
		int expected = 0;
		assertEquals(expected, p1.degree());
	}
	
	@Test
	public void degreeTestcaseWithInput3()
	{
		Polynomial p1=new Polynomial(new int[]{5,8,3,0,0,3});
		int expected =5;
		assertEquals(expected, p1.degree());
	}
	
	@Test
	public void evaluateTestCaseWithInput1()
	{
		Polynomial p1=new Polynomial(new int[]{5,8,3});
		float value=1;
		float expected =16.0f;
		assertEquals(expected, p1.evaluate(value),0);
	}
	
	@Test
	public void evaluateTestCaseWithInput2()
	{
		Polynomial p1=new Polynomial(new int[]{5,8,3});
		float value=-3;
		float expected =8.0f;
		assertEquals(expected, p1.evaluate(value),0);
	}
	
	@Test
	public void evaluateTestCaseWithInput3()
	{
		Polynomial p1=new Polynomial(new int[]{5,8,0,1});
		float value=0;
		float expected =5.0f;
		assertEquals(expected, p1.evaluate(value),0);
	}
	
	@Test
	public void addPolyTestcaseWithInput1()
	{
		Polynomial p1=new Polynomial(new int[]{5,8,3});
		Polynomial p2 = new Polynomial(new int[]{1,0,3,6});
		int result[] = new int[]{6,8,6,6};
		assertArrayEquals(result, Polynomial.addPoly(p1, p2));
	}
	
	@Test
	public void addPolyTestcaseWithInput2()
	{
		Polynomial p1=new Polynomial(new int[]{5,0,3});
		Polynomial p2 = new Polynomial(new int[]{});
		int result[] = new int[]{5,0,3};
		assertArrayEquals(result, Polynomial.addPoly(p1, p2));
	}
	
	@Test
	public void addPolyTestcaseWithInput3()
	{
		Polynomial p1=new Polynomial(new int[]{5,0,0});
		Polynomial p2 = new Polynomial(new int[]{1,2,3,4,5,6});
		int result[] = new int[]{6,2,3,4,5,6};
		assertArrayEquals(result, Polynomial.addPoly(p1, p2));
	}
	
	@Test
	public void mulPolyTestcaseWithInput1()
	{
		Polynomial p1=new Polynomial(new int[]{5,8,3});
		Polynomial p2 = new Polynomial(new int[]{1,2,3,6});
		int result[] = {5,18,34,60,57,18};
		assertArrayEquals(result, Polynomial.mulPoly(p1, p2));
	}
	
	@Test
	public void mulPolyTestcaseWithInput2()
	{
		Polynomial p1=new Polynomial(new int[]{5,8,3});
		Polynomial p2 = new Polynomial(new int[]{1,0,3,6});
		int result[] = {5,8,18,54,57,18};
		assertArrayEquals(result, Polynomial.mulPoly(p1, p2));
	}
	
	
}
