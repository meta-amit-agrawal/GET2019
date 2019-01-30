/*
* Snake class is the subclass of Reptile class and also inherits the properties of Animal class
*/

class Snake extends Reptile {

    /*
    * Parameterized constructor to initialize Lion attribute
    */
	Snake(String animalName, int ageOfAnimal, double weightOfAnimal)
	{
		
		super(animalName , ageOfAnimal , weightOfAnimal , "Hisss");

	}
}
