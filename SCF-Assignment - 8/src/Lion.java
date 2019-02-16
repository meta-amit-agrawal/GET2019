/*
* Lion class is the subclass of Mammal class and also inherits the properties of Animal class
*/

class Lion extends Mammal {

    /*
    * Parameterized constructor to initialize Lion attribute
    */
	Lion(String animalName, int ageOfAnimal, double weightOfAnimal)
	{
		
		super(animalName , ageOfAnimal , weightOfAnimal , "Roars");

	}
}
