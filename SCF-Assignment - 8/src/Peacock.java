/*
* Peacock class is the subclass of bird class 
*/

class Peacock extends Bird 
{

    /*
    * Parameterized constructor to initialize the attribute of peacock
    */
	Peacock(String animalName, int ageOfAnimal, double weightOfAnimal) {
		super(animalName , ageOfAnimal , weightOfAnimal , "Scream");
//		this.animalName = animalName;
//		this.animalAge = ageOfAnimal;
//		this.animalWeight = weightOfAnimal;
//		soundOfAnimal = "Scream";
	}
 }

