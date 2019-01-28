import java.util.ArrayList;
import java.util.List;


public class Cages 
{
	String typeOfAnimal;
	int cage_capacity = UtlityClass.numberOfAnimalsInOneCage;
	static int cage_id =1;
	List<Animal> listOfAnimals = new ArrayList<Animal>();
	
	
	public int getMaxCapacity()
	{
		return cage_capacity;
	}
	
	public int getID()
	{
		return cage_id;
	}
	
	
}
