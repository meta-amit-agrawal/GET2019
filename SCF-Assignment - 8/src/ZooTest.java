import static org.junit.Assert.*;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;

import org.junit.Test;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ZooTest {

	Zoo zoo = new Zoo(5); // initializing zoo with 5 zones
	@Test
    public void firstTest()throws Exception 
    {
			
		
		
			//adding the zone mammal type in zoo
			assertTrue(zoo.addZone( Utility.typeMammal,3, true, true));
			
			
			
			//adding the cage in the zone mammal
			assertTrue(zoo.addCage("Lion", Utility.typeMammal, 2));
			
			
			
			//adding of two animals in cage created above
			assertTrue(zoo.addAnimal(new Lion("Lion1" , 10 , 40)));
			assertTrue(zoo.addAnimal(new Lion("Lion2" , 16 , 50)));
			
			
			
			//here new cage will be allocated automatically on zone mammal of type elephant
			assertTrue(zoo.addAnimal(new Elephant("elephant-1" , 12 , 40)));
			
			
			// will show the message to add the zone as zone of bird is not added in Zoo
			try
			{
				assertFalse(zoo.addAnimal(new Sparrow("Sparrow-1" ,10 ,13)));
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage()); 
			}
			
			
			
			//adding zone of bird type in zoo
			assertTrue(zoo.addZone(Utility.typeBird , 2 , true , false));
			
			
			
			// animal will be added in zoo as zone of bird is present
			try
			{
				assertTrue(zoo.addAnimal(new Sparrow("Sparrow-1" ,10 ,13))); 
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			
			
			
			// will show the message to add the zone as zone of snake is not added in Zoo
			try
			{
				assertTrue(zoo.addAnimal(new Snake("Snake-1" ,10 ,13)));
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage()); 
			}
			
			
			//adding zone of reptile in zoo
			assertTrue(zoo.addZone(Utility.typeReptile, 2, false, true));
			
			
			//adding cage of type snake in zone reptile in zoo
			assertTrue(zoo.addCage("Snake", Utility.typeReptile, 3));
			
			// snake will be added in the cage as the zone of type reptile is present
			try
			{
				assertTrue(zoo.addAnimal(new Snake("Snake-1" ,10 ,13)));
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage()); 
			}
			
			
			//remove the animal lion from the cage
			assertTrue(zoo.removeAnimal(new Lion("Lion1" , 10 , 40)));
			
			//Returning false because elephant is not present in the zoo
			assertFalse(zoo.removeAnimal(new Elephant("elephant" ,20,30)));
			
	}

   
}