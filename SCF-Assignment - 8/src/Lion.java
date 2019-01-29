/*
* Lion class is the subclass of Mammal class
*/

class Lion extends Mammal {

    /*
    * Parameterized constructor to initialize Lion attribute
    */
	Lion(String animalName, int ageOfAnimal, double weightOfAnimal) {
		
		super(animalName , ageOfAnimal , weightOfAnimal , "Roars");
		
//		this.animalName = animalName;
//		this.animalAge = ageOfAnimal;
//		this.animalWeight = weightOfAnimal;
//		soundOfAnimal = "Roars";
	}
}
