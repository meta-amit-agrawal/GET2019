/*
* Peacock class is the subclass of bird class and also inherits the properties of Animal class
*/

class Peacock extends Bird 
{

    /*
    * Parameterized constructor to initialize the attribute of peacock
    */
	Peacock(String animalName, int ageOfAnimal, double weightOfAnimal)
	{
		super(animalName , ageOfAnimal , weightOfAnimal , "Scream");
	}
 }

