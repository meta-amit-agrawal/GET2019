import java.util.ArrayList;
import java.util.List;

/*
* Cage class provides the Cage with limited capacity for the animal
*/

public class Cage {
	int noOfAnimals=0;
	String typeOfAnimal;
	int maxNoOfAnimals;
	String categoryofAnimal;
	List<Animal> animalList = new ArrayList<Animal>(); 
	
	
    /*
    * Parameterized constructor to initialize cage attributes
    */
	public Cage( String typeOfAnimal, String categryofAnimal, int maxNoOfAnimals) {
		this.typeOfAnimal = typeOfAnimal;
		this.categoryofAnimal = categryofAnimal;
		this.maxNoOfAnimals = maxNoOfAnimals;
	}

	/*
	 * addAnimal to add the animal to the cage 
	 * @param requires an object of animal which is to be added
	 * @return true if animal is added or false if same name already exist in cage
	 */
	boolean addAnimal(Animal animal)
	{
		for(int index=0;index<animalList.size();index++)
		{
			//checks for the same name of animal already exist or not
			if(animalList.get(index).getAnimalName().equals(animal.getAnimalName()))
			{
				return false;
			}
		}

		animalList.add(animal);
		noOfAnimals += 1;
		return true;
		
	}
	
	//deathAnimal to remove the animal after the death of the animal, requires an object of animal class which contain the animal 
	//to be deleted
	boolean deathAnimal(Animal animal)
	{

		for(int index=0;index<animalList.size();index++)
		{
			if(animalList.get(index).getAnimalName().equals(animal.getAnimalName()))
			{
				animalList.remove(animal);
				noOfAnimals -= 1;
				return true;
			}
		}

		return false;
	}

}