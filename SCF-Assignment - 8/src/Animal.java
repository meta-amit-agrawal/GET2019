/*
* Animal class is the base class 
*/

public class Animal {
	String animalName;
	int animalAge;
	double animalWeight;
	String soundOfAnimal;
	String categoryOfAnimal;
	
	public Animal(String name , int age , double weight , String sound , String typeOfAnimal)
	{
		animalAge = age;
		animalName = name;
		animalWeight = weight;
		soundOfAnimal = sound;
		categoryOfAnimal = typeOfAnimal;
	}
	

	public int getAgeOfAnimal() {
		return animalAge;
	}

	public String getAnimalName() {
		return animalName;
	}

	public String getCategoryOfAnimal() {
		return categoryOfAnimal;
	}

	public String getSoundOfAnimal() {
		return soundOfAnimal;
	}

	public double getWeightOfAnimal() {
		return animalWeight;
	}


}
