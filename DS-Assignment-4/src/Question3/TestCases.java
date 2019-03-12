package Question3;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCases 
{
	
	@Test
	public void testCase()
	{
		ChemicalAtomicMass chemicalAtomicMass = new ChemicalAtomicMass();
		try {
			assertEquals(29,chemicalAtomicMass.calculateMass("CHO"));
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testCaseWithSecondInput()
	{
		ChemicalAtomicMass chemicalAtomicMass = new ChemicalAtomicMass();
		try {
			assertEquals(45,chemicalAtomicMass.calculateMass("CHO2"));
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testCaseWithThirdInput()
	{
		ChemicalAtomicMass chemicalAtomicMass = new ChemicalAtomicMass();
		try {
			assertEquals(86,chemicalAtomicMass.calculateMass("CHOC(CH3)3"));
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void negativeTestCase()
	{
		ChemicalAtomicMass chemicalAtomicMass = new ChemicalAtomicMass();
		try {
			assertEquals(29,chemicalAtomicMass.calculateMass("CHA"));
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void negativeTestCase2()
	{
		ChemicalAtomicMass chemicalAtomicMass = new ChemicalAtomicMass();
		try {
			assertEquals(0,chemicalAtomicMass.calculateMass(""));
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
