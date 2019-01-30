/*
* Elephant class is the subclass of Mammal class and also inherits the properties of Animal class
*/

class Elephant extends Mammal {

    /*
    * Parameterized constructor to initialize Lion attribute
    */
	Elephant(String animalName, int ageOfAnimal, double weightOfAnimal)
	{
		
		super(animalName , ageOfAnimal , weightOfAnimal , "Trumpet");

	}
}
