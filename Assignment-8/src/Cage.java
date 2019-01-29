import java.util.ArrayList;
import java.util.List;


public class Cage 
{
	String typeOfAnimal,animalCategory;
	final int cage_capacity;
	int spareCapacity;
	static int cage_id =1;
	List<Animal> listOfAnimals = new ArrayList<Animal>();
	
	public Cage(String typeOfAnimal , int cage_capacity)
	{
		this.typeOfAnimal = typeOfAnimal;
		this.cage_capacity = cage_capacity;
		cage_id++;
		this.spareCapacity = cage_capacity;
	}
	
	public int getMaxCapacity()
	{
		return cage_capacity;
	}
	
	public int getID()
	{
		return cage_id;
	}
	
	public boolean isSpaceAvailable()
	{
		if(spareCapacity != 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public int getAvailableSpace()
	{
		if(isSpaceAvailable())
		{
			return spareCapacity;
		}
		return 0;
	}
	
	public boolean addAnimal(Animal animal)
	{
		if(this.typeOfAnimal.equalsIgnoreCase(animal.getTypeOfAnimal())   )
		{
			if(isSpaceAvailable())
			{
				listOfAnimals.add(animal);
				spareCapacity--;
				return true;
			}
			else
			{
				throw new AssertionError("Cage is full");
			}
		}
		else
		{
			throw new AssertionError("This category can't be added to this cage");
		}
	}
	
	public String getCategory()
	{
		return typeOfAnimal;
	}
	
	
}