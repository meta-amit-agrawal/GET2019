import java.util.ArrayList;
import java.util.List;


public class Cages 
{
	String typeOfAnimal;
	int cage_capacity,numberOfAnimals;
	static int cage_id =1;
	List<Animal> listOfAnimals = new ArrayList<Animal>();
	
	public Cages(String typeOfAnimal , int cage_capacity , int numberOfAnimals )
	{
		this.typeOfAnimal = typeOfAnimal;
		this.cage_capacity = cage_capacity;
		this.numberOfAnimals = numberOfAnimals;
		cage_id++;
	}
	
	public int getMaxCapacity()
	{
		return cage_capacity;
	}
	
	public int getID()
	{
		return cage_id;
	}
	
	
}
