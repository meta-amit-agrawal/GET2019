import java.util.ArrayList;
import java.util.List;

/*
* Cage class provides the Cage with limited capacity for the animal
*/

public class Cage {
	int noOfAnimals=0;
	String typeOfAnimal;
	int zoneNo;
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
    *  getAnimal method for get the list of all animal in a cage
    */
//	void getAnimal(int cageNo) {
//		for (int i = 0; i < Zoo.animalList.size(); i++) {
//			if (Zoo.animalList.get(i).getCageNo() == cageNo) {
//				System.out.println(Zoo.animalList.get(i).getAnimalName());
//			}
//		}
//	}

	boolean addAnimal(Animal animal)
	{
		for(int index=0;index<animalList.size();index++)
		{
			if(animalList.get(index).getAnimalName().equals(animal.getAnimalName()))
			{
				return false;
			}
		}

		animalList.add(animal);
		noOfAnimals += 1;
		return true;
		
	}
	
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
	
	/*public void setNoOfAnimals(int noOfAnimals) {
		this.noOfAnimals = noOfAnimals;
	}*/

	public int getMaxNoOfAnimals() {
		return maxNoOfAnimals;
	}

	public int getNoOfAnimals() {
		return noOfAnimals;
	}

	public String getTypeOfAnimal() {
		return typeOfAnimal;
	}

	public int getZoneNo() {
		return zoneNo;
	}
}