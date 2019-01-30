/*
* Sparrow class is the subclass of Bird class and also inherits the properties of Animal class
*/

class Sparrow extends Bird {

    /*
    * Parameterized constructor to initialize Lion attribute
    */
	Sparrow(String animalName, int ageOfAnimal, double weightOfAnimal)
	{
		
		super(animalName , ageOfAnimal , weightOfAnimal , "Roars");

	}
}
