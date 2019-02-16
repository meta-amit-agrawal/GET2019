/*
* Animal class is the base class which contains some common properties on animal
*/

public class Animal {
	String animalName;
	int animalAge;
	double animalWeight;
	String soundOfAnimal;
	String categoryOfAnimal;
	
	//parameterized constructor to initialize the properties on animal class
	public Animal(String name , int age , double weight , String sound , String typeOfAnimal)
	{
		animalAge = age;
		animalName = name;
		animalWeight = weight;
		soundOfAnimal = sound;
		categoryOfAnimal = typeOfAnimal;
	}
	
	//return the animal age 
	public int getAgeOfAnimal() {
		return animalAge;
	}

	//returns the name of the animal
	public String getAnimalName() {
		return animalName;
	}

	//returns the category of animal
	public String getCategoryOfAnimal() {
		return categoryOfAnimal;
	}

	//returns the sound of the animal
	public String getSoundOfAnimal() {
		return soundOfAnimal;
	}

	//returns the weight of the animal
	public double getWeightOfAnimal() {
		return animalWeight;
	}


}
