import static org.junit.Assert.*;
import org.junit.Test;

public class ZooTest {

	Zoo zoo = new Zoo(5);
    // Adding a new Zone for Mammals which has Canteen and Park both
	@Test
    public void addZoneTest() 
    {
		assertTrue(zoo.addZone( Utility.typeMammal,10, true, true));
	}

    // Adding a new Cage for Lion in Zone1 which has a Capacity of 5 Lion
	@Test
    public void addCageTest() throws Exception
    {
		assertTrue(zoo.addCage("Lion",Utility.typeMammal, 5));
	}

    // Adding peacock-4 in Cage3 whose age is 2years and weight is 8kgs
	@Test
    public void addAnimalTest() throws Exception
     {
		
		assertTrue(new Zoo().addAnimal("peacook-4", Utility.typePeacock, 2, 8, 3));
	}

    // Providing CategoryOfAnimal as Null
	@Test(expected = AssertionError.class)
    public void addZoneWithNullCategory()
    {
		
		try {
			new Zoo().addZone(10, null, true, true);
		} catch (Exception ex) {
			assertEquals("Category Of Animal in Zone Can't be Null",
					ex.getMessage());
		}
	}

    // Providing CategoryOfAnimal as Null
	@Test(expected=AssertionError.class)
    public void addCageWithNullCategory() throws Exception 
    {
		
			new Zoo().addCage(null, 4, 5);
		
		
	}

    // Providing CategoryOfAnimal as Null and Name of Animal as Zero length
	@Test(expected=AssertionError.class)
    public void addAnimalWithNullCategoryORName() throws Exception 
    {
	
			new Zoo().addAnimal(null, Utility.typeLion, 5, 34, 1);
	
	}

    // Adding Cage in a Full Zone i.e., No cage could be Added in this Zone
	@Test
    public void addCageInFullZone()
    {
        try 
        {
			new Zoo().addCage(Utility.typeCrocodile, 3, 5);
		} catch (Exception ex) {
			assertEquals("Zone is Full", ex.getMessage());
		}
	}

    // Adding Animal of Different Type to another Type of Cage i.e., Parrot
	@Test
    public void addAnimalWithDifferentTypeOfAnimal()
    {
		try {
			new Zoo().addAnimal("Parrot-4", Utility.typePeacock, 3, 20.5, 2);
		} catch (Exception ex) {
			assertEquals("This cage is not for the given type of Animal",
					ex.getMessage());
		}

	}

    // Adding Animal to a Full Cage i.e., Adding Snake to Cage 6 which is
		// already Full
	@Test
    public void addAnimalWithCageFull() 
    {
		try {
			new Zoo().addAnimal("Snake-4", Utility.typeCrocodile, 3, 20.5, 6);
		} catch (Exception ex) {
			assertEquals("Cage is Full, Can't add more animals",
					ex.getMessage());
		}
	}

    // Adding a new Animal whose Name is already in the System
	@Test
    public void addAnimalWithSameName()
    {
		try {
			new Zoo().addAnimal("Lion-1", Utility.typeLion, 20, 200, 1);
		} catch (Exception ex) {
			assertEquals("Animal Name should be Unique",
					ex.getMessage());
		}
	}
}